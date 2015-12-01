package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Genre;
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
    public Genre create() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter genre's name:");
        String name = scanner.nextLine();
        if (Uniqueness.isNonUnigue(name, MemoryDAO.getInstance().getGenres())) {
            LOGGER.info("Genre already exists.");
        } else {
            return new Genre(scanner.nextLine());
        }
        return null;
    }

    @Override
    public void execute() {
        if (create() != null) {
            MemoryDAO.getInstance().getGenres().add(create());
            LOGGER.info("Genre successfully added");
        } else {
            LOGGER.info("Error: genre already exists.");
        }
        MemoryDAO.getInstance().getGenres().add(create());
    }

    @Override
    public String getName() {
        return "add_genre";
    }

    @Override
    public String getHelp() {
        return "to add genre use " + getName();
    }
}
