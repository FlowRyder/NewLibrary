package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.BookType;
import org.apache.log4j.Logger;

import static com.netcracker.edu.util.ExceptionCode.*;

import java.math.BigInteger;

/**
 * Created by FlowRyder.
 */
public class EditBookType extends Command {
    public static final Logger LOGGER = Logger.getLogger(EditBookType.class);
    public final int parametersNumber = 5;

    @Override
    public int execute(String[] parameters) {
        int result = checkLibrarian(parameters, parametersNumber);
        BookType bookType;
        try {
            bookType = new BookType(parameters[2], new BigInteger(parameters[3]), new BigInteger(parameters[4]));
            bookType.setId(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return IDNotANumber;
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return invalidNameValue;
        }
        if (!DAO.updateBookType(bookType)) {
            LOGGER.info("Error: unsuccessfully query. Book type hasn't been updated.");
            return unsuccessfullQuery;
        }
        if (result == success) {
            LOGGER.info("Book type successfully edited.");
        }
        return result;
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
