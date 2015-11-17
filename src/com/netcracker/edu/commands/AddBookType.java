package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Check;
import com.netcracker.edu.util.Choice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class AddBookType implements Command {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name");
        String bookTypeName = bufferedReader.readLine();
        Genre genre = Choice.chooseGenre();
        Author author = Choice.chooseAuthor();
        if (genre == null || author == null) {
            System.out.println("Invalid parameters of choice.");
            return;
        }
        if (Check.containBookType(genre, author, bookTypeName)) {
            System.out.println("Book Type already exists.");
            return;
        } else {
            BookType bookType = new BookType(bookTypeName, genre, author);
            MemoryDAO.getInstance().getBookTypes().add(bookType);
        }

    }

    public String getName() {
        return "add_bookType";
    }

    public String getHelp() {
        return "To add bookType use:" + getName();
    }
}
