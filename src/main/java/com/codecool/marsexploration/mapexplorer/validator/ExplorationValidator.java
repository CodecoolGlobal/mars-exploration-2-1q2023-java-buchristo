package com.codecool.marsexploration.mapexplorer.validator;

import com.codecool.marsexploration.mapexplorer.logger.Logger;

import java.util.List;

public class ExplorationValidator {
    private final List<Validator> validators;
    private final Logger logger;

    public ExplorationValidator(List<Validator> validators, Logger logger) {
        this.validators = validators;
        this.logger = logger;
    }

    public void validate() {
        if(!validators.stream().allMatch(Validator::validate)) {
            logger.log("Map validation failed!");
            System.exit(1);
        }
    }
}
