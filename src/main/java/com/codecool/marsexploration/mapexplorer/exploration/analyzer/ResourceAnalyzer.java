package com.codecool.marsexploration.mapexplorer.exploration.analyzer;

import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;

import java.util.List;

public class ResourceAnalyzer implements OutcomeAnalyzer{
    @Override
    public boolean analyze(SimulationState simulationState) {
        Rover rover = simulationState.getRover();
        Map map = simulationState.getMap();
        Coordinate currentCoordinate = rover.getCurrentPos();
        List<Coordinate> adjacentCoordinates = currentCoordinate.getAdjacent(rover.getVisibilityRange());
        List<Coordinate> adjacentCoordinatesOnMap = map.removeOutOfMapCoordinates(adjacentCoordinates);

        List<Coordinate> mineralsWeCanSee = adjacentCoordinatesOnMap.stream()
                .filter(r -> map.getByCoordinate(r).equals(simulationState.getResourcesToScan().get(0)))
                .toList();
        for (Coordinate coordinate : mineralsWeCanSee) {
            rover.setResources("%", coordinate);
        }

        return false;
    }
}
