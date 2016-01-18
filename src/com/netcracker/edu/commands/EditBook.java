package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.dao.DAO;
import com.netcracker.edu.dao.DAOFactory;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.sql.SQLException;

/**
 * Created by FlowRyder.
 */
public class EditBook extends Command {
    public static final Logger LOGGER = Logger.getLogger(EditBook.class);
    public int parametersNumber = 3;

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
        Book book;
        try {
            book = new Book(new BigInteger(parameters[2]));
            book.setId(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return 4;
        }
        if (!dao.updateBook(book)) {
            LOGGER.info("Error: unsuccessfully query. Book hasn't been updated.");
            return 18;
        }
        LOGGER.info("Book successfully edited.");
        return 0;
    }

    @Override
    public String getName() {
        return "edit_book";
    }

    @Override
    public String getHelp() {
        return "to edit book use " + getName() + " book_id  bookType_id" + "\n"
                + "Example: edit_book 30 79";
    }
}
