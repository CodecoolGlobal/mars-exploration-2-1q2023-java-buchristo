package com.codecool.marsexploration.mapexplorer.configuration.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;

public class SimulationTimeoutValidator implements ConfigValidator {
    @Override
    public boolean validate(Config config) {
        //is the simTimeout > 0
        return false;
    }
}
