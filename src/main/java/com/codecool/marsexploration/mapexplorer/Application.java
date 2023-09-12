package com.codecool.marsexploration.mapexplorer;

import com.codecool.marsexploration.mapexplorer.maploader.MapLoader;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoaderImpl;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

public class Application {
    private static final String workDir = "src/main";

    public static void main(String[] args) {
        String mapFilePath = workDir + "/resources/maps/exploration-0.map";
        Coordinate landingCoordinates = new Coordinate(6, 6);

        MapLoader mapLoader = new MapLoaderImpl();
        mapLoader.load(mapFilePath);

        // Create config, map loader, validators, analyzers etc.

        //run simulation validator, if true, run sim

    }
}

