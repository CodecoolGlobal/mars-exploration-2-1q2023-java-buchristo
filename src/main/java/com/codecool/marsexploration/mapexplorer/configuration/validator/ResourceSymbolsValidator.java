package com.codecool.marsexploration.mapexplorer.configuration.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;

public class ResourceSymbolsValidator implements ConfigValidator {
    @Override
    public boolean validate(Config config) {
        return !config.resourceSymbols().isEmpty();
    }
}
