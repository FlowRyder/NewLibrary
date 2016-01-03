package com.netcracker.edu.businessobjects;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class Author extends Category {
    public Author(String name) {
        super(name);
    }

    public static Author load(String[] parameters) {
        Author author = new Author(parameters[0]);
        author.setId(Integer.parseInt(parameters[1]));
        return author;
    }
}
