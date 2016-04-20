package com.netcracker.edu.chainbuilder;

/**
 * Created by FlowRyder.
 */
final class CarBuilder extends GenericCarBuilder<CarBuilder> {

    Car build() {
        return new Car(this);
    }

}
