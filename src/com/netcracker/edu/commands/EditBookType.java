package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.businessobjects.Librarian;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.math.BigInteger;

/**
 * Created by FlowRyder.
 */
public class EditBookType extends Command {
    public static final Logger LOGGER = Logger.getLogger(EditBookType.class);
    public int parametersNumber = 3;
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
        BookType bookType;
        try {
            bookType = FileDAO.getInstance().loadBookType(new BigInteger(parameters[1]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        }
        if (bookType == null) {
            LOGGER.warn("Error: Wrong ID.");
            return 16;
        }
        try {
            bookType.setGenreID(new BigInteger(parameters[2]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        }
        try {
            bookType.setAuthorID(new BigInteger(parameters[3]));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        }
        FileDAO.getInstance().updateBookType(bookType);
        LOGGER.info("Book type successfully edited.");
        return 0;
    }

    @Override
    public String getName() {
        return "edit_bookType";
    }

    @Override
    public String getHelp() {
        return "to edit book type use " + getName() + " bookType_id  genre_id author_id" + "\n"
                + "Example: edit_bookType 31 75 40";
    }
}
