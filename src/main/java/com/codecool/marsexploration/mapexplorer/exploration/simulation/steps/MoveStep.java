package com.codecool.marsexploration.mapexplorer.exploration.simulation.steps;

import com.codecool.marsexploration.mapexplorer.exploration.movement.MovementEngine;
import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;

public class MoveStep implements SimulationStep {
    private final MovementEngine engine;
    private final SimulationState simulationState;

    public MoveStep(MovementEngine engine, SimulationState simulationState) {
        this.engine = engine;
        this.simulationState = simulationState;
    }

    @Override
    public void executeStep() {
        engine.moveRover(simulationState);
        int nextStepNumber = simulationState.getNumberOfStepsTaken() + 1;
        simulationState.setNumberOfStepsTaken(nextStepNumber);
    }
}
