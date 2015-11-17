package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Account;
import com.netcracker.edu.dao.MemoryDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 14.11.2015.
 */
public class DeleteAccount implements Command {

    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int id;
        System.out.println("Enter id of account:");
        try {
            id = Integer.getInteger(bufferedReader.readLine());
        } catch (NullPointerException e) {
            System.out.println("Invalid id format");
            return;
        }
        Account account = MemoryDAO.getInstance().findAccountByID(id);
        if (account != null) {
            account.setIsActual(false);
            System.out.println("Account was successfully deleted.");
        } else {
            System.out.println("There is no such account.");
        }
    }

    public String getName() {
        return "delete_account";
    }

    public String getHelp() {
        return "To delete account use:" + getName();
    }
}
