package com.netcracker.edu.businessobjects;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class IDGenerator {
    private static int id;
    private static final IDGenerator INSTANCE = new IDGenerator();

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
