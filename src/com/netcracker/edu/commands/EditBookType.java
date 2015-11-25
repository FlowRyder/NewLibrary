package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.dao.MemoryDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class EditBookType implements Command {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        System.out.println("Enter name of book type:");
        name = bufferedReader.readLine();
        BookType bookType = MemoryDAO.getInstance().findBookTypeByName(name);
        if (bookType != null) {
            String newName;
            System.out.println("Enter new name of book type:");
            newName = bufferedReader.readLine();
            bookType.setName(newName);
            MemoryDAO.getInstance().getBookTypes().remove(bookType);
            MemoryDAO.getInstance().getBookTypes().add(bookType);
            System.out.println("Book type was successfully edited.");
        } else {
            System.out.println("There is no such book type.");
        }
    }

    public String getName() {
        return "edit_bookType";
    }

    public String getHelp() {
        return "To edit book type use:" + getName();
    }
}
