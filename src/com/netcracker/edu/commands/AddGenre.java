package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.businessobjects.Librarian;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

/**
 * Created by FlowRyder
 */
public class AddGenre extends Command {
    public static final Logger LOGGER = Logger.getLogger(AddGenre.class);
    public int parametersNumber = 2;
    public Class classAccess = Librarian.class;

    @Override
    public int execute(String[] parameters) {
        if (Context.getLoggedHolder() == null) {
            LOGGER.warn("Error: User isn't logged in.");
            return 1;
        }
        if (!Context.getLoggedHolder().getClass().equals(classAccess)) {
            LOGGER.warn("Error: Access only for librarians.");
            return 2;
        }
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return 3;
        }
        Genre genre;
        try {
            genre = new Genre(parameters[1]);
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return 4;
        }
        FileDAO.getInstance().addGenre(genre);
        LOGGER.info("Genre successfully added.");
        return 0;
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
