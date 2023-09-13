package com.codecool.marsexploration.mapexplorer.logger;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

import java.util.Set;

public class MapLogger {

    public void drawExploredMap(Map map, Set<Coordinate> visitedCoordinates) {
        for(Coordinate coordinate : visitedCoordinates){
            map.getRepresentation()[coordinate.X()][coordinate.Y()] = "\u001B[31m.\u001B[0m";
        }
        System.out.println(map.toString());
    }
}
