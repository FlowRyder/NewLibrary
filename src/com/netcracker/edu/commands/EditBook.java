package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.businessobjects.Librarian;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.math.BigInteger;

/**
 * Created by FlowRyder.
 */
public class EditBook extends Command {
    public static final Logger LOGGER = Logger.getLogger(EditBook.class);
    public int parametersNumber = 3;
    public Class classAccess = Librarian.class;

    @Override
    public int execute(String[] parameters) {
        if (Context.getLoggedHolder() == null) {
            LOGGER.warn("Error: User isn't logged in.");
            return 1;
        }
        if (!Context.getLoggedHolder().getClass().equals(classAccess)) {
            LOGGER.warn("Error: Access only for librarians.");
            return 2;
        }
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return 3;
        }
        Book book;
        try {
            book = FileDAO.getInstance().loadBook(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        }
        if (book == null) {
            LOGGER.warn("Error: Wrong ID.");
            return 16;
        }
        try {
            book.setBookTypeID(BigInteger.valueOf(Long.getLong(parameters[2])));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        }
        FileDAO.getInstance().updateBook(book);
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
