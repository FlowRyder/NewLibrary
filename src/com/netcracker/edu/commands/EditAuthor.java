package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class EditAuthor extends CommandEdit {
    public static final Logger LOGGER = Logger.getLogger(EditAuthor.class);

    @Override
    public Author edit() {
        LOGGER.info("Choose author:");
        Author author = (Author) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getAuthors());
        MemoryDAO.getInstance().getAuthors().remove(author);
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter name:");
        author.setName(scanner.nextLine());
        return author;
    }

    @Override
    public void execute() throws IOException {
        MemoryDAO.getInstance().getAuthors().add(edit());
        LOGGER.info("Author successfully edited.");
    }

    @Override
    public String getName() {
        return "edit_author";
    }

    @Override
    public String getHelp() {
        return "to edit author use " + getName();
    }
}
