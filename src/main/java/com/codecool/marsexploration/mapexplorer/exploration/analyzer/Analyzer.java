package com.codecool.marsexploration.mapexplorer.exploration.analyzer;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;

public interface OutcomeAnalyzer {
    boolean analyze(SimulationState context);
}
