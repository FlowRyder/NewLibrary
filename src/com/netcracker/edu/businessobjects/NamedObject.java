package com.netcracker.edu.businessobjects;

import com.netcracker.edu.util.Check;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class NamedObject extends IDObject {
    private String name;

    public NamedObject(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Check.isNullOrVoid(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return getName() + " [" + getId() + "]";
    }
}
