package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.dao.MemoryDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class EditGenre implements Command {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        System.out.println("Enter name of genre:");
        name = bufferedReader.readLine();
        Genre genre = MemoryDAO.getInstance().findGenreByName(name);
        if (genre != null) {
            String newName;
            System.out.println("Enter new name of genre:");
            newName = bufferedReader.readLine();
            genre.setName(newName);
            MemoryDAO.getInstance().getGenres().remove(genre);
            MemoryDAO.getInstance().getGenres().add(genre);
            System.out.println("Genre was successfully edited.");
        } else {
            System.out.println("There is no such genre.");
        }
    }

    public String getName() {
        return "edit_genre";
    }

    public String getHelp() {
        return "To edit genre use:" + getName();
    }
}
