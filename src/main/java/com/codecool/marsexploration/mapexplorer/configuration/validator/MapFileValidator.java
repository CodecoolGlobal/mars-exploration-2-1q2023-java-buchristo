package com.codecool.marsexploration.mapexplorer.configuration.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;

public class MapFileValidator implements ConfigValidator {
    @Override
    public boolean validate(Config config) {
        //is the file path not empty (but I'd also say: is it a correct path, i.e. pointing to a .map file)
        return false;
    }
}
