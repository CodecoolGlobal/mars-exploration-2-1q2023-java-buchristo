package com.codecool.marsexploration.mapexplorer.rover.deployer;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;

import java.util.List;
import java.util.Random;

public class RoverDeployerImpl implements RoverDeployer{
    private final Map map;
    private final Rover rover;
    Random random = new Random();

    public RoverDeployerImpl(Map map, Rover rover) {
        this.map = map;
        this.rover = rover;
    }

    @Override
    public void deployRover() {
        List<Coordinate> adjacent = rover.getCurrentPos().getAdjacent(1);
        List<Coordinate> emptyAndOnMap = adjacent.stream()
                .filter(map::coordinateIsOnMap)
                .filter(map::isEmpty)
                .toList();
        rover.setCurrentPos(emptyAndOnMap.get(random.nextInt(emptyAndOnMap.size())));
    }
}
