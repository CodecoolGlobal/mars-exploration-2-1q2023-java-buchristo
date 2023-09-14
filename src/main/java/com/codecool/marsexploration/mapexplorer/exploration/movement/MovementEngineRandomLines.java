package com.codecool.marsexploration.mapexplorer.exploration.movement;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class MovementEngineRandomLines implements MovementEngine{
    private final Random random = new Random();
    @Override
    public void moveRover(SimulationState simulationState) {
        Map map = simulationState.getMap();
        Rover rover = simulationState.getRover();
        Coordinate currentPos = rover.getCurrentPos();
        Coordinate previousPos = rover.getPreviousPos();
        Coordinate direction = rover.getDirection();
        Set<Coordinate> visitedCoordinates = simulationState.getVisitedCoordinates();

        Coordinate nextPos = getNextCoordinate(map, currentPos, previousPos, direction, visitedCoordinates);

        simulationState.addVisitedCoordinate(currentPos);
        rover.setPreviousPos(currentPos);
        rover.setCurrentPos(nextPos);
        int newDirectionX = Integer.signum(nextPos.X() - currentPos.X());
        int newDirectionY = Integer.signum(nextPos.Y() - currentPos.Y());
        rover.setDirection(new Coordinate(newDirectionX, newDirectionY));
    }

    private Coordinate getNextCoordinate(Map map, Coordinate currentPos, Coordinate previousPos, Coordinate direction, Set<Coordinate> visitedCoordinates) {
        int aheadX = currentPos.X() + direction.X();
        int aheadY = currentPos.Y() + direction.Y();
        Coordinate aheadCoordinate = new Coordinate(aheadX, aheadY);

        if (map.coordinateIsOnMap(aheadCoordinate) && map.isEmpty(aheadCoordinate) && !visitedCoordinates.contains(aheadCoordinate)) {
            return aheadCoordinate;
        }
        else {
            List<Coordinate> availableCoordinates = getAvailableCoordinates(map, currentPos, previousPos, visitedCoordinates, aheadCoordinate);
            return availableCoordinates.get(random.nextInt(availableCoordinates.size()));
        }
    }

    private List<Coordinate> getAvailableCoordinates (
            Map map, Coordinate currentPos,
            Coordinate previousPos,
            Set<Coordinate> visitedCoordinates,
            Coordinate aheadCoordinate
    ) {
        List<Coordinate> availableCoordinates =
                map.getEmptyCoordinates(map.removeOutOfMapCoordinates(currentPos.getAdjacent(1)));

        List<Coordinate> unexploredCoordinates = availableCoordinates
                        .stream()
                        .filter(c  -> !visitedCoordinates.contains(c))
                        .collect(Collectors.toList());

        if (unexploredCoordinates.size() > 0) {
            return unexploredCoordinates;
        }
        if (availableCoordinates.contains(aheadCoordinate)){
            return List.of(aheadCoordinate);
        }
        return availableCoordinates;
    }
}
