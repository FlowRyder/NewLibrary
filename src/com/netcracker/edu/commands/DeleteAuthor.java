package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteAuthor extends CommandDelete {
    public static final Logger LOGGER = Logger.getLogger(DeleteAuthor.class);

    @Override
    public Author choose() {
        LOGGER.info("Choose author:");
        return (Author) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getAuthors());
    }

    @Override
    public void execute() {
        MemoryDAO.getInstance().getAuthors().remove(choose());
        LOGGER.info("Author successfully deleted.");
    }

    @Override
    public String getName() {
        return "delete_author";
    }

    @Override
    public String getHelp() {
        return "to delete author use " + getName();
    }
}
