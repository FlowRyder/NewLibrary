package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Choice;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class EditBook extends CommandEdit {
    public static final Logger LOGGER = Logger.getLogger(EditBook.class);

    @Override
    public Book edit(String[] parameters) {
        Book book = (Book) FileDAO.getInstance().choose(FileDAO.getInstance().getBooks(), Integer.parseInt(parameters[1]));
        FileDAO.getInstance().getBooks().remove(book);
        book.setBookType((BookType) FileDAO.getInstance().choose(FileDAO.getInstance().getBookTypes(), Integer.parseInt(parameters[2])));
        return book;
    }

    @Override
    public void execute(String[] parameters) throws IOException {
        if (parameters.length != 3) {
            LOGGER.info("Wrong number of parameters.");
            return;
        }
        FileDAO.getInstance().getBooks().add(edit(parameters));
        LOGGER.info("Book successfully edited.");
    }

    @Override
    public String getName() {
        return "edit_book";
    }

    @Override
    public String getHelp() {
        return "to edit book use " + getName() + " book_id + booktype_id";
    }
}
