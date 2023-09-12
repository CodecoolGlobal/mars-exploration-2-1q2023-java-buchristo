package com.codecool.marsexploration.mapexplorer.configuration.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

import java.util.List;

public class RoverDeploymentConditionsValidator implements ConfigValidator {
    private final Map map;

    public RoverDeploymentConditionsValidator(Map map) {
        this.map = map;
    }

    @Override
    public boolean validate(Config config) {
        int x = config.landingCoordinates().X();
        int y = config.landingCoordinates().Y();
        List<Coordinate> coordinates = List.of(
                new Coordinate(x - 1, y - 1),
                new Coordinate(x, y - 1),
                new Coordinate(x + 1, y - 1),
                new Coordinate(x + 1, y),
                new Coordinate(x + 1, y + 1),
                new Coordinate(x, y + 1),
                new Coordinate(x - 1, y + 1),
                new Coordinate(x - 1, y)
        );

        return coordinates.stream()
                .anyMatch(c -> map.isEmpty(c));
    }
}
