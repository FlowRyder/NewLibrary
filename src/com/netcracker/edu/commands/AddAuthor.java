package com.netcracker.edu.commands;


import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class AddAuthor implements Command {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name of author:");
        String name = bufferedReader.readLine();
        if (Check.containAuthor(name)) {
            System.out.println("Author already exists.");
            return;
        } else {
            Author author = new Author(name);
            MemoryDAO.getInstance().getAuthors().add(author);
        }
    }

    public String getName() {
        return "add_author";
    }

    public String getHelp() {
        return "To add author use:" + getName();
    }
}
