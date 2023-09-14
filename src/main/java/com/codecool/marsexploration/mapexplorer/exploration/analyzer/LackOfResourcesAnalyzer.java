package com.codecool.marsexploration.mapexplorer.exploration.analyzer;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;

public class LackOfResourcesAnalyzer implements Analyzer {

    @Override
    public boolean analyze(SimulationState state) {
        return state.getVisitedCoordinates().size() > Math.pow(state.getMap().getDimension(),2)*0.8;
    }
}
