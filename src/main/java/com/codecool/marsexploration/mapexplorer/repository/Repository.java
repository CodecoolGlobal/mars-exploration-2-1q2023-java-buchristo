package com.codecool.marsexploration.mapexplorer.repository;

import com.codecool.marsexploration.mapexplorer.logger.ConsoleLogger;
import com.codecool.marsexploration.mapexplorer.logger.Logger;
import com.codecool.marsexploration.mapexplorer.repository.model.DatabaseLog;
import com.codecool.marsexploration.mapexplorer.repository.manager.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Repository {
    private final DBConnectionManager dbConnectionManager;
    private final Logger logger = new ConsoleLogger();

    public Repository(DBConnectionManager dbConnectionManager) {
        this.dbConnectionManager = dbConnectionManager;
    }

    public void insert(DatabaseLog log) {
        String sql = "INSERT INTO logs(" +
                "timestamp," +
                "number_of_steps," +
                "minerals," +
                "water," +
                "successful_outcome" +
                ") VALUES(?,?,?,?,?)";

        try (Connection conn = dbConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, log.timeStamp());
            pstmt.setInt(2, log.numberOfSteps());
            pstmt.setInt(3, log.minerals());
            pstmt.setInt(4, log.water());
            pstmt.setInt(5, log.success());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(e.getMessage());
        }
    }
}
