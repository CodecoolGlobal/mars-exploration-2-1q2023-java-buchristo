package com.codecool.marsexploration.mapexplorer.exploration.movement;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

public interface MovementEngine {
    void moveRover (SimulationState simulationState);
}
