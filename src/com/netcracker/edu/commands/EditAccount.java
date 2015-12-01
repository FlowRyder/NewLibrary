package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Input;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by FlowRyder on 29.11.2015.
 */
public class EditAccount extends CommandEdit {
    public static final Logger LOGGER = Logger.getLogger(EditAccount.class);

    @Override
    public Account edit() {
        LOGGER.info("Choose account:");
        Account account = (Account) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getAccounts());
        MemoryDAO.getInstance().getAccounts().remove(account);
        LOGGER.info("Enter issue date:");
        account.setIssueDate(Input.readDate());
        LOGGER.info("Enter return date:");
        account.setReturnDate(Input.readDate());
        LOGGER.info("Choose book:");
        account.setBook((Book) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getBooks()));
        LOGGER.info("Choose reader:");
        account.setReader((Reader) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getReaders()));
        return account;
    }

    @Override
    public void execute() throws IOException {
        MemoryDAO.getInstance().getAccounts().add(edit());
        LOGGER.info("Account successfully edited.");
    }

    @Override
    public String getName() {
        return "edit_account";
    }

    @Override
    public String getHelp() {
        return "to edit account use " + getName();
    }
}
