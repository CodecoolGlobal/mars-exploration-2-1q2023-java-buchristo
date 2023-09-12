package com.codecool.marsexploration.mapexplorer.configuration.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;

import java.io.File;

public class MapFileValidator implements ConfigValidator {
    @Override
    public boolean validate(Config config) {
        File file = new File(config.mapFilePath());
        return file.exists() && !file.isDirectory();
    }
}
