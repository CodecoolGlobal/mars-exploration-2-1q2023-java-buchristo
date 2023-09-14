package com.codecool.marsexploration.mapexplorer.logger;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;

public class FinalOutcomeLogger {
    private final Logger consoleLogger;
    private final MapLogger mapLogger;
    private final DatabaseLogger databaseLogger;
    private final SimulationState simulationState;

    public FinalOutcomeLogger(
            Logger consoleLogger,
            MapLogger mapLogger,
            DatabaseLogger databaseLogger,
            SimulationState simulationState) {
        this.consoleLogger = consoleLogger;
        this.mapLogger = mapLogger;
        this.databaseLogger = databaseLogger;
        this.simulationState = simulationState;
    }

    public void logOutcome() {
        if (simulationState.isSuccess()) {
            consoleLogger.log("STEP " + simulationState.getNumberOfStepsTaken() + "; OUTCOME: COLONIZABLE");
            mapLogger.drawExploredMap(simulationState.getMap(), simulationState.getVisitedCoordinates(), simulationState.getRover().getResources(), simulationState.getShipCoordinates());
        } else {
            consoleLogger.log("STEP " + simulationState.getNumberOfStepsTaken() + "; OUTCOME: TIMEOUT");
            mapLogger.drawExploredMap(simulationState.getMap(), simulationState.getVisitedCoordinates(), simulationState.getRover().getResources(), simulationState.getShipCoordinates());
        }
        databaseLogger.log(simulationState);
    }
}
