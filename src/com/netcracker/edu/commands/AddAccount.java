package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import com.netcracker.edu.session.Context;
import static com.netcracker.edu.util.ExceptionCode.*;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by FlowRyder
 */
public class AddAccount extends Command {
    public static final Logger LOGGER = Logger.getLogger(AddAccount.class);
    public final int parametersNumber = 8;

    @Override
    public int execute(String[] parameters) {
        int result = checkReader(parameters, parametersNumber);
        Account account;
        Calendar issueDate = Calendar.getInstance();
        Calendar returnDate = Calendar.getInstance();
        //todo: Looks to complicated and code duplicated, maybe should perform method for set calendar
        //todo: I don't like to use index(some "magic numbers"), should be fix.
        try {
            issueDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parameters[3]));
            issueDate.set(Calendar.MONTH, Integer.parseInt(parameters[4]));
            issueDate.set(Calendar.YEAR, Integer.parseInt(parameters[5]));
            returnDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parameters[6]));
            returnDate.set(Calendar.MONTH, Integer.parseInt(parameters[7]));
            returnDate.set(Calendar.YEAR, Integer.parseInt(parameters[8]));
            account = new Account(Context.getLoggedHolder().getId(),
                    new BigInteger(parameters[2]),
                    new Date(issueDate.getTimeInMillis()), new Date(returnDate.getTimeInMillis()));
        } catch (NullPointerException e) {
            LOGGER.warn("Error: ID shouldn't be null or negative value.");
            return invalidIDValue;
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: Date should have number format.");
            return invalidDateFormat;
        }
        if (!DAO.addAccount(account)) {
            LOGGER.info("Error: unsuccessfully query. Book type hasn't been added.");
            return unsuccessfullQuery;
        }
        if (result == success) {
            LOGGER.info("Account was successfully added");
        }
        return result;
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
