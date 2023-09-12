package com.codecool.marsexploration.mapexplorer.configuration.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

public class LandingCoordinatesValidator implements ConfigValidator {
    private final Map map;

    public LandingCoordinatesValidator(Map map) {
        this.map = map;
    }

    @Override
    public boolean validate(Config config) {
        return map.isEmpty(config.landingCoordinates());
    }
}
