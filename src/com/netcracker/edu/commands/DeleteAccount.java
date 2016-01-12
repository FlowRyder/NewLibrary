package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import com.netcracker.edu.businessobjects.Librarian;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.math.BigInteger;

/**
 * Created by FlowRyder
 */
public class DeleteAccount extends Command {
    public static final Logger LOGGER = Logger.getLogger(DeleteAccount.class);
    public int parametersNumber = 2;
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
        Account account;
        try {
            account = FileDAO.getInstance().loadAccount(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        }
        if (account == null) {
            LOGGER.warn("Error: Wrong ID.");
            return 16;
        }
        if (!FileDAO.getInstance().deleteAccount(account)) {
            LOGGER.warn("Error: Unsuccessful delete.");
            return 15;
        }
        account.setIsActual(false);
        FileDAO.getInstance().addAccount(account);
        LOGGER.info("Account successfully deleted.");
        return 0;
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
