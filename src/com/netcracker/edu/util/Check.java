package com.netcracker.edu.util;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class Check {
    public static void isNullOrVoid(String value) {
        if(value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value is null or void.");
        }
    }

    public static void isNull(Object object) {
        if(object == null) {
            throw new IllegalArgumentException("Value is null.");
        }
    }
}
