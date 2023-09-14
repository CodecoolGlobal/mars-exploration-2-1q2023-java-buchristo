package com.codecool.marsexploration.mapexplorer.exploration.movement;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;

import java.util.List;
import java.util.Random;

public class MovementEngineRandomLines implements MovementEngine{
    private final Random random = new Random();
    @Override
    public void moveRover(SimulationState simulationState) {
        Map map = simulationState.getMap();
        Rover rover = simulationState.getRover();
        Coordinate currentPos = rover.getCurrentPos();
        Coordinate previousPos = rover.getPreviousPos();
        Coordinate direction = rover.getDirection();

        Coordinate nextPos = getNextCoordinate(map, currentPos, previousPos, direction);

        simulationState.addVisitedCoordinate(nextPos);
        rover.setPreviousPos(rover.getCurrentPos());
        rover.setCurrentPos(nextPos);
        int newDirectionX = Integer.signum(nextPos.X() - currentPos.X());
        int newDirectionY = Integer.signum(nextPos.Y() - currentPos.Y());
        rover.setDirection(new Coordinate(newDirectionX, newDirectionY));
    }

    private Coordinate getNextCoordinate(Map map, Coordinate currentPos, Coordinate previousPos, Coordinate direction) {
        int aheadX = currentPos.X() + direction.X();
        int aheadY = currentPos.Y() + direction.Y();
        Coordinate aheadCoordinate = new Coordinate(aheadX, aheadY);

        if (map.coordinateIsOnMap(aheadCoordinate) && map.isEmpty(aheadCoordinate)) {
            return aheadCoordinate;
        }
        else {
            List<Coordinate> availableCoordinates =
                    map.getEmptyCoordinates(map.removeOutOfMapCoordinates(currentPos.getAdjacent(1)));
            if (availableCoordinates.size() > 1) {
                availableCoordinates.remove(previousPos);
            }
            return availableCoordinates.get(random.nextInt(availableCoordinates.size()));
        }
    }
}
