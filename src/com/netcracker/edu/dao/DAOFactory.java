package com.netcracker.edu.dao;

import com.netcracker.edu.util.ConnectionProperties;
import org.apache.log4j.Logger;

/**
 * Created by FlowRyder.
 */
public class DAOFactory {
    private static final Logger LOGGER = Logger.getLogger(DAOFactory.class);
    private static final DAO DAO_INSTANCE;

    static {
        switch (ConnectionProperties.getDAO()) {
            case "OracleDAO":
                DAO_INSTANCE = OracleDAO.getInstance();
                break;
            case "FileDAO":
                DAO_INSTANCE = FileDAO.getInstance();
                break;
            default:
                DAO_INSTANCE = null;
                LOGGER.warn("Error: Invalid value of DAO.");
                System.exit(-1);
        }
    }

    public static DAO getDAO() {
        return DAO_INSTANCE;
    }
}
