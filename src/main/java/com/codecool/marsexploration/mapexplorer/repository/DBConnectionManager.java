package com.codecool.marsexploration.mapexplorer.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private static final String JDBC_URL = "jdbc:sqlite:src/main/resources/dbs/MarsExploration.db";
    private Connection connection;

    public DBConnectionManager() {
        try {
            connection = DriverManager.getConnection(JDBC_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
