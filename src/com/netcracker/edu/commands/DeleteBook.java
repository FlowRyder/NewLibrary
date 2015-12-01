package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteBook extends CommandDelete {
    public static final Logger LOGGER = Logger.getLogger(DeleteBook.class);

    @Override
    public Book choose() {
        LOGGER.info("Choose book:");
        return (Book) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getBooks());
    }

    @Override
    public void execute() {
        MemoryDAO.getInstance().getBooks().remove(choose());
        LOGGER.info("Book successfully deleted.");
    }

    @Override
    public String getName() {
        return "delete_book";
    }

    @Override
    public String getHelp() {
        return "to delete book use " + getName();
    }
}
