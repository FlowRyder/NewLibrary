package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Calendar;

/**
 * Created by FlowRyder
 */
public class EditAccount extends Command {
    public static final Logger LOGGER = Logger.getLogger(EditAccount.class);
    public int parametersNumber = 10;

    @Override
    public int execute(String[] parameters) throws IOException {
        if (Context.getLoggedHolder() == null) {
            LOGGER.warn("Error: User isn't logged in.");
            return 1;
        }
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return 3;
        }
        Account account;
        try {
            account = FileDAO.getInstance().loadAccount(BigInteger.valueOf(Long.getLong(parameters[1])));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        }
        if (account == null) {
            LOGGER.warn("Error: Wrong ID.");
            return 16;
        }
        try {
            account.setReaderID(BigInteger.valueOf(Long.getLong(parameters[2])));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        }
        try {
            account.setBookID(BigInteger.valueOf(Long.getLong(parameters[3])));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        }
        Calendar issueDate = Calendar.getInstance();
        try {
            issueDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parameters[4]));
            issueDate.set(Calendar.MONTH, Integer.parseInt(parameters[5]));
            issueDate.set(Calendar.YEAR, Integer.parseInt(parameters[6]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: Date should have number format.");
            return 17;
        }
        account.setIssueDate(issueDate);
        Calendar returnDate = Calendar.getInstance();
        try {
            returnDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parameters[7]));
            returnDate.set(Calendar.MONTH, Integer.parseInt(parameters[8]));
            returnDate.set(Calendar.YEAR, Integer.parseInt(parameters[9]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: Date should have number format.");
            return 17;
        }
        account.setReturnDate(returnDate);
        FileDAO.getInstance().updateAccount(account);
        LOGGER.info("Account successfully edited.");
        return 0;
    }

    @Override
    public String getName() {
        return "edit_account";
    }

    @Override
    public String getHelp() {
        return "to edit account use " + getName() + "account_id reader_id book_id " +
                "issueDate(day month year) returnDate(day month year)" + "\n"
                + "Example: edit_account 107 34 89 12 12 2017 10 01 2018";
    }
}
