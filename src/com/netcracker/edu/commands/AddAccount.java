package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by FlowRyder
 */
public class AddAccount extends Command {
    public static final Logger LOGGER = Logger.getLogger(AddAccount.class);
    public int parametersNumber = 8;

    @Override
    public int execute(String[] parameters) throws SQLException {
        if (Context.getLoggedHolder() == null) {
            LOGGER.warn("Error: User isn't logged in.");
            return 1;
        }
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return 3;
        }
        Account account;
        Calendar issueDateCalendar = Calendar.getInstance();
        Calendar returnDateCalendar = Calendar.getInstance();
        try {
            issueDateCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parameters[2]));
            issueDateCalendar.set(Calendar.MONTH, Integer.parseInt(parameters[3]));
            issueDateCalendar.set(Calendar.YEAR, Integer.parseInt(parameters[4]));
            returnDateCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parameters[5]));
            returnDateCalendar.set(Calendar.MONTH, Integer.parseInt(parameters[6]));
            returnDateCalendar.set(Calendar.YEAR, Integer.parseInt(parameters[7]));
            account = new Account(Context.getLoggedHolder().getId(),
                    new BigInteger(parameters[1]),
                    new Date(issueDateCalendar.getTimeInMillis()), new Date(returnDateCalendar.getTimeInMillis()));
        } catch (NullPointerException e) {
            LOGGER.warn("Error: ID shouldn't be null or negative value.");
            return 5;
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: Date should have number format.");
            return 17;
        }
        if (!dao.addAccount(account)) {
            LOGGER.info("Error: unsuccessfully query. Book type hasn't been added.");
            return 18;
        }
        LOGGER.info("Account was successfully added");
        return 0;
    }

    @Override
    public String getName() {
        return "add_account";
    }

    @Override
    public String getHelp() {
        return "to add account use" + getName() + "book_id issueDate(day_month_year) " +
                "returnDate(day_month_year)" + "\n" + "Example add_account 12 35 17 05 2016 18 06 2017";
    }
}
