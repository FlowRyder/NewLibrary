package com.netcracker.edu.chainbuilder;

/**
 * Created by FlowRyder.
 */
public class Car {
    private String brand;
    private String model;
    private String body;
    private String engine;
    private String transmission;
    private String configuration;

    Car(CarBuilder carBuilder) {
        this.brand = carBuilder.getBrand();
        this.model = carBuilder.getModel();
        this.body = carBuilder.getBody();
        this.engine = carBuilder.getEngine();
        this.transmission = carBuilder.getTransmission();
        this.configuration = carBuilder.getConfiguration();
    }

}
