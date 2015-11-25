package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.dao.MemoryDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class EditReader implements Command {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String login;
        System.out.println("Enter login of reader:");
        login = bufferedReader.readLine();
        Reader reader = MemoryDAO.getInstance().findReaderByLogin(login);
        if (reader != null) {
            MemoryDAO.getInstance().getReaders().remove(reader);
            System.out.println("Enter email of reader");
            String email = bufferedReader.readLine();
            reader.setEmail(email);
            System.out.println("Enter password of reader");
            String password = bufferedReader.readLine();
            reader.setEmail(password);
            MemoryDAO.getInstance().getReaders().add(reader);
            System.out.println("Reader was successfully edited.");
        } else {
            System.out.println("There is no such reader.");
        }
    }

    public String getName() {
        return "edit_reader";
    }

    public String getHelp() {
        return "To edit reader use:" + getName();
    }
}
