package com.netcracker.edu.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by FlowRyder.
 */
public class JDBCHandler {
    public static final Logger LOGGER = Logger.getLogger(JDBCHandler.class);
    public static boolean execute(PreparedStatement preparedStatement, Connection connection) {
        boolean result = true;
        try  {
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            result = false;
            LOGGER.warn("");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                LOGGER.warn("");
            }
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
        return result;
    }
}
