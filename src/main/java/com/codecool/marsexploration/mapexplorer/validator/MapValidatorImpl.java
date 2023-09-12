package com.codecool.marsexploration.mapexplorer.validator;

import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.validator.Validator;

public class MapValidatorImpl implements Validator {
    private final Map map;

    public MapValidatorImpl(Map map) {
        this.map = map;
    }

    @Override
    public boolean validate() {
        return map.getDimension() > 0;
    }
}
