package com.codecool.marsexploration.mapexplorer.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

public class RoverDeploymentConditionsValidator implements Validator {
    private final Map map;
    private final Config config;

    public RoverDeploymentConditionsValidator(Map map, Config config) {
        this.map = map;
        this.config = config;
    }

    @Override
    public boolean validate() {
        return config.landingCoordinates().getAdjacent(1).stream()
                .anyMatch(c -> map.isEmpty(c));
    }
}
