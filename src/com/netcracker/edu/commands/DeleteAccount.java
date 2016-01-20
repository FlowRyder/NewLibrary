package com.netcracker.edu.commands;

import org.apache.log4j.Logger;

import static com.netcracker.edu.util.ExceptionCode.*;

import java.math.BigInteger;

/**
 * Created by FlowRyder
 */
public class DeleteAccount extends Command {
    public static final Logger LOGGER = Logger.getLogger(DeleteAccount.class);
    public final int parametersNumber = 2;

    @Override
    public int execute(String[] parameters) {
        int result = checkLibrarian(parameters);
        try {
            if (!DAO.deleteAccount(new BigInteger(parameters[1]))) {
                LOGGER.warn("Error: Unsuccessful delete.");
                return unsuccessfullDelete;
            }
        } catch (NumberFormatException e) {
            LOGGER.info("Error: ID should be number.");
            return IDNotANumber;
        }
        if (result == success) {
            LOGGER.info("Account successfully deleted.");
        }
        return result;
    }

    @Override
    public String getName() {
        return "delete_account";
    }

    @Override
    public String getHelp() {
        return "to delete account use " + getName() + " account_id" + "\n"
                + "Example: delete_account 110";
    }
}
