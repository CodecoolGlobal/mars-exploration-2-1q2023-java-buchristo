package com.codecool.marsexploration.mapexplorer.exploration.outcome;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationContext;

public class TimeoutAnalyzer implements OutcomeAnalyzer {
    @Override
    public boolean analyze(SimulationContext context) {
        //checks whether the current step number reached the timeout amount.
        return false;
    }
}
