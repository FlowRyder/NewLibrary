package com.netcracker.edu.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by FlowRyder.
 */
public class ConnectionPool {
    public static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static final ArrayBlockingQueue<Connection> CONNECTIONS =
            new ArrayBlockingQueue<>(ConnectionProperties.getJdbcPoolSize());
    private static final ConnectionPool INSTANCE = new ConnectionPool();

    private ConnectionPool() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            for (int i = 0; i < CONNECTIONS.remainingCapacity(); i++) {
                Connection connection =
                        DriverManager.getConnection(ConnectionProperties.getDBURL(),
                                ConnectionProperties.getDatabaseLogin(),
                                String.valueOf(ConnectionProperties.getDatabasePassword()));
                CONNECTIONS.add(connection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = CONNECTIONS.take();
        } catch (InterruptedException e) {
            LOGGER.warn(e.getMessage());
        }
        return connection;
    }

    public static void releaseConnection(Connection connection) {
        try {
            CONNECTIONS.put(connection);
        } catch (InterruptedException e) {
            LOGGER.warn(e.getMessage());
        }
    }
}
