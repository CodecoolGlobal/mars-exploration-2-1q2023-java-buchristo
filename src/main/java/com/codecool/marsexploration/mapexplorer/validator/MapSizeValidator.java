package com.codecool.marsexploration.mapexplorer.validator;

import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

public class MapSizeValidator implements Validator {
    private final Map map;

    public MapSizeValidator(Map map) {
        this.map = map;
    }

    @Override
    public boolean validate() {
        return map.getDimension() > 0;
    }
}
