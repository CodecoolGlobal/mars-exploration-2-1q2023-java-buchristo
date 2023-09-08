package com.codecool.marsexploration.mapexplorer.configuration.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;

public class RoverDeploymentConditionsValidator implements ConfigValidator {
    @Override
    public boolean validate(Config config) {
        //is there at least one free spot next to our landing spot so that we can deploy our rover
        return false;
    }
}
