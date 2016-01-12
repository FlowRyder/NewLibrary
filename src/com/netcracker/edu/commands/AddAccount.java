package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.util.Calendar;

/**
 * Created by FlowRyder
 */
public class AddAccount extends Command {
    public static final Logger LOGGER = Logger.getLogger(AddAccount.class);
    public int parametersNumber = 9;

    @Override
    public int execute(String[] parameters) {
        if (Context.getLoggedHolder() == null) {
            LOGGER.warn("Error: User isn't logged in.");
            return 1;
        }
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return 3;
        }
        Account account;
        Calendar issueDate = Calendar.getInstance();
        issueDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parameters[3]));
        issueDate.set(Calendar.MONTH, Integer.parseInt(parameters[4]));
        issueDate.set(Calendar.YEAR, Integer.parseInt(parameters[5]));
        Calendar returnDate = Calendar.getInstance();
        returnDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parameters[6]));
        returnDate.set(Calendar.MONTH, Integer.parseInt(parameters[7]));
        returnDate.set(Calendar.YEAR, Integer.parseInt(parameters[8]));
        try {
            account = new Account(new BigInteger(parameters[1]),
                    new BigInteger(parameters[2]), issueDate, returnDate);
        } catch (NullPointerException e) {
            LOGGER.warn("Error: ID shouldn't be null or negative value.");
            return 5;
        }
        FileDAO.getInstance().addAccount(account);
        LOGGER.info("Account was successfully added");
        return 0;
    }

    @Override
    public String getName() {
        return "add_account";
    }

    @Override
    public String getHelp() {
        return "to add account use" + getName() + "reader_id book_id issueDate(day_month_year) " +
                "returnDate(day_month_year)" + "\n" + "Example add_account 12 35 17 05 2016 18 06 2017";
    }
}
