package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 14.11.2015.
 */
public class DeleteAccount extends CommandDelete {
    public static final Logger LOGGER = Logger.getLogger(DeleteAccount.class);

    @Override
    public Account choose() {
        LOGGER.info("Choose account");
        return (Account) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getAccounts());
    }

    @Override
    public void execute() throws IOException {
        Account account = choose();
        MemoryDAO.getInstance().getAccounts().remove(account);
        account.setIsActual(false);
        MemoryDAO.getInstance().getAccounts().add(account);
        LOGGER.info("Account successfully deleted.");
    }

    @Override
    public String getName() {
        return "delete_account";
    }

    @Override
    public String getHelp() {
        return "to delete account use " + getName();
    }
}
