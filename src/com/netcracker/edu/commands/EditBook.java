package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Book;
import org.apache.log4j.Logger;

import static com.netcracker.edu.util.ExceptionCode.*;

import java.math.BigInteger;

/**
 * Created by FlowRyder.
 */
public class EditBook extends Command {
    public static final Logger LOGGER = Logger.getLogger(EditBook.class);
    public final int parametersNumber = 3;

    @Override
    public int execute(String[] parameters) {
        int result = checkLibrarian(parameters, parametersNumber);
        Book book;
        try {
            book = new Book(new BigInteger(parameters[2]));
            book.setId(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return IDNotANumber;
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return invalidNameValue;
        }
        if (!DAO.updateBook(book)) {
            LOGGER.info("Error: unsuccessfully query. Book hasn't been updated.");
            return unsuccessfullQuery;
        }
        if (result == success) {
            LOGGER.info("Book successfully edited.");
        }
        return result;
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
