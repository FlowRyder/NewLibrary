package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteBookType extends Command {
    public static final Logger LOGGER = Logger.getLogger(DeleteBookType.class);

    @Override
    public void execute(String[] parameters) {
        if(parameters.length != 2) {
            LOGGER.info("Wrong number of parameters.");
            return;
        }
        FileDAO.getInstance().getBookTypes().remove(FileDAO.getInstance().choose(FileDAO.getInstance().getBookTypes(),Integer.parseInt(parameters[1])));
        LOGGER.info("Book type successfully deleted.");
    }

    @Override
    public String getName() {
        return "delete_bookType";
    }

    @Override
    public String getHelp() {
        return "to delete book type use " + getName() + " booktype_id";
    }
}
