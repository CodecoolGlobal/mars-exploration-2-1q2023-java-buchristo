package com.codecool.marsexploration.mapexplorer.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

public class LandingCoordinatesValidator implements Validator {
    private final Map map;
    private final Config config;

    public LandingCoordinatesValidator(Map map, Config config) {
        this.map = map;
        this.config = config;
    }

    @Override
    public boolean validate() {
        return map.isEmpty(config.landingCoordinates());
    }
}
