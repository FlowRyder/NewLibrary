package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Genre;
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
    public Genre edit() {
        LOGGER.info("Choose genre:");
        Genre genre = (Genre) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getGenres());
        MemoryDAO.getInstance().getGenres().remove(genre);
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter name:");
        genre.setName(scanner.nextLine());
        return genre;
    }

    @Override
    public void execute() {
        MemoryDAO.getInstance().getGenres().add(edit());
        LOGGER.info("Genre successfully edited.");
    }

    @Override
    public String getName() {
        return "edit_genre";
    }

    @Override
    public String getHelp() {
        return "to edit genre use " + getName();
    }
}
