package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.dao.DAO;
import com.netcracker.edu.dao.DAOFactory;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.sql.SQLException;

/**
 * Created by FlowRyder
 */
public class AddAuthor extends Command {
    public static final Logger LOGGER = Logger.getLogger(AddAuthor.class);
    public int parametersNumber = 2;
    public DAO dao = DAOFactory.getDAO();

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
            author = new Author(parameters[1]);
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return 4;
        }
        if (!dao.addAuthor(author)) {
            LOGGER.info("Error: unsuccessfully query. Author hasn't been added.");
            return 18;
        }
        LOGGER.info("Author successfully added.");
        return 0;
    }

    @Override
    public String getName() {
        return "add_author";
    }

    @Override
    public String getHelp() {
        return "To add author use " + getName() + " author_name" + "\n"
                + "Example: add_author Pelevin";
    }
}
