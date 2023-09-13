package com.codecool.marsexploration.mapexplorer.exploration.analyzer;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;

public class LackOfResourcesAnalyzer implements Analyzer {
    @Override
    public boolean analyze(SimulationState context) {
        //checks whether the rover almost explored the whole chart and no right condition is found.
        return false;
    }
}
