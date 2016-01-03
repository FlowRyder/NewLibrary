package com.netcracker.edu.businessobjects;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class Reader extends User {
    public Reader(String name, String login, String email, String password) {
        super(name, login, email, password);
    }

    public static Reader load(String[] parameters) {
        Reader reader = new Reader(parameters[0], parameters[1], parameters[2], parameters[3]);
        reader.setId(Integer.parseInt(parameters[4]));
        return reader;
    }
}
