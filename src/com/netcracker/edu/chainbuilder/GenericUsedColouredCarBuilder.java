package com.netcracker.edu.chainbuilder;

/**
 * Created by FlowRyder.
 */
abstract class GenericUsedColouredCarBuilder<T extends GenericUsedColouredCarBuilder<T>> extends GenericColouredCarBuilder<T> {
    String mileage;

    T setMileage(String mileage) {
        this.mileage = mileage;
        return (T)this;
    }

    public String getMileage() {
        return mileage;
    }
}
