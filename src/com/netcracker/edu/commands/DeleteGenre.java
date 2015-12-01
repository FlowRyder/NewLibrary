package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteGenre extends CommandDelete {
    public static final Logger LOGGER = Logger.getLogger(DeleteGenre.class);

    @Override
    public Genre choose() {
        LOGGER.info("Choose genre:");
        return (Genre) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getGenres());
    }

    @Override
    public void execute() {
        MemoryDAO.getInstance().getGenres().remove(choose());
        LOGGER.info("Genre successfully deleted.");
    }

    @Override
    public String getName() {
        return "delete_genre";
    }

    @Override
    public String getHelp() {
        return "to delete genre use " + getName();
    }
}
