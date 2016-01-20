package com.netcracker.edu.commands;

import org.apache.log4j.Logger;

import static com.netcracker.edu.util.ExceptionCode.*;

import java.math.BigInteger;

/**
 * Created by FlowRyder
 */
public class DeleteBookType extends Command {
    public static final Logger LOGGER = Logger.getLogger(DeleteBookType.class);
    public final int parametersNumber = 2;

    @Override
    public int execute(String[] parameters) {
        int result = checkLibrarian(parameters);
        try {
            if (!DAO.deleteBookType(new BigInteger(parameters[1]))) {
                LOGGER.warn("Error: Unsuccessful delete.");
                return unsuccessfullDelete;
            }
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return IDNotANumber;
        }
        if (result == success) {
            LOGGER.info("Book type successfully deleted.");
        }
        return result;
    }

    @Override
    public String getName() {
        return "delete_bookType";
    }

    @Override
    public String getHelp() {
        return "to delete book type use " + getName() + " bookType_id" + "\n"
                + "Example: delete_bookType 28";
    }
}
