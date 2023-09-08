package com.codecool.marsexploration.mapexplorer.configuration;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

import java.util.List;

public record Config(
        String mapFilePath,
        Coordinate landingCoordinates,
        List<String> resourceSymbols,
        int simulationTimeout) {
}
