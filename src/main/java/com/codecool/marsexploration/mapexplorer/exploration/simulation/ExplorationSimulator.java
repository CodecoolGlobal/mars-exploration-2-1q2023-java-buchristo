package com.codecool.marsexploration.mapexplorer.exploration.simulation;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.steps.SimulationStep;
import com.codecool.marsexploration.mapexplorer.logger.FinalOutcomeLogger;

import java.util.List;

public class ExplorationSimulator {
    private final SimulationState state;
    private final List<SimulationStep> steps;
    private final FinalOutcomeLogger logger;

    public ExplorationSimulator(
            SimulationState state,
            List<SimulationStep> steps,
            FinalOutcomeLogger logger) {
        this.state = state;
        this.steps = steps;
        this.logger = logger;
    }

    public void run() {
        while (state.isRunning()) {
            steps.forEach(SimulationStep::executeStep);
        }
        logger.logOutcome();
    }
}
