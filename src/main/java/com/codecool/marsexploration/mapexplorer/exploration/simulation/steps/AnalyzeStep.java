package com.codecool.marsexploration.mapexplorer.exploration.simulation.steps;

import com.codecool.marsexploration.mapexplorer.exploration.analyzer.Analyzer;
import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;

public class AnalyzeStep implements SimulationStep {
    private final Analyzer timeoutAnalyzer;
    private final Analyzer successAnalyzer;
    private final SimulationState simulationState;

    public AnalyzeStep(
            Analyzer timeoutAnalyzer,
            Analyzer successAnalyzer, SimulationState simulationState) {
        this.timeoutAnalyzer = timeoutAnalyzer;
        this.successAnalyzer = successAnalyzer;
        this.simulationState = simulationState;
    }

    @Override
    public void executeStep() {
        if (timeoutAnalyzer.analyze(simulationState)) {
            simulationState.setIsRunningToFalse();
        }

        if (successAnalyzer.analyze(simulationState)) {
            simulationState.setIsRunningToFalse();
            simulationState.setSuccessToTrue();
        }
    }
}
