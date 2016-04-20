package com.netcracker.edu.chainbuilder;

/**
 * Created by FlowRyder.
 */
final class ColouredCarBuilder extends GenericColouredCarBuilder<ColouredCarBuilder> {

    ColouredCar build() {
        return new ColouredCar(this);
    }

}
