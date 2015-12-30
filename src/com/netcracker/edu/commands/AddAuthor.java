package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.dao.FileDAO;
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
    public Author create(String[] parameters) {
        if (Uniqueness.isNonUnigue(parameters[1], FileDAO.getInstance().getAuthors())) {
            LOGGER.info("Author already exists.");
        } else {
            return new Author(parameters[1]);
        }
        return null;
    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 2) {
            LOGGER.info("Wrong number of parameters");
            return;
        }
        Author author = create(parameters);
        if (author != null) {
            FileDAO.getInstance().getAuthors().add(author);
            LOGGER.info("Author successfully added");
        } else {
            LOGGER.info("Error: author already exists.");
        }
    }

    @Override
    public String getName() {
        return "add_author";
    }

    @Override
    public String getHelp() {
        return "to add author use " + getName() + " authors_name";
    }
}
