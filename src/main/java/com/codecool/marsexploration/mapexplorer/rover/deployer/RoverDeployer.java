package com.codecool.marsexploration.mapexplorer.rover.deployer;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.rover.Rover;

public interface RoverDeployer {
    Rover deployRover(Coordinate landingCoordinates);
}
