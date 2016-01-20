package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Genre;
import org.apache.log4j.Logger;

import static com.netcracker.edu.util.ExceptionCode.*;

import java.math.BigInteger;

/**
 * Created by FlowRyder
 */
public class EditGenre extends Command {
    public static final Logger LOGGER = Logger.getLogger(EditGenre.class);
    public final int parametersNumber = 3;

    @Override
    public int execute(String[] parameters) {
        int result = checkLibrarian(parameters);
        Genre genre;
        try {
            genre = new Genre(parameters[2]);
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return invalidNameValue;
        }
        try {
            genre.setId(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return IDNotANumber;
        }
        if (!DAO.updateGenre(genre)) {
            LOGGER.info("Error: unsuccessfully query. Genre hasn't been updated.");
            return unsuccessfullQuery;
        }
        if (result == success) {
            LOGGER.info("Genre successfully edited.");
        }
        return result;
    }

    @Override
    public String getName() {
        return "edit_genre";
    }

    @Override
    public String getHelp() {
        return "to edit genre use " + getName() + " genre_id  genre_name" + "\n"
                + "Example: edit_genre 17 novel";
    }
}
