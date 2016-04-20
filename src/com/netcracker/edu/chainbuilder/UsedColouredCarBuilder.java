package com.netcracker.edu.chainbuilder;

/**
 * Created by FlowRyder.
 */
final class UsedColouredCarBuilder extends GenericUsedColouredCarBuilder<UsedColouredCarBuilder> {

    UsedColouredCar build() {
        return new UsedColouredCar(this);
    }

}
