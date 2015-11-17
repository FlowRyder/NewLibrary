package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Choice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class AddBook implements Command {
    public void execute() throws IOException {
        BookType bookType = Choice.chooseBookType();
        if (bookType == null) {
            System.out.println("There is no such book type.");
            return;
        } else {
            Book book = new Book(bookType);
            MemoryDAO.getInstance().getBooks().add(book);
        }
    }

    public String getName() {
        return "add_book";
    }

    public String getHelp() {
        return "To add book use:" + getName();
    }
}
