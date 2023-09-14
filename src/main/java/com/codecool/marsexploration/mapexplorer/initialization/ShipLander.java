package com.codecool.marsexploration.mapexplorer.initialization;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ShipLander {
    private final Random random = new Random();

    public void landShip (Map map, Coordinate landingCoordinates) {
        map.getRepresentation()[landingCoordinates.X()][landingCoordinates.Y()] = "S";
    }

    public Coordinate getLandingCoordinates (Map map) {
        List<Coordinate> emptyCoordinates = getEmptyCoordinates(map);
        return emptyCoordinates.get(random.nextInt(emptyCoordinates.size()));
    }

    private List<Coordinate> getEmptyCoordinates(Map map) {
        List<Coordinate> emptyCoordinates = new ArrayList<>();
        for (int i = 0; i < map.getDimension(); i++) {
            for (int j = 0; j < map.getDimension(); j++) {
                Coordinate currentCoordinate = new Coordinate(i,j);
                if(map.isEmpty(currentCoordinate)) {
                    emptyCoordinates.add(currentCoordinate);
                }
            }
        }
        return emptyCoordinates.stream()
                .filter(c -> map.removeOutOfMapCoordinates(c.getAdjacent(1))
                        .stream()
                        .anyMatch(map::isEmpty))
                .collect(Collectors.toList());
    }
}
