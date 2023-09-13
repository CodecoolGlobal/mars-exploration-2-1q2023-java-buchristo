package com.codecool.marsexploration.mapexplorer.exploration.analyzer;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;

public class SuccessAnalyzer implements Analyzer {

    @Override
    public boolean analyze(SimulationState state) {
        return state.getRover().getResources().get("%").size() >= state.getMineralsGoal();
    }
}
