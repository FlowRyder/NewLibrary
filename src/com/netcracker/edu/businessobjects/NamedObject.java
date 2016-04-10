package com.netcracker.edu.businessobjects;

/**
 * Created by FlowRyder.
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
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Error: Name shouldn't be null or void.");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NamedObject that = (NamedObject) o;
        return this.name.equals(that.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return getName() + " " + getId();
    }
}
