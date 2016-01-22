package com.netcracker.edu.commands;

import org.apache.log4j.Logger;

import static com.netcracker.edu.util.ExceptionCode.*;

import java.math.BigInteger;

/**
 * Created by FlowRyder
 */
public class DeleteAuthor extends Command {
    public static final Logger LOGGER = Logger.getLogger(DeleteAuthor.class);
    public final int parametersNumber = 2;

    @Override
    public int execute(String[] parameters) {
        int result = checkLibrarian(parameters, parametersNumber);
        try {
            if (!DAO.deleteAuthor(new BigInteger(parameters[1]))) {
                LOGGER.warn("Error: Unsuccessful delete.");
                return unsuccessfullDelete;
            }
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return IDNotANumber;
        }
        if (result == success) {
            LOGGER.info("Author successfully deleted.");
        }
        return result;
    }

    @Override
    public String getName() {
        return "delete_author";
    }

    @Override
    public String getHelp() {
        return "to delete author use " + getName() + " author_id" + "\n"
                + "Example: delete_author 27";
    }
}
