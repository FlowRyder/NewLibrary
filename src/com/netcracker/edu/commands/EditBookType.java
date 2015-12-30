package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class EditBookType extends CommandEdit {
    public static final Logger LOGGER = Logger.getLogger(EditBookType.class);

    @Override
    public BookType edit(String[] parameters) {
        BookType bookType = (BookType) FileDAO.getInstance().choose(FileDAO.getInstance().getBookTypes(), Integer.parseInt(parameters[1]));
        FileDAO.getInstance().getBookTypes().remove(bookType);
        bookType.setName(parameters[2]);
        bookType.setAuthor((Author) FileDAO.getInstance().choose(FileDAO.getInstance().getAuthors(), Integer.parseInt(parameters[4])));
        bookType.setGenre((Genre) FileDAO.getInstance().choose(FileDAO.getInstance().getGenres(), Integer.parseInt(parameters[3])));
        return bookType;
    }

    @Override
    public void execute(String[] parameters) throws IOException {
        if (parameters.length != 5) {
            LOGGER.info("Wrong number of parameters.");
            return;
        }
        FileDAO.getInstance().getBookTypes().add(edit(parameters));
        LOGGER.info("Book type successfully edited.");
    }

    @Override
    public String getName() {
        return "edit_bookType";
    }

    @Override
    public String getHelp() {
        return "to edit book type use " + getName() + " booktype_id booktype_name + genre_id + author_id";
    }
}
