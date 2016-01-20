package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Genre;

import static com.netcracker.edu.util.ExceptionCode.*;

import org.apache.log4j.Logger;

/**
 * Created by FlowRyder
 */
public class AddGenre extends Command {
    public static final Logger LOGGER = Logger.getLogger(AddGenre.class);
    public final int parametersNumber = 2;

    @Override
    public int execute(String[] parameters) {
        int result = checkLibrarian(parameters);
        Genre genre;
        try {
            genre = new Genre(parameters[1]);
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return invalidNameValue;
        }
        if (!DAO.addGenre(genre)) {
            LOGGER.info("Error: unsuccessfully query. Genre hasn't been added.");
            return unsuccessfullQuery;
        }
        if (result == success) {
            LOGGER.info("Genre successfully added.");
        }
        return result;
    }

    @Override
    public String getName() {
        return "add_genre";
    }

    @Override
    public String getHelp() {
        return "To add genre use " + getName() + " genre_name" + "\n"
                + "Example: add_genre detective";
    }
}
