package com.codecool.marsexploration.mapexplorer.validator;

import com.codecool.marsexploration.mapexplorer.logger.Logger;

import java.util.List;

public class ExplorationValidator {
    private final List<Validator> explorationValidators;
    private final Logger logger;

    public ExplorationValidator(List<Validator> explorationValidators, Logger logger) {
        this.explorationValidators = explorationValidators;
        this.logger = logger;
    }

    public void validate() {
        if(!explorationValidators.stream().allMatch(v -> v.validate())) {
            logger.log("Map validation failed!");
            System.exit(1);
        }
    }
}
