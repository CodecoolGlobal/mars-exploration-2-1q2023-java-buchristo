package com.codecool.marsexploration.mapexplorer.exploration.analyzer;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;

public class SuccessAnalyzer implements OutcomeAnalyzer {

    @Override
    public boolean analyze(SimulationState context) {
        //checks whether the right conditions for colonization are met.
        return false;
    }
}
