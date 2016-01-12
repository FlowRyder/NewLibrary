package com.netcracker.edu.util;

import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Created by FlowRyder.
 */
public class ConnectionParameters {
    public static final Logger LOGGER = Logger.getLogger(ConnectionParameters.class);

    public static String[] getPaprametersOfConnection() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter databaseURL login password ");
        String input = scanner.nextLine();
        String[] parameters = input.split(" ");
        return parameters;
    }
}

