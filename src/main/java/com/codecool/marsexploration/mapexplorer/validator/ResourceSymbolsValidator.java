package com.codecool.marsexploration.mapexplorer.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;

public class ResourceSymbolsValidator implements Validator {
    private final Config config;

    public ResourceSymbolsValidator(Config config) {
        this.config = config;
    }

    @Override
    public boolean validate() {
        return !config.resourceSymbols().isEmpty();
    }
}
