package com.netcracker.edu.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by FlowRyder.
 */
public class FileLocation {
    public static final Logger LOGGER = Logger.getLogger(ConnectionProperties.class);
    private static String connectionLocation;
    private static String fileStorageLocation;
    private static String IDlocation;
    private static String scenarioLocation;

    static {
        String source = null;
        File file = new File("C:\\Users\\FlowRyder\\IdeaProjects\\Library\\src\\com\\netcracker\\edu\\data\\LOCATION.dat");
        try (FileReader fileReader = new FileReader(file)) {
            char[] buffer = new char[(int) file.length()];
            fileReader.read(buffer);
            source = new String(buffer);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        if (source == null) {
            throw new NullPointerException("Error: Files locations has not been loaded from file.");
        }
        String[] parameters = source.split("\\r?\\n");
        connectionLocation = parameters[0];
        fileStorageLocation = parameters[1];
        IDlocation = parameters[2];
        scenarioLocation = parameters[3];
    }

    public static String getConnectionLocation() {
        return connectionLocation;
    }

    public static String getFileStorageLocation() {
        return fileStorageLocation;
    }

    public static String getIDlocation() {
        return IDlocation;
    }

    public static String getScenario() {
        return scenarioLocation;
    }
}
