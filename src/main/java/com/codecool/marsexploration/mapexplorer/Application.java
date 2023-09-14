package com.codecool.marsexploration.mapexplorer;

import com.codecool.marsexploration.mapexplorer.configuration.Config;
import com.codecool.marsexploration.mapexplorer.exploration.analyzer.Analyzer;
import com.codecool.marsexploration.mapexplorer.exploration.analyzer.SuccessAnalyzer;
import com.codecool.marsexploration.mapexplorer.exploration.analyzer.TimeoutAnalyzer;
import com.codecool.marsexploration.mapexplorer.exploration.movement.MovementEngine;
import com.codecool.marsexploration.mapexplorer.exploration.movement.MovementEngineRandom;
import com.codecool.marsexploration.mapexplorer.exploration.simulation.ExplorationSimulator;
import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;
import com.codecool.marsexploration.mapexplorer.exploration.simulation.steps.*;
import com.codecool.marsexploration.mapexplorer.logger.*;
import com.codecool.marsexploration.mapexplorer.repository.Repository;
import com.codecool.marsexploration.mapexplorer.repository.manager.DBConnectionManager;
import com.codecool.marsexploration.mapexplorer.validator.*;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoader;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;
import com.codecool.marsexploration.mapexplorer.rover.deployer.RoverDeployer;

import java.util.List;

import static com.codecool.marsexploration.mapexplorer.Constants.*;

public class Application {
    static String mapFilePath = "src/main/resources/maps/exploration-0.map";
    static Coordinate landingCoordinates = new Coordinate(6, 6);
    static List<String> resourcesToScanFor = List.of(MINERAL, WATER);
    static int simTimeOut = 1000;
    static int mineralsGoal = 4;
    static int waterGoal = 4;

    public static void main(String[] args) {
        Config config = new Config(
                mapFilePath,
                landingCoordinates,
                resourcesToScanFor,
                simTimeOut,
                mineralsGoal,
                waterGoal);

        List<Validator> setupValidators = List.of(
                new MapFilePathValidator(config),
                new SimulationTimeoutValidator(config),
                new ResourceSymbolsValidator(config)
        );

        Logger logger = new ConsoleLogger();
        SetupValidator setupValidator = new SetupValidator(setupValidators, logger);
        setupValidator.validate();

        MapLoader mapLoader = new MapLoader();
        Map map = mapLoader.load(mapFilePath);

        List<Validator> mapValidators = List.of(
                new MapSizeValidator(map),
                new LandingCoordinatesValidator(map, config),
                new RoverDeploymentConditionsValidator(map, config)
        );

        ExplorationValidator explorationValidator = new ExplorationValidator(mapValidators, logger);
        explorationValidator.validate();

        Rover rover = new Rover(config.landingCoordinates(), 1, config.resourceSymbols());
        RoverDeployer roverDeployer = new RoverDeployer(map, rover);
        roverDeployer.deployRover();

        SimulationState simulationState = new SimulationState(
                config.simulationTimeout(),
                rover,
                map,
                config.landingCoordinates(),
                config.resourceSymbols(),
                config.mineralsGoal()
        );

        MovementEngine engine = new MovementEngineRandom();
        SimulationStep moveStep = new MoveStep(engine, simulationState);
        SimulationStep scanStep = new ScanStep(simulationState);
        Analyzer timeoutAnalyzer = new TimeoutAnalyzer();
        Analyzer successAnalyzer = new SuccessAnalyzer();
        SimulationStep analyzeStep = new AnalyzeStep(timeoutAnalyzer, successAnalyzer, simulationState);
        SimulationStep logStep = new LogStep(logger, simulationState);
        MapLogger mapLogger = new MapLogger();
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        Repository repository = new Repository(dbConnectionManager);
        DatabaseLogger DBLogger = new DatabaseLogger(repository);
        FinalOutcomeLogger finalOutcomeLogger = new FinalOutcomeLogger(
                logger, mapLogger, DBLogger, simulationState);

        ExplorationSimulator explorationSimulator = new ExplorationSimulator(
                simulationState,
                moveStep,
                scanStep,
                analyzeStep,
                logStep,
                finalOutcomeLogger);

        explorationSimulator.run();
    }
}
