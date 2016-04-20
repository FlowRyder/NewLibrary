package com.netcracker.edu.chainbuilder;

/**
 * Created by FlowRyder.
 */
abstract class GenericCarBuilder<T extends GenericCarBuilder<T>> {
    private String brand;
    private String model;
    private String body;
    private String engine;
    private String transmission;
    private String configuration;

    T setBrand(String brand) {
        this.brand = brand;
        return (T)this;
    }

    T setModel(String model) {
        this.model = model;
        return (T)this;
    }

    T setBody(String body) {
        this.body = body;
        return (T)this;
    }

    T setEngine(String engine) {
        this.engine = engine;
        return (T)this;
    }

    T setTransmission(String transmission) {
        this.transmission = transmission;
        return (T)this;
    }

    T setConfiguration(String configuration) {
        this.configuration = configuration;
        return (T)this;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getBody() {
        return body;
    }

    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getConfiguration() {
        return configuration;
    }
}
