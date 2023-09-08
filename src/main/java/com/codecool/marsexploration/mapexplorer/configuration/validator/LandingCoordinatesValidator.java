package com.codecool.marsexploration.mapexplorer.configuration.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;

public class LandingCoordinatesValidator implements ConfigValidator {
    @Override
    public boolean validate(Config config) {
        //is the spot we're trying to land on free
        return false;
    }
}
