package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.businessobjects.Librarian;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by FlowRyder
 */
public class AddBook extends Command {
    public static final Logger LOGGER = Logger.getLogger(AddBook.class);
    public int parametersNumber = 2;
    public Class classAccess = Librarian.class;

    @Override
    public int execute(String[] parameters) throws IOException {
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
            book = new Book(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID shouldn't be null or negative value.");
            return 5;
        }
        FileDAO.getInstance().addBook(book);
        LOGGER.info("Book successfully added.");
        return 0;
    }

    @Override
    public String getName() {
        return "add_book";
    }

    @Override
    public String getHelp() {
        return "to add book use " + getName() + "bookType_id" + "\n"
                + "Example: add_book 17";
    }
}
