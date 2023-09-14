package com.codecool.marsexploration.mapexplorer.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

public class RoverDeploymentConditionsValidator implements Validator {
    private final Map map;
    private final Coordinate landingCoordinates;

    public RoverDeploymentConditionsValidator(Map map, Coordinate landingCoordinates) {
        this.map = map;
        this.landingCoordinates = landingCoordinates;
    }

    @Override
    public boolean validate() {
        return landingCoordinates.getAdjacent(1).stream()
                .anyMatch(c -> map.isEmpty(c));
    }
}
