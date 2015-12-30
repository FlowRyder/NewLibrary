package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteBook extends Command {
    public static final Logger LOGGER = Logger.getLogger(DeleteBook.class);

    @Override
    public void execute(String[] parameters) {
        if(parameters.length != 2) {
            LOGGER.info("Wrong number of parameters.");
            return;
        }
        FileDAO.getInstance().getBooks().remove(FileDAO.getInstance().choose(FileDAO.getInstance().getBooks(), Integer.parseInt(parameters[1])));
        LOGGER.info("Book successfully deleted.");
    }

    @Override
    public String getName() {
        return "delete_book";
    }

    @Override
    public String getHelp() {
        return "to delete book use " + getName() + " book_id";
    }
}
