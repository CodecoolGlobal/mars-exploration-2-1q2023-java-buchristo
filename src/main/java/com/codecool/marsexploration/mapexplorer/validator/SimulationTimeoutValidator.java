package com.codecool.marsexploration.mapexplorer.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;

public class SimulationTimeoutValidator implements Validator {
    private final Config config;

    public SimulationTimeoutValidator(Config config) {
        this.config = config;
    }

    @Override
    public boolean validate() {
        return config.simulationTimeout() > 0;
    }
}
