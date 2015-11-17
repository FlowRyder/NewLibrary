package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.dao.MemoryDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteGenre implements Command {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        System.out.println("Enter name of genre:");
        name = bufferedReader.readLine();
        Genre genre = MemoryDAO.getInstance().findGenreByName(name);
        if (genre != null) {
            MemoryDAO.getInstance().getGenres().remove(genre);
            System.out.println("Genre was successfully deleted.");
        } else {
            System.out.println("There is no such genre.");
        }
    }

    public String getName() {
        return "delete_genre";
    }

    public String getHelp() {
        return "To delete genre use:" + getName();
    }
}
