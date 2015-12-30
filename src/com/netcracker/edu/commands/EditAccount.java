package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.dao.FileDAO;
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
    public Account edit(String[] parameters) {
        Account account = (Account) FileDAO.getInstance().choose(FileDAO.getInstance().getAccounts(), Integer.parseInt(parameters[1]));
        FileDAO.getInstance().getAccounts().remove(account);
        account.setIssueDate(Input.readDate(Integer.parseInt(parameters[4]), Integer.parseInt(parameters[5]), Integer.parseInt(parameters[6])));
        account.setReturnDate(Input.readDate(Integer.parseInt(parameters[7]), Integer.parseInt(parameters[8]), Integer.parseInt(parameters[9])));
        account.setBook((Book) FileDAO.getInstance().choose(FileDAO.getInstance().getBooks(), Integer.parseInt(parameters[3])));
        account.setReader((Reader) FileDAO.getInstance().choose(FileDAO.getInstance().getReaders(), Integer.parseInt(parameters[2])));
        return account;
    }

    @Override
    public void execute(String[] parameters) throws IOException {
        if (parameters.length != 10) {
            LOGGER.info("Wrong number of parameters.");
            return;
        }
        FileDAO.getInstance().getAccounts().add(edit(parameters));
        LOGGER.info("Account successfully edited.");
    }

    @Override
    public String getName() {
        return "edit_account";
    }

    @Override
    public String getHelp() {
        return "to edit account use " + getName() + "account_id reader_id book_id issueDate(day_month_year) returnDate(day_month_year)";
    }
}
