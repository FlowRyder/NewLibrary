package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import org.apache.log4j.Logger;

import static com.netcracker.edu.util.ExceptionCode.*;

import java.math.BigInteger;

/**
 * Created by FlowRyder
 */
public class EditAuthor extends Command {
    public static final Logger LOGGER = Logger.getLogger(EditAuthor.class);
    public final int parametersNumber = 3;

    @Override
    public int execute(String[] parameters) {
        int result = checkLibrarian(parameters, parametersNumber);
        Author author;
        try {
            author = new Author(parameters[2]);
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return invalidNameValue;
        }
        try {
            author.setId(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return IDNotANumber;
        }
        if (!DAO.updateAuthor(author)) {
            LOGGER.info("Error: unsuccessfully query. Author hasn't been updated.");
            return unsuccessfullQuery;
        }
        if (result == success) {
            LOGGER.info("Author successfully edited.");
        }
        return result;
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
