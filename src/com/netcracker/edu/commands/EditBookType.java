package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class EditBookType extends CommandEdit {
    public static final Logger LOGGER = Logger.getLogger(EditBookType.class);

    @Override
    public BookType edit() {
        LOGGER.info("Choose book type:");
        BookType bookType = (BookType) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getBookTypes());
        MemoryDAO.getInstance().getBookTypes().remove(bookType);
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter name:");
        bookType.setName(scanner.nextLine());
        LOGGER.info("Choose author:");
        bookType.setAuthor((Author) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getAuthors()));
        LOGGER.info("Choose genre:");
        bookType.setGenre((Genre) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getGenres()));
        return bookType;
    }

    @Override
    public void execute() throws IOException {
        MemoryDAO.getInstance().getBookTypes().add(edit());
        LOGGER.info("Book type successfully edited.");
    }

    @Override
    public String getName() {
        return "edit_bookType";
    }

    @Override
    public String getHelp() {
        return "to edit book type use " + getName();
    }
}
