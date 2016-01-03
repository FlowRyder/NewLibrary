package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Uniqueness;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class AddGenre extends CommandAdd {
    public static final Logger LOGGER = Logger.getLogger(AddGenre.class);

    @Override
    public Genre create(String[] parameters) {
        if (Uniqueness.isNonUnigue(parameters[1], FileDAO.getInstance().getGenres())) {
            LOGGER.info("Genre already exists.");
        } else {
            return new Genre(parameters[1]);
        }
        return null;
    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 2) {
            LOGGER.info("Wrong number of parameters.");
            return;
        }
        Genre genre = create(parameters);
        if (genre != null) {
            FileDAO.getInstance().getGenres().add(genre);
            LOGGER.info("Genre successfully added");
            LOGGER.info(genre.toString());
        } else {
            LOGGER.info("Error: genre already exists.");
        }
    }

    @Override
    public String getName() {
        return "add_genre";
    }

    @Override
    public String getHelp() {
        return "to add genre use " + getName() + " genres_name";
    }
}
