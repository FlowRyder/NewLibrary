package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.sql.SQLException;

/**
 * Created by FlowRyder
 */
public class EditAuthor extends Command {
    public static final Logger LOGGER = Logger.getLogger(EditAuthor.class);
    public int parametersNumber = 3;

    @Override
    public int execute(String[] parameters) throws SQLException {
        if (Context.getLoggedHolder() == null) {
            LOGGER.warn("Error: User isn't logged in.");
            return 1;
        }
        if (!Context.getLoggedHolder().getRights()) {
            LOGGER.warn("Error: Access only for librarians.");
            return 2;
        }
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return 3;
        }
        Author author;
        try {
            author = new Author(parameters[2]);
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return 4;
        }
        try {
            author.setId(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        }
        if (!dao.updateAuthor(author)) {
            LOGGER.info("Error: unsuccessfully query. Author hasn't been updated.");
            return 18;
        }
        LOGGER.info("Author successfully edited.");
        return 0;
    }

    @Override
    public String getName() {
        return "edit_author";
    }

    @Override
    public String getHelp() {
        return "to edit author use " + getName() + " author_id  author_name" + "\n"
                + "Example: edit_author 19 Tolstoy";
    }
}
