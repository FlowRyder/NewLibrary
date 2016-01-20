package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.BookType;
import static com.netcracker.edu.util.ExceptionCode.*;
import org.apache.log4j.Logger;

import java.math.BigInteger;

/**
 * Created by FlowRyder
 */
public class AddBookType extends Command {
    public static final Logger LOGGER = Logger.getLogger(AddBookType.class);
    public final int parametersNumber = 4;

    @Override
    public int execute(String[] parameters) {
        int result = checkLibrarian(parameters);
        BookType bookType;
        try {
            bookType = new BookType(parameters[1], new BigInteger(parameters[2]),
                    new BigInteger(parameters[3]));
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return invalidNameValue;
        } catch (NullPointerException e) {
            LOGGER.warn("Error: ID shouldn't be null or negative value.");
            return invalidIDValue;
        }
        if (!DAO.addBookType(bookType)) {
            LOGGER.info("Error: unsuccessfully query. Book type hasn't been added.");
            return unsuccessfullQuery;
        }
        if(result == success) {
            LOGGER.info("Book type successfully added.");
        }
        return result;
    }

    @Override
    public String getName() {
        return "add_bookType";
    }

    @Override
    public String getHelp() {
        return "to add book type use " + getName() + " bookType_name  genre_id  author_id" + "\n"
                + "Example: Generation_Pi 8 34";
    }
}
