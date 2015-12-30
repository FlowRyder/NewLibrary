package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.businessobjects.IDObject;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Check;
import com.netcracker.edu.util.Choice;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class AddBookType extends CommandAdd {
    public static final Logger LOGGER = Logger.getLogger(AddBookType.class);

    @Override
    public BookType create(String[] parameters) {
        Genre genre = (Genre) FileDAO.getInstance().choose(FileDAO.getInstance().getGenres(), Integer.parseInt(parameters[2]));
        Author author = (Author) FileDAO.getInstance().choose(FileDAO.getInstance().getAuthors(), Integer.parseInt(parameters[3]));
        return new BookType(parameters[1], genre, author);
    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 4) {
            LOGGER.info("Wrong number of parameters.");
            return;
        }
        MemoryDAO.getInstance().getBookTypes().add(create(parameters));
        LOGGER.info("Book type successfully added.");
    }

    @Override
    public String getName() {
        return "add_bookType";
    }

    @Override
    public String getHelp() {
        return "to add book type use " + getName() + " booktype_name + genre_id + author_id";
    }
}
