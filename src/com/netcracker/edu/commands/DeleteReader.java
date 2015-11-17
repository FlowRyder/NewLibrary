package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.dao.MemoryDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteReader {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String login;
        System.out.println("Enter login of reader:");
        login = bufferedReader.readLine();
        Reader reader = MemoryDAO.getInstance().findReaderByLogin(login);
        if (reader != null) {
            MemoryDAO.getInstance().getReaders().remove(reader);
            System.out.println("Reader was successfully deleted.");
        } else {
            System.out.println("There is no such reader.");
        }
    }

    public String getName() {
        return "delete_reader";
    }

    public String getHelp() {
        return "To delete reader use:" + getName();
    }
}
