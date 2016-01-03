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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    // temporary method to use fileDAO
    public String write() {
        return String.valueOf(id);
    }

    // temporary method to use fileDAO
    public static IDObject load(String[] parameters) {
        IDObject idObject = new IDObject();
        idObject.setId(Integer.parseInt(parameters[0]));
        return idObject;
    }
}
