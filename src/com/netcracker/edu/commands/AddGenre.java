package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.util.Check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class AddGenre implements Command {
    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name of genre:");
        String name = bufferedReader.readLine();
        if (Check.containGenre(name)) {
            System.out.println("Genre already exists.");
            return;
        } else {
            Genre genre = new Genre(name);
            MemoryDAO.getInstance().getGenres().add(genre);
        }
    }

    public String getName() {
        return "add_genre";
    }

    public String getHelp() {
        return "To add genre use:" + getName();
    }
}
