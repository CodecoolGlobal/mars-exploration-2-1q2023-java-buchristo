package com.codecool.marsexploration.mapexplorer.logger;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

import java.util.Set;
import java.util.stream.Collectors;

public class MapLogger {

    public void drawExploredMap(Map map, Set<Coordinate> visitedCoordinates, java.util.Map<String, Set<Coordinate>> scannedResources, Coordinate shipLandingCoordinate) {
        visitedCoordinates.stream().map(c -> map.getRepresentation()[c.X()][c.Y()] = "\u001B[35m.\u001B[0m").collect(Collectors.toList());
        scannedResources.get("%").stream().map(mineral -> map.getRepresentation()[mineral.X()][mineral.Y()] = "\u001B[32m%\u001B[0m").collect(Collectors.toList());
        scannedResources.get("*").stream().map(water -> map.getRepresentation()[water.X()][water.Y()] = "\u001B[32m*\u001B[0m").collect(Collectors.toList());
        map.getRepresentation()[shipLandingCoordinate.X()][shipLandingCoordinate.Y()] = "\u001B[33mS\u001B[0m";
        System.out.println(map.toString());
    }
}
