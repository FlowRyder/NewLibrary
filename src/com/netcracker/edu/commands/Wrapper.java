package com.netcracker.edu.commands;

/**
 * Created by FlowRyder.
 */
public class Wrapper {
    private static Wrapper INSTANCE = new Wrapper();
    private String result;

    public static Wrapper getInstance() {
        return INSTANCE;
    }

    private Wrapper() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
