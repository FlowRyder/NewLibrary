package com.netcracker.edu.businessobjects;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class ID {
    private static int id;
    private static final ID INSTANCE = new ID();

    public static int evaluateId() {
        setId(getId() + 1);
        return id;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int idValue) {
        id = idValue;
    }

}
