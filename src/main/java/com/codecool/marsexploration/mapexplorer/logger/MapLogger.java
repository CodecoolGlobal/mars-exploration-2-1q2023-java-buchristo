package com.codecool.marsexploration.mapexplorer.logger;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

import java.util.Set;
import java.util.stream.Collectors;

public class MapLogger {

    public void drawExploredMap(Map map, Set<Coordinate> visitedCoordinates, java.util.Map<String, Set<Coordinate>> scannedRessources) {
        visitedCoordinates.stream().map(c -> map.getRepresentation()[c.X()][c.Y()] = "\u001B[35m.\u001B[0m").collect(Collectors.toList());
        scannedRessources.get("%").stream().map(mineral -> map.getRepresentation()[mineral.X()][mineral.Y()] = "\u001B[32m%\u001B[0m").collect(Collectors.toList());
        scannedRessources.get("*").stream().map(water -> map.getRepresentation()[water.X()][water.Y()] = "\u001B[32m*\u001B[0m").collect(Collectors.toList());
        System.out.println(map.toString());
    }
}
