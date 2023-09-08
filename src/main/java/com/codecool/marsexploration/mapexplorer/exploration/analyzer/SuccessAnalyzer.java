package com.codecool.marsexploration.mapexplorer.exploration.analyzer;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationContext;

public class SuccessAnalyzer implements OutcomeAnalyzer {

    @Override
    public boolean analyze(SimulationContext context) {
        //checks whether the right conditions for colonization are met.
        return false;
    }
}
