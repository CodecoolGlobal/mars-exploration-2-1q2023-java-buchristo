package com.codecool.marsexploration.mapexplorer.exploration.analyzer;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;

public class TimeoutAnalyzer implements Analyzer {
    @Override
    public boolean analyze(SimulationState state) {
        return state.getNumberOfStepsTaken() >= state.getSimulationTimeout();
    }
}
