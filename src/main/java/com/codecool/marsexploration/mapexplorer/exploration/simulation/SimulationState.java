package com.codecool.marsexploration.mapexplorer.exploration.simulation;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;

import java.util.List;

public class SimulationState {
    private int numberOfStepsTaken;
    private boolean isRunning;
    private final int simulationTimeout;
    private final Rover rover;
    private final Map map;
    private final Coordinate shipCoordinates;
    private final List<String> resourcesToScan;
    private boolean success;

    public SimulationState(int simulationTimeout, Rover rover, Map map, Coordinate shipCoordinates, List<String> resourcesToScan) {
        this.simulationTimeout = simulationTimeout;
        this.rover = rover;
        this.map = map;
        this.shipCoordinates = shipCoordinates;
        this.resourcesToScan = resourcesToScan;
        this.numberOfStepsTaken = 0;
        this.isRunning = true;
        this.success = false;
    }

    public void setIsRunningToFalse(){
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setSuccessToTrue() {
        success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setNumberOfStepsTaken(int numberOfStepsTaken) {
        this.numberOfStepsTaken = numberOfStepsTaken;
    }

    public int getNumberOfStepsTaken() {
        return numberOfStepsTaken;
    }
}
