package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Book;
import static com.netcracker.edu.util.ExceptionCode.*;
import org.apache.log4j.Logger;

import java.math.BigInteger;

/**
 * Created by FlowRyder
 */
public class AddBook extends Command {
    public static final Logger LOGGER = Logger.getLogger(AddBook.class);
    public final int parametersNumber = 2;

    @Override
    public int execute(String[] parameters) {
        int result = checkLibrarian(parameters, parametersNumber);
        Book book;
        try {
            book = new Book(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID shouldn't be null or negative value.");
            return invalidIDValue;
        }
        if (!DAO.addBook(book)) {
            LOGGER.info("Error: unsuccessfully query. Book hasn't been added.");
            return unsuccessfullQuery;
        }
        if(result == success) {
            LOGGER.info("Book successfully added.");
        }
        return result;
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
