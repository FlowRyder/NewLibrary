package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 14.11.2015.
 */
public class DeleteAccount extends Command {
    public static final Logger LOGGER = Logger.getLogger(DeleteAccount.class);

    @Override
    public void execute(String[] parameters) throws IOException {
        Account account = (Account) FileDAO.getInstance().choose(FileDAO.getInstance().getAccounts(), Integer.parseInt(parameters[1]));
        FileDAO.getInstance().getAccounts().remove(account);
        account.setIsActual(false);
        FileDAO.getInstance().getAccounts().add(account);
        LOGGER.info("Account successfully deleted.");
    }

    @Override
    public String getName() {
        return "delete_account";
    }

    @Override
    public String getHelp() {
        return "to delete account use " + getName() + " account_id";
    }
}
