package com.codecool.marsexploration.mapexplorer.validator;

import com.codecool.marsexploration.mapexplorer.logger.Logger;

import java.util.List;

public class SetupValidator {
    private final List<Validator> setupValidators;
    private final Logger logger;

    public SetupValidator(List<Validator> setupValidators, Logger logger) {
        this.setupValidators = setupValidators;
        this.logger = logger;
    }

    public void validate() {
        if(!setupValidators.stream().allMatch(v -> v.validate())) {
            logger.log("Setup validation failed!");
            System.exit(1);
        }
    }
}
