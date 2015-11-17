package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Book;
import com.netcracker.edu.dao.MemoryDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteBook implements Command {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int id;
        System.out.println("Enter id of book:");
        try {
            id = Integer.getInteger(bufferedReader.readLine());
        } catch (NullPointerException e) {
            System.out.println("Invalid id format");
            return;
        }
        Book book = MemoryDAO.getInstance().findBookByID(id);
        if (book != null) {
            MemoryDAO.getInstance().getBooks().remove(book);
            System.out.println("Book was successfully deleted.");
        } else {
            System.out.println("There is no such book.");
        }
    }

    public String getName() {
        return "delete_book";
    }

    public String getHelp() {
        return "To delete book use:" + getName();
    }
}
