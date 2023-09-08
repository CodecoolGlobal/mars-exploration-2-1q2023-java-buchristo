package com.codecool.marsexploration.mapexplorer.exploration.outcome;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationContext;

public class LackOfResourcesAnalyzer implements OutcomeAnalyzer {
    @Override
    public boolean analyze(SimulationContext context) {
        //checks whether the rover almost explored the whole chart and no right condition is found.
        return false;
    }
}
