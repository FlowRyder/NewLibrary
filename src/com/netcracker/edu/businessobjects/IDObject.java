package com.netcracker.edu.businessobjects;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class IDObject {
    private int id;

    public IDObject() {
       id = IDGenerator.evaluateId();
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
