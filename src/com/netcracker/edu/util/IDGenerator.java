package com.netcracker.edu.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by FlowRyder
 */
public class IDGenerator {
    public static final Logger LOGGER = Logger.getLogger(IDGenerator.class);
    private static IDGenerator INSTANCE = null;
    private static AtomicInteger id;
    private String sourceFileLocation = FileLocation.getIDlocation();

    private IDGenerator() {
        BigInteger loadedID = loadID();
        id = new AtomicInteger(loadedID.intValue());
    }

    public static IDGenerator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IDGenerator();
        }
        return INSTANCE;
    }

    public BigInteger getID() {
        return BigInteger.valueOf(id.getAndIncrement());
    }

    private BigInteger loadID() {
        String ID = null;
        File IDfile = new File(sourceFileLocation);
        try (FileReader fileReader = new FileReader(IDfile)) {
            char[] buffer = new char[(int) IDfile.length()];
            fileReader.read(buffer);
            ID = new String(buffer);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        if (ID == null) {
            throw new NullPointerException("Error: ID has not been loaded from file.");
        }
        LOGGER.info("ID successfully has been loaded from file.");
        return new BigInteger(ID);
    }

    public void saveID() {
        try (FileWriter fileWriter = new FileWriter(sourceFileLocation, false)) {
            fileWriter.write(INSTANCE.getID().toString());
        } catch (IOException e) {
            LOGGER.warn("Error: ID wasn't save.");
        }
        LOGGER.info("ID successfully has been saved to file.");
    }
}
