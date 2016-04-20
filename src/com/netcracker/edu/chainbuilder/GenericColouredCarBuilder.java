package com.netcracker.edu.chainbuilder;

/**
 * Created by FlowRyder.
 */
abstract class GenericColouredCarBuilder<T extends  GenericColouredCarBuilder<T>> extends GenericCarBuilder<T> {
    String color;

    T setColor(String color) {
        this.color = color;
        return (T)this;
    }

    public String getColor() {
        return color;
    }
}
