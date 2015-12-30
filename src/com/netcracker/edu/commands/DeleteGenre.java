package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteGenre extends Command {
    public static final Logger LOGGER = Logger.getLogger(DeleteGenre.class);

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 2) {
            LOGGER.info("Wrong number of parameters.");
            return;
        }
        FileDAO.getInstance().getGenres().remove(FileDAO.getInstance().choose(FileDAO.getInstance().getGenres(), Integer.parseInt(parameters[1])));
        LOGGER.info("Genre successfully deleted.");
    }

    @Override
    public String getName() {
        return "delete_genre";
    }

    @Override
    public String getHelp() {
        return "to delete genre use " + getName() + " genre_id";
    }
}
