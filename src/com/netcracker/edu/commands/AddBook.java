package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.businessobjects.IDObject;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Choice;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class AddBook extends CommandAdd {
    public static final Logger LOGGER = Logger.getLogger(AddBook.class);

    @Override
    public Book create(String[] parameters) {
        BookType bookType = (BookType) FileDAO.getInstance().choose(FileDAO.getInstance().getBookTypes(), Integer.parseInt(parameters[1]));
        return new Book(bookType);
    }

    @Override
    public void execute(String[] parameters) throws IOException {
        if (parameters.length != 2) {
            LOGGER.info("Wrong number of parameters");
            return;
        }
        MemoryDAO.getInstance().getBooks().add(create(parameters));
        LOGGER.info("Book successfully added.");
    }

    @Override
    public String getName() {
        return "add_book";
    }

    @Override
    public String getHelp() {
        return "to add book use " + getName() + "booktype_id";
    }
}
