package com.codecool.marsexploration.mapexplorer.exploration.simulation.steps;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;
import com.codecool.marsexploration.mapexplorer.logger.Logger;

public class LogStep implements SimulationStep {
    private final Logger logger;
    private final SimulationState simulationState;

    public LogStep(Logger logger, SimulationState simulationState) {
        this.logger = logger;
        this.simulationState = simulationState;
    }

    @Override
    public void executeStep() {
        logger.log("STEP "
                + simulationState.getNumberOfStepsTaken()
                + "; EVENT: Moved to "
                + simulationState.getRover().getCurrentPos());
    }
}
