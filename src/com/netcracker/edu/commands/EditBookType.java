package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.sql.SQLException;

/**
 * Created by FlowRyder.
 */
public class EditBookType extends Command {
    public static final Logger LOGGER = Logger.getLogger(EditBookType.class);
    public int parametersNumber = 5;

    @Override
    public int execute(String[] parameters) throws SQLException {
        if (Context.getLoggedHolder() == null) {
            LOGGER.warn("Error: User isn't logged in.");
            return 1;
        }
        if (!Context.getLoggedHolder().getRights()) {
            LOGGER.warn("Error: Access only for librarians.");
            return 2;
        }
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return 3;
        }
        BookType bookType;
        try {
            bookType = new BookType(parameters[2],new BigInteger(parameters[3]),new BigInteger(parameters[4]));
            bookType.setId(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return 4;
        }
        if(!dao.updateBookType(bookType)) {
            LOGGER.info("Error: unsuccessfully query. Book type hasn't been updated.");
            return 18;
        }
        LOGGER.info("Book type successfully edited.");
        return 0;
    }

    @Override
    public String getName() {
        return "edit_bookType";
    }

    @Override
    public String getHelp() {
        return "to edit book type use " + getName() + " bookType_id bookType_name  genre_id author_id" + "\n"
                + "Example: edit_bookType 31 75 40";
    }
}
