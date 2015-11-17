package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.dao.MemoryDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteBookType {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        System.out.println("Enter name of book type:");
        name = bufferedReader.readLine();
        BookType bookType = MemoryDAO.getInstance().findBookTypeByName(name);
        if (bookType != null) {
            MemoryDAO.getInstance().getBookTypes().remove(bookType);
            System.out.println("Book type was successfully deleted.");
        } else {
            System.out.println("There is no such book type.");
        }
    }

    public String getName() {
        return "delete_bookType";
    }

    public String getHelp() {
        return "To delete book type use:" + getName();
    }
}
