package com.codecool.marsexploration.mapexplorer.exploration.analyzer;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;

public class TimeoutAnalyzer implements OutcomeAnalyzer {
    @Override
    public boolean analyze(SimulationState context) {
        //checks whether the current step number reached the timeout amount.
        return false;
    }
}
