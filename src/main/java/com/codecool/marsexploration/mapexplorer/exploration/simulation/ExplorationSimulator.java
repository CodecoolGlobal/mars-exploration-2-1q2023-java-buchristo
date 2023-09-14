package com.codecool.marsexploration.mapexplorer.exploration.simulation;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.steps.*;
import com.codecool.marsexploration.mapexplorer.logger.*;

import java.util.concurrent.TimeUnit;

public class ExplorationSimulator {
    private final SimulationState simulationState;
    private final SimulationStep moveStep;
    private final SimulationStep scanStep;
    private final SimulationStep analyzeStep;
    private final SimulationStep logStep;
    private final FinalOutcomeLogger finalOutcomeLogger;

    public ExplorationSimulator(
            SimulationState simulationState,
            SimulationStep moveStep,
            SimulationStep scanStep,
            SimulationStep analyzeStep,
            SimulationStep logStep,
            FinalOutcomeLogger finalOutcomeLogger) {
        this.simulationState = simulationState;
        this.moveStep = moveStep;
        this.scanStep = scanStep;
        this.analyzeStep = analyzeStep;
        this.logStep = logStep;
        this.finalOutcomeLogger = finalOutcomeLogger;
    }

    public void run() {

        while (simulationState.isRunning()) {
            moveStep.executeStep();
            scanStep.executeStep();
            analyzeStep.executeStep();
            logStep.executeStep();

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        finalOutcomeLogger.logOutcome();
    }
}
