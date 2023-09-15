package com.codecool.marsexploration.mapexplorer.rover.deployer;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;

import java.util.List;
import java.util.Random;

public class RoverDeployer {
    private final Map map;
    private final Rover rover;
    // Breaks the DIP (Dependency Injection Principle)
    Random random = new Random();

    public RoverDeployer(Map map, Rover rover) {
        this.map = map;
        this.rover = rover;
    }

    public void deployRover() {
        List<Coordinate> adjacent = rover.getCurrentPos().getAdjacent(1);
        List<Coordinate> emptyAndOnMap = adjacent.stream()
                .filter(map::coordinateIsOnMap)
                .filter(map::isEmpty)
                .toList();
        int randomIndex = random.nextInt(emptyAndOnMap.size());
        Coordinate deploymentCoordinate = emptyAndOnMap.get(randomIndex);
        rover.setCurrentPos(deploymentCoordinate);
    }
}
