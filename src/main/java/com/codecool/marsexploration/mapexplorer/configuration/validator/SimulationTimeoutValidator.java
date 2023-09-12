package com.codecool.marsexploration.mapexplorer.configuration.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;

public class SimulationTimeoutValidator implements ConfigValidator {
    @Override
    public boolean validate(Config config) {
        return config.simulationTimeout() > 0;
    }
}
