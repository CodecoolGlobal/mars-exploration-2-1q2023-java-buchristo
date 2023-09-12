package com.codecool.marsexploration.mapexplorer.validator;

import com.codecool.marsexploration.mapexplorer.configuration.Config;

import java.io.File;

public class MapFilePathValidator implements Validator {
    private final Config config;

    public MapFilePathValidator(Config config) {
        this.config = config;
    }

    @Override
    public boolean validate() {
        File file = new File(config.mapFilePath());
        return file.exists() && !file.isDirectory();
    }
}
