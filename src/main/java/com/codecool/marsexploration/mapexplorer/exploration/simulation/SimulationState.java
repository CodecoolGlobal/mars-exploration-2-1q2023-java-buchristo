package com.codecool.marsexploration.mapexplorer.exploration.simulation;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimulationState {
    private int numberOfStepsTaken;
    private boolean isRunning;
    private final int simulationTimeout;
    private final Rover rover;
    private final Map map;
    private final Coordinate shipCoordinates;
    private final List<String> resourcesToScan;
    private boolean success;
    private Set<Coordinate> visitedCoordinates;
    private final int mineralsInt;

    public SimulationState(int simulationTimeout, Rover rover, Map map, Coordinate shipCoordinates, List<String> resourcesToScan, int mineralsInt) {
        this.simulationTimeout = simulationTimeout;
        this.rover = rover;
        this.map = map;
        this.shipCoordinates = shipCoordinates;
        this.resourcesToScan = resourcesToScan;
        this.mineralsInt = mineralsInt;
        this.numberOfStepsTaken = 0;
        this.isRunning = true;
        this.success = false;
        this.visitedCoordinates = new HashSet<>();
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

    public Map getMap() {
        return map;
    }

    public int getSimulationTimeout() {
        return simulationTimeout;
    }

    public List<String> getResourcesToScan() {
        return resourcesToScan;
    }

    public Rover getRover() {
        return rover;
    }

    public Set<Coordinate> getVisitedCoordinates() {
        return visitedCoordinates;
    }

    public void addVisitedCoordinate(Coordinate coordinate) {
        this.visitedCoordinates.add(coordinate);
    }

    public int getMineralsGoal() {
        return mineralsInt;
    }
}

