package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class EditGenre extends CommandEdit {
    public static final Logger LOGGER = Logger.getLogger(EditGenre.class);

    @Override
    public Genre edit(String[] parameters) {
        Genre genre = (Genre) FileDAO.getInstance().choose(FileDAO.getInstance().getGenres(), Integer.parseInt(parameters[1]));
        FileDAO.getInstance().getGenres().remove(genre);
        genre.setName(parameters[2]);
        return genre;
    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 3) {
            LOGGER.info("Wrong number of parameters.");
            return;
        }
        FileDAO.getInstance().getGenres().add(edit(parameters));
        LOGGER.info("Genre successfully edited.");
    }

    @Override
    public String getName() {
        return "edit_genre";
    }

    @Override
    public String getHelp() {
        return "to edit genre use " + getName() + " genre_id + genre_name";
    }
}
