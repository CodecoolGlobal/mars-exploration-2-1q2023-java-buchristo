package com.codecool.marsexploration.mapexplorer;

import com.codecool.marsexploration.mapexplorer.configuration.Config;
import com.codecool.marsexploration.mapexplorer.exploration.simulation.ExplorationSimulator;
import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;
import com.codecool.marsexploration.mapexplorer.validator.*;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoader;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoaderImpl;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;
import com.codecool.marsexploration.mapexplorer.rover.RoverImpl;
import com.codecool.marsexploration.mapexplorer.rover.deployer.RoverDeployer;
import com.codecool.marsexploration.mapexplorer.rover.deployer.RoverDeployerImpl;

import java.util.List;

import static com.codecool.marsexploration.mapexplorer.Constants.*;

public class Application {
    private static final String workDir = "src/main";
    static String mapFilePath = workDir + "/resources/maps/exploration-0.map";
    static Coordinate landingCoordinates = new Coordinate(6, 6);
    static List<String> resourcesToScanFor = List.of(MINERAL, WATER);
    static int simTimeOut = 1000;

    public static void main(String[] args) {
        Config config = new Config(mapFilePath, landingCoordinates, resourcesToScanFor, simTimeOut);

        List<Validator> setupValidators = List.of(
                new MapFilePathValidator(config),
                new SimulationTimeoutValidator(config),
                new ResourceSymbolsValidator(config)
        );

        //validation.run(setupValidators);
        boolean initialValidation = setupValidators.get(0).validate()
                && setupValidators.get(1).validate()
                && setupValidators.get(2).validate();

        if (initialValidation) {
            MapLoader mapLoader = new MapLoaderImpl();
            Map map = mapLoader.load(mapFilePath);

            List<Validator> mapValidators = List.of(
                    new MapValidatorImpl(map),
                    new LandingCoordinatesValidator(map, config),
                    new RoverDeploymentConditionsValidator(map, config)
            );

            boolean mapValidation = mapValidators.get(0).validate()
                    && mapValidators.get(1).validate()
                    && mapValidators.get(2).validate();
            //validation.run(mapValidators);


            if (mapValidation) {

                Rover rover = new RoverImpl("rover-1", config.landingCoordinates(), 1, config.resourceSymbols());
                RoverDeployer roverDeployer = new RoverDeployerImpl(map, rover);
                roverDeployer.deployRover();

                SimulationState simulationState = new SimulationState(
                        config.simulationTimeout(),
                        rover,
                        map,
                        config.landingCoordinates(),
                        config.resourceSymbols()
                );

                ExplorationSimulator explorationSimulator = new ExplorationSimulator(simulationState, rover);
                // Create config, map loader, validators, analyzers etc.

                //run simulation validator, if true, run sim
            } else {
                System.out.println("Map validation failed!");
            }
        } else {
            System.out.println("Initial validation failed!");
        }
    }
}
