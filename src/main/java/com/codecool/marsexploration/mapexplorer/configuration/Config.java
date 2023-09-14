package com.codecool.marsexploration.mapexplorer.configuration;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

import java.util.List;

public record Config(
        String mapFilePath,
        List<String> resourceSymbols,
        int simulationTimeout,
        int mineralsGoal,
        int waterGoal) {
}
