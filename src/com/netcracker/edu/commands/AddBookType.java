package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.businessobjects.IDObject;
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
    public BookType create() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter book type's name:");
        String name = scanner.nextLine();
        LOGGER.info("Choose genre:");
        Genre genre = (Genre) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getGenres());
        LOGGER.info("Choose author:");
        Author author = (Author) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getAuthors());
        return new BookType(name, genre, author);
    }

    @Override
    public void execute() {
        MemoryDAO.getInstance().getBookTypes().add(create());
        LOGGER.info("Book type successfully added.");
    }

    @Override
    public String getName() {
        return "add_bookType";
    }

    @Override
    public String getHelp() {
        return "to add book type use " + getName();
    }
}
