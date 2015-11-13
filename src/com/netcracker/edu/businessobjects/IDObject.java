package com.netcracker.edu.businessobjects;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class IDObject {
    private int id;

    public IDObject() {
       id = ID.evaluateId();
    }

    public int getId() {
        return id;
    }
}
