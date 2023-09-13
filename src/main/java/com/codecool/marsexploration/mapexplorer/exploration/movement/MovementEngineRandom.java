package com.codecool.marsexploration.mapexplorer.exploration.movement;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;

import java.util.List;
import java.util.Random;

public class MovementEngineRandom implements MovementEngine{
    private final Random random = new Random();
    @Override
    public void moveRover(SimulationState simulationState) {
        Map map = simulationState.getMap();
        Rover rover = simulationState.getRover();
        Coordinate nextCoordinate = getRandomEmptyAdjacentCoordinate(map, rover);
        simulationState.addVisitedCoordinate(nextCoordinate);
        rover.setCurrentPos(nextCoordinate);
    }

    private Coordinate getRandomEmptyAdjacentCoordinate (Map map, Rover rover) {
        Coordinate roverPos = rover.getCurrentPos();
        List<Coordinate> availableCoordinates =
                map.getEmptyCoordinates(map.removeOutOfMapCoordinates(roverPos.getAdjacent(1)));
        return availableCoordinates.get(random.nextInt(availableCoordinates.size()));
    }
}
