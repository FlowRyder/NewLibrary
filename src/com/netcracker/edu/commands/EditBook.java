package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Choice;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class EditBook extends CommandEdit {
    public static final Logger LOGGER = Logger.getLogger(EditBook.class);

    @Override
    public Book edit() {
        LOGGER.info("Choose book:");
        Book book = (Book) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getBooks());
        MemoryDAO.getInstance().getBooks().remove(book);
        LOGGER.info("Choose book type:");
        book.setBookType((BookType) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getBookTypes()));
        return book;
    }

    @Override
    public void execute() throws IOException {
        MemoryDAO.getInstance().getBooks().add(edit());
        LOGGER.info("Book successfully edited.");
    }

    @Override
    public String getName() {
        return "edit_book";
    }

    @Override
    public String getHelp() {
        return "to edit book use " + getName();
    }
}
