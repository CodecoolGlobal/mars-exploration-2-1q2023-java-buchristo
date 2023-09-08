package com.codecool.marsexploration.mapexplorer.repository;

import com.codecool.marsexploration.mapexplorer.repository.log.DatabaseLog;
import com.codecool.marsexploration.mapexplorer.repository.manager.DBConnectionManager;

import java.util.List;

public class MarsExplorationRepository implements Repository<DatabaseLog> {
    private final DBConnectionManager dbConnectionManager;

    public MarsExplorationRepository(DBConnectionManager dbConnectionManager) {
        this.dbConnectionManager = dbConnectionManager;
    }

    @Override
    public DatabaseLog getById(int id) {
        return null;
    }

    @Override
    public List<DatabaseLog> getAll() {
        return null;
    }

    @Override
    public void insert(DatabaseLog databaseLog) {

    }

    @Override
    public void update(DatabaseLog databaseLog) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteAll() {

    }
}
