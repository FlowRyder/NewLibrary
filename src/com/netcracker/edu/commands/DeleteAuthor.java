package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.dao.MemoryDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteAuthor implements Command {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        System.out.println("Enter name of author:");
        name = bufferedReader.readLine();
        Author author = MemoryDAO.getInstance().findAuthorByName(name);
        if (author != null) {
            MemoryDAO.getInstance().getAuthors().remove(author);
            System.out.println("Author was successfully deleted.");
        } else {
            System.out.println("There is no such author.");
        }
    }

    public String getName() {
        return "delete_author";
    }

    public String getHelp() {
        return "To delete author use:" + getName();
    }
}
