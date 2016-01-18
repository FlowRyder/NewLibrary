package com.netcracker.edu.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by FlowRyder.
 */
public class ConnectionProperties {
    public static final Logger LOGGER = Logger.getLogger(ConnectionProperties.class);
    private static String DBURL;
    private static String DAO;
    private static String DATABASE_LOGIN;
    private static char[] DATABASE_PASSWORD;
    private static int JDBC_POOL_SIZE;
    private static String sourceFileLocation = FileLocation.getConnectionLocation();


    static {
        String source = null;
        File file = new File(sourceFileLocation);
        try (FileReader fileReader = new FileReader(file)) {
            char[] buffer = new char[(int) file.length()];
            fileReader.read(buffer);
            source = new String(buffer);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        if (source == null) {
            throw new NullPointerException("Error: Properties has not been loaded from file.");
        }
        String[] parameters = source.split("\\r?\\n");
        DBURL = parameters[0];
        DAO = parameters[1];
        DATABASE_LOGIN = parameters[2];
        DATABASE_PASSWORD = parameters[3].toCharArray();
        JDBC_POOL_SIZE = Integer.parseInt(parameters[4]);
    }

    public static String getDAO() {
        return DAO;
    }

    public static int getJdbcPoolSize() {
        return JDBC_POOL_SIZE;
    }

    public static String getDBURL() {
        return DBURL;
    }

    public static String getDatabaseLogin() {
        return DATABASE_LOGIN;
    }

    public static char[] getDatabasePassword() {
        return DATABASE_PASSWORD;
    }
}
