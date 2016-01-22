package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import static com.netcracker.edu.util.ExceptionCode.*;
import org.apache.log4j.Logger;

/**
 * Created by FlowRyder
 */
public class AddAuthor extends Command {
    public static final Logger LOGGER = Logger.getLogger(AddAuthor.class);
    public final int parametersNumber = 2;

    @Override
    public int execute(String[] parameters) {
        int result = checkLibrarian(parameters, parametersNumber);
        Author author;
        try {
            author = new Author(parameters[1]);
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return invalidNameValue;
        }
        if (!DAO.addAuthor(author)) {
            LOGGER.info("Error: unsuccessfully query. Author hasn't been added.");
            return unsuccessfullQuery;
        }
        if(result == success) {
            LOGGER.info("Author successfully added.");
        }
        return result;
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
