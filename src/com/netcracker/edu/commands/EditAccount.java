package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import org.apache.log4j.Logger;

import static com.netcracker.edu.util.ExceptionCode.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by FlowRyder
 */
public class EditAccount extends Command {
    public static final Logger LOGGER = Logger.getLogger(EditAccount.class);
    public final int parametersNumber = 10;

    @Override
    public int execute(String[] parameters) {
        int result = checkReader(parameters);
        Calendar issueDateCalendar = Calendar.getInstance();
        Calendar returnDateCalendar = Calendar.getInstance();
        try {
            issueDateCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parameters[4]));
            issueDateCalendar.set(Calendar.MONTH, Integer.parseInt(parameters[5]));
            issueDateCalendar.set(Calendar.YEAR, Integer.parseInt(parameters[6]));
            returnDateCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parameters[7]));
            returnDateCalendar.set(Calendar.MONTH, Integer.parseInt(parameters[8]));
            returnDateCalendar.set(Calendar.YEAR, Integer.parseInt(parameters[9]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: Date should have number format.");
            return invalidDateFormat;
        }
        Account account;
        try {
            account = new Account(BigInteger.valueOf(Long.getLong(parameters[2])),
                    BigInteger.valueOf(Long.getLong(parameters[3])),
                    new Date(issueDateCalendar.getTimeInMillis()), new Date(returnDateCalendar.getTimeInMillis()));
            account.setId(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return IDNotANumber;
        }
        if (!DAO.updateAccount(account)) {
            LOGGER.info("Error: unsuccessfully query. Account hasn't been updated.");
            return unsuccessfullQuery;
        }
        if (result == success) {
            LOGGER.info("Account successfully edited.");
        }
        return result;
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
