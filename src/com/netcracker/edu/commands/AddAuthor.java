package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Uniqueness;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class AddAuthor extends CommandAdd {
    public static final Logger LOGGER = Logger.getLogger(AddAuthor.class);

    @Override
    public Author create() {
        LOGGER.info("Enter author's name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (Uniqueness.isNonUnigue(name, MemoryDAO.getInstance().getAuthors())) {
            LOGGER.info("Author already exists.");
        } else {
            return new Author(name);
        }
        return null;
    }

    @Override
    public void execute() {
        if (create() != null) {
            MemoryDAO.getInstance().getAuthors().add(create());
            LOGGER.info("Author successfully added");
        } else {
            LOGGER.info("Error: author already exists.");
        }
        MemoryDAO.getInstance().getAuthors().add(create());
    }

    @Override
    public String getName() {
        return "add_author";
    }

    @Override
    public String getHelp() {
        return "to add author use " + getName();
    }
}
