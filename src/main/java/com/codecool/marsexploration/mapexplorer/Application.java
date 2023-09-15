package com.codecool.marsexploration.mapexplorer;

import com.codecool.marsexploration.mapexplorer.builder.SimulatorBuilder;
import com.codecool.marsexploration.mapexplorer.configuration.Config;
import com.codecool.marsexploration.mapexplorer.exploration.simulation.ExplorationSimulator;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

import java.util.List;

import static com.codecool.marsexploration.mapexplorer.Constants.MINERAL;
import static com.codecool.marsexploration.mapexplorer.Constants.WATER;

public class Application {
    public static void main(String[] args) {
        Config config = new Config(
                "src/main/resources/maps/exploration-0.map",
                new Coordinate(6, 6),
                List.of(MINERAL, WATER),
                1000,
                4,
                4);
        SimulatorBuilder builder = new SimulatorBuilder();
        ExplorationSimulator simulator = builder.build(config);
        simulator.run();
    }
}
