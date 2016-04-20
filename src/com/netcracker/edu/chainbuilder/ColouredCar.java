package com.netcracker.edu.chainbuilder;

/**
 * Created by FlowRyder.
 */
public class ColouredCar extends Car {
    String color;

    ColouredCar(ColouredCarBuilder colouredCarBuilder) {
        super(new CarBuilder()
                .setBrand(colouredCarBuilder.getBrand())
                .setModel(colouredCarBuilder.getModel())
                .setBody(colouredCarBuilder.getBody())
                .setEngine(colouredCarBuilder.getEngine())
                .setTransmission(colouredCarBuilder.getTransmission())
                .setConfiguration(colouredCarBuilder.getConfiguration()));
        this.color = colouredCarBuilder.getColor();
    }
}
