package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteBookType extends CommandDelete {
    public static final Logger LOGGER = Logger.getLogger(DeleteBookType.class);

    @Override
    public BookType choose() {
        LOGGER.info("Choose book type:");
        return (BookType) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getBookTypes());
    }

    @Override
    public void execute() {
        MemoryDAO.getInstance().getBookTypes().remove(choose());
        LOGGER.info("Book type successfully deleted.");
    }

    @Override
    public String getName() {
        return "delete_bookType";
    }

    @Override
    public String getHelp() {
        return "to delete book type use " + getName();
    }
}
