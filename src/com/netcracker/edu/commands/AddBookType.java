package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.dao.DAO;
import com.netcracker.edu.dao.DAOFactory;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.sql.SQLException;

/**
 * Created by FlowRyder
 */
public class AddBookType extends Command {
    public static final Logger LOGGER = Logger.getLogger(AddBookType.class);
    public int parametersNumber = 4;
    //todo ???????? ??? ??????????? ???? dao ? ???? ??????????? ?????? Command
    public DAO dao = DAOFactory.getDAO();

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
            bookType = new BookType(parameters[1], new BigInteger(parameters[2]),
                    new BigInteger(parameters[3]));
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return 4;
        } catch (NullPointerException e) {
            LOGGER.warn("Error: ID shouldn't be null or negative value.");
            return 5;
        }
        if (!dao.addBookType(bookType)) {
            LOGGER.info("Error: unsuccessfully query. Book type hasn't been added.");
            return 18;
        }
        LOGGER.info("Book type successfully added.");
        return 0;
    }

    @Override
    public String getName() {
        return "add_bookType";
    }

    @Override
    public String getHelp() {
        return "to add book type use " + getName() + " bookType_name  genre_id  author_id" + "\n"
                + "Example: Generation_Pi 8 34";
    }
}
