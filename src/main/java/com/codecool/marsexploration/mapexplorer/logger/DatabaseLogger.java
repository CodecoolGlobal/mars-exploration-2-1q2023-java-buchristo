package com.codecool.marsexploration.mapexplorer.logger;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;
import com.codecool.marsexploration.mapexplorer.repository.Repository;
import com.codecool.marsexploration.mapexplorer.repository.model.DatabaseLog;

import java.time.LocalDateTime;

public class DatabaseLogger {
    private final Repository repository;

    public DatabaseLogger(Repository repository) {
        this.repository = repository;
    }

    public void log(SimulationState state) {
        String timestamp = LocalDateTime.now().toString();
        int minerals = state.getRover().getResources().get("%").size();
        int water = state.getRover().getResources().get("*").size();
        int success = 0;

        if(state.isSuccess()) {
            success = 1;
        }

        DatabaseLog log = new DatabaseLog(
                timestamp,
                state.getNumberOfStepsTaken(),
                minerals,
                water,
                success
        );

        repository.insert(log);
    }
}
