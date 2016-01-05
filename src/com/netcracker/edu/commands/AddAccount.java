package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Check;
import com.netcracker.edu.util.Input;
import org.apache.log4j.Logger;

import java.util.Calendar;

/**
 * Created by FlowRyder on 29.11.2015.
 */
public class AddAccount extends CommandAdd {
    public static final Logger LOGGER = Logger.getLogger(AddAccount.class);

    @Override
    public Account create(String[] parameters) throws NumberFormatException {
        Reader reader = (Reader) FileDAO.getInstance().choose(MemoryDAO.getInstance().getReaders(), Integer.parseInt(parameters[1]));
        Book book = (Book) FileDAO.getInstance().choose(MemoryDAO.getInstance().getBooks(), Integer.parseInt(parameters[2]));
        Calendar issueDate = Input.readDate(Integer.parseInt(parameters[3]), Integer.parseInt(parameters[4]), Integer.parseInt(parameters[5]));
        Calendar returnDate = Input.readDate(Integer.parseInt(parameters[6]), Integer.parseInt(parameters[7]), Integer.parseInt(parameters[8]));
        return new Account(reader, book, issueDate, returnDate);
    }

    @Override
    public void execute(String[] parameters) {
        if(Check.access()) {
            return;
        }
        if (parameters.length != 9) {
            LOGGER.info("Error: wrong number of parameters");
            LOGGER.info("Account was not added.");
            return;
        }
        FileDAO.getInstance().getAccounts().add(create(parameters));
        LOGGER.info("Account was successfully added");
    }

    @Override
    public String getName() {
        return "add_account";
    }

    @Override
    public String getHelp() {
        return "to add account input" + getName() + "reader_id book_id issueDate(day_month_year) returnDate(day_month_year)";
    }
}
