package com.codecool.marsexploration.mapexplorer.maploader.validator;

import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

public class MapValidatorImpl implements MapValidator{
    @Override
    public boolean validate(Map map) {
        return map.getDimension() > 0;
    }
}
