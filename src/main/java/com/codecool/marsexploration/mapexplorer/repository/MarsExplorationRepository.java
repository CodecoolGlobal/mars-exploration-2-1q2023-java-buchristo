package com.codecool.marsexploration.mapexplorer.repository;

import com.codecool.marsexploration.mapexplorer.repository.log.DatabaseLog;

import java.util.List;

public class MarsExplorationRepository implements Repository<DatabaseLog> {
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
