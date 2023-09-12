package com.codecool.marsexploration.mapexplorer.configuration.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

public class RoverDeploymentConditionsValidator implements ConfigValidator {
    private final Map map;

    public RoverDeploymentConditionsValidator(Map map) {
        this.map = map;
    }

    @Override
    public boolean validate(Config config) {
        return config.landingCoordinates().getAdjacent(1).stream()
                .anyMatch(c -> map.isEmpty(c));
    }
}
