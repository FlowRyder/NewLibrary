package com.netcracker.edu.commands;

import org.apache.log4j.Logger;

import static com.netcracker.edu.util.ExceptionCode.*;

import java.math.BigInteger;

/**
 * Created by FlowRyder
 */
public class DeleteBook extends Command {
    public static final Logger LOGGER = Logger.getLogger(DeleteBook.class);
    public final int parametersNumber = 2;

    @Override
    public int execute(String[] parameters) {
        int result = checkLibrarian(parameters, parametersNumber);
        try {
            if (!DAO.deleteBook(new BigInteger(parameters[1]))) {
                LOGGER.warn("Error: Unsuccessful delete.");
                return unsuccessfullDelete;
            }
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return IDNotANumber;
        }
        if (result == success) {
            LOGGER.info("Book successfully deleted.");
        }
        return result;
    }

    @Override
    public String getName() {
        return "delete_book";
    }

    @Override
    public String getHelp() {
        return "to delete book use " + getName() + " book_id" + "\n"
                + "Example: delete_book 11";
    }
}
