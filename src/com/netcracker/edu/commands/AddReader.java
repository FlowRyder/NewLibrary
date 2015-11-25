package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.dao.MemoryDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class AddReader implements Command {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String login;
        System.out.println("Enter login of reader:");
        login = bufferedReader.readLine();
        Reader reader = MemoryDAO.getInstance().findReaderByLogin(login);
        if (reader == null) {
            reader.setLogin(login);
            System.out.println("Enter email of reader");
            String email = bufferedReader.readLine();
            reader.setEmail(email);
            System.out.println("Enter password of reader");
            String password = bufferedReader.readLine();
            reader.setEmail(password);
            MemoryDAO.getInstance().getReaders().add(reader);
        } else {
            System.out.println("Such reader has already added.");
        }
    }

    public String getName() {
        return "add_reader";
    }

    public String getHelp() {
        return "To add reader use:" + getName();
    }
}
