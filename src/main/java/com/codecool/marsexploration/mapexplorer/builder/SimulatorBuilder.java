package com.codecool.marsexploration.mapexplorer.builder;

import com.codecool.marsexploration.mapexplorer.configuration.Config;
import com.codecool.marsexploration.mapexplorer.exploration.analyzer.Analyzer;
import com.codecool.marsexploration.mapexplorer.exploration.analyzer.SuccessAnalyzer;
import com.codecool.marsexploration.mapexplorer.exploration.analyzer.TimeoutAnalyzer;
import com.codecool.marsexploration.mapexplorer.exploration.movement.MovementEngine;
import com.codecool.marsexploration.mapexplorer.exploration.movement.MovementEngineRandom;
import com.codecool.marsexploration.mapexplorer.exploration.simulation.ExplorationSimulator;
import com.codecool.marsexploration.mapexplorer.exploration.simulation.SimulationState;
import com.codecool.marsexploration.mapexplorer.exploration.simulation.steps.*;
import com.codecool.marsexploration.mapexplorer.initialization.InitialDirectionGenerator;
import com.codecool.marsexploration.mapexplorer.logger.*;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoader;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.repository.Repository;
import com.codecool.marsexploration.mapexplorer.repository.manager.DBConnectionManager;
import com.codecool.marsexploration.mapexplorer.rover.Rover;
import com.codecool.marsexploration.mapexplorer.rover.deployer.RoverDeployer;
import com.codecool.marsexploration.mapexplorer.validator.*;

import java.util.List;

public class SimulatorBuilder {
    private Config config;
    private Logger logger;
    private Map map;
    private Rover rover;
    private SimulationState state;
    private MapLogger mapLogger;
    private List<SimulationStep> steps;
    private FinalOutcomeLogger outcomeLogger;
    private ExplorationSimulator simulator;

    public ExplorationSimulator build(Config config) {
        this.config = config;
        initLogger();
        validateSetup();
        initMap();
        validateMap();
        initRover();
        initState();
        initSteps();
        initOutcomeLogger();
        initSimulator();
        return simulator;
    }

    private void initLogger() {
        logger = new ConsoleLogger();
    }

    private void validateSetup() {
        // S O L I D - check!
        List<Validator> validators = List.of(
                new MapFilePathValidator(config),
                new SimulationTimeoutValidator(config),
                new ResourceSymbolsValidator(config)
        );
        SetupValidator validator = new SetupValidator(validators, logger);
        validator.validate();
    }

    private void initMap() {
        MapLoader mapLoader = new MapLoader();
        map = mapLoader.load(config.mapFilePath());
    }

    private void validateMap() {
        // S O L I D - check!
        List<Validator> mapValidators = List.of(
                new MapSizeValidator(map),
                new LandingCoordinatesValidator(map, config),
                new RoverDeploymentConditionsValidator(map, config)
        );

        ExplorationValidator explorationValidator = new ExplorationValidator(mapValidators, logger);
        explorationValidator.validate();
    }

    private void initRover() {
        InitialDirectionGenerator initialDirectionGenerator = new InitialDirectionGenerator();
        Coordinate initialDirection = initialDirectionGenerator.generateInitialDirection(map, config.landingCoordinates());
        rover = new Rover(
                config.landingCoordinates(),
                1,
                config.resourceSymbols(),
                config.landingCoordinates(),
                initialDirection);
        RoverDeployer roverDeployer = new RoverDeployer(map, rover);
        roverDeployer.deployRover();
    }

    private void initState() {
        state = new SimulationState(
                config.simulationTimeout(),
                rover,
                map,
                config.landingCoordinates(),
                config.resourceSymbols(),
                config.mineralsGoal()
        );
    }

    private void initSteps() {
        MovementEngine engine = new MovementEngineRandom();
        SimulationStep move = new MoveStep(engine, state);
        SimulationStep scan = new ScanStep(state);
        Analyzer timeoutAnalyzer = new TimeoutAnalyzer();
        Analyzer successAnalyzer = new SuccessAnalyzer();
        SimulationStep analyze = new AnalyzeStep(timeoutAnalyzer, successAnalyzer, state);
        mapLogger = new MapLogger();
        SimulationStep log = new LogStep(logger, state, mapLogger);
        steps = List.of(move, scan, analyze, log);
    }

    private void initOutcomeLogger() {
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        Repository repository = new Repository(dbConnectionManager);
        DatabaseLogger DBLogger = new DatabaseLogger(repository);
        outcomeLogger = new FinalOutcomeLogger(logger, mapLogger, DBLogger, state);
    }

    private void initSimulator() {
        simulator = new ExplorationSimulator(state, steps, outcomeLogger);
    }
}
