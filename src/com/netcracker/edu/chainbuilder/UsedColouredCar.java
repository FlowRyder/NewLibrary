package com.netcracker.edu.chainbuilder;

/**
 * Created by FlowRyder.
 */
public class UsedColouredCar extends ColouredCar {
    String mileage;

    UsedColouredCar(UsedColouredCarBuilder usedColouredCarBuilder) {
        super(new ColouredCarBuilder()
                .setBrand(usedColouredCarBuilder.getBrand())
                .setModel(usedColouredCarBuilder.getModel())
                .setBody(usedColouredCarBuilder.getBody())
                .setEngine(usedColouredCarBuilder.getEngine())
                .setTransmission(usedColouredCarBuilder.getTransmission())
                .setConfiguration(usedColouredCarBuilder.getConfiguration())
                .setColor(usedColouredCarBuilder.getColor()));
        this.mileage = usedColouredCarBuilder.getMileage();
    }
}
