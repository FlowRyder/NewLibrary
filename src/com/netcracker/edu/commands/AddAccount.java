package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Input;
import org.apache.log4j.Logger;

import java.util.Calendar;

/**
 * Created by FlowRyder on 29.11.2015.
 */
public class AddAccount extends CommandAdd {
    public static final Logger LOGGER = Logger.getLogger(AddAccount.class);

    @Override
    public Account create() {
        LOGGER.info("Choose reader:");
        Reader reader = (Reader) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getReaders());
        LOGGER.info("Choose book:");
        Book book = (Book) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getBooks());
        LOGGER.info("Enter issue date:");
        Calendar issueDate = Input.readDate();
        LOGGER.info("Enter return date:");
        Calendar returnDate = Input.readDate();
        return new Account(reader, book, issueDate, returnDate);
    }

    @Override
    public void execute() {
        MemoryDAO.getInstance().getAccounts().add(create());
        LOGGER.info("Account was successfully added");
    }

    @Override
    public String getName() {
        return "add_account";
    }

    @Override
    public String getHelp() {
        return "to add account use" + getName();
    }
}
