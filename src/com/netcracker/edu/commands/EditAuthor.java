package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.dao.MemoryDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class EditAuthor implements Command {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        System.out.println("Enter name of author:");
        name = bufferedReader.readLine();
        Author author = MemoryDAO.getInstance().findAuthorByName(name);
        if (author != null) {
            String newName;
            System.out.println("Enter new name of author:");
            newName = bufferedReader.readLine();
            author.setName(newName);
            MemoryDAO.getInstance().getAuthors().remove(author);
            MemoryDAO.getInstance().getAuthors().add(author);
            System.out.println("Author was successfully edited.");
        } else {
            System.out.println("There is no such author.");
        }
    }

    public String getName() {
        return "edit_author";
    }

    public String getHelp() {
        return "To edit author use:" + getName();
    }
}
