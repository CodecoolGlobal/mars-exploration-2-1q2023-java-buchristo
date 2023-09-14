package com.codecool.marsexploration.mapexplorer.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

public class LandingCoordinatesValidator implements Validator {
    private final Map map;
    private final Coordinate landingCoordinate;

    public LandingCoordinatesValidator(Map map, Coordinate landingCoordinate) {
        this.map = map;
        this.landingCoordinate = landingCoordinate;
    }

    @Override
    public boolean validate() {
        return map.isEmpty(landingCoordinate);
    }
}
