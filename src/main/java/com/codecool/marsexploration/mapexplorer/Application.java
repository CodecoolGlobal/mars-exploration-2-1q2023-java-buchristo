package com.codecool.marsexploration.mapexplorer;

import com.codecool.marsexploration.mapexplorer.configuration.Config;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

import java.util.List;

import static com.codecool.marsexploration.mapexplorer.Constants.*;

public class Application {
    private static final String workDir = "src/main";
    static String mapFilePath = workDir + "/resources/maps/exploration-0.map";
    static Coordinate landingCoordinates = new Coordinate(6, 6);
    static List<String> resourcesToScanFor = List.of(MINERAL, WATER);
    static int simTimeOut = 1000;
    static Config config = new Config(mapFilePath, landingCoordinates, resourcesToScanFor, simTimeOut);

    public static void main(String[] args) {
        //liste an resources
        //visibility range
        //

        // Create config, map loader, validators, analyzers etc.

        //run simulation validator, if true, run sim

    }
}

