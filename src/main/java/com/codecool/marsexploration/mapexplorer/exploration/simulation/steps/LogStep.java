package com.codecool.marsexploration.mapexplorer.exploration.simulation.steps;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;
import com.codecool.marsexploration.mapexplorer.logger.Logger;
import com.codecool.marsexploration.mapexplorer.logger.MapLogger;

public class LogStep implements SimulationStep {
    private final Logger logger;
    private final SimulationState simulationState;
    private final MapLogger mapLogger;

    public LogStep(Logger logger, SimulationState simulationState, MapLogger mapLogger) {
        this.logger = logger;
        this.simulationState = simulationState;
        this.mapLogger = mapLogger;
    }

    @Override
    public void executeStep() {
        logger.log("STEP "
                + simulationState.getNumberOfStepsTaken()
                + "; EVENT: Moved to "
                + simulationState.getRover().getCurrentPos());

        mapLogger.drawExploredMap(simulationState.getMap(), simulationState.getVisitedCoordinates(), simulationState.getRover().getResources());    }
}
