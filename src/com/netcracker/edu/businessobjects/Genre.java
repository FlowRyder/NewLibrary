package com.netcracker.edu.businessobjects;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class Genre extends Category {
    public Genre(String name) {
        super(name);
    }

    public static Genre load(String[] parameters) {
        Genre genre = new Genre(parameters[0]);
        genre.setId(Integer.parseInt(parameters[1]));
        return genre;
    }
}
