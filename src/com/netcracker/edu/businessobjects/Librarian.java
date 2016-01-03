package com.netcracker.edu.businessobjects;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class Librarian extends User {
    public Librarian(String name, String login, String email, String password) {
        super(name, login, email, password);
    }

    public static Librarian load(String[] parameters) {
        Librarian librarian = new Librarian(parameters[0], parameters[1], parameters[2], parameters[3]);
        librarian.setId(Integer.parseInt(parameters[4]));
        return librarian;
    }
}
