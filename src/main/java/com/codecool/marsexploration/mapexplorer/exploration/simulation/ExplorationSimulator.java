package com.codecool.marsexploration.mapexplorer.exploration.simulation;

import com.codecool.marsexploration.mapexplorer.exploration.analyzer.ResourceAnalyzer;
import com.codecool.marsexploration.mapexplorer.exploration.movement.MovementEngine;
import com.codecool.marsexploration.mapexplorer.exploration.movement.MovementEngineRandom;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;

public class ExplorationSimulator {
    private final SimulationState simulationState;
    private Rover rover;
    private Map map;
    public ExplorationSimulator(SimulationState simulationState) {
        this.simulationState = simulationState;
        this.rover = simulationState.getRover();
        this.map = simulationState.getMap();
    }

    public void run(){
        MovementEngine movementEngine = new MovementEngineRandom();
        ResourceAnalyzer resourceAnalyzer = new ResourceAnalyzer();
        while(simulationState.isRunning()) {

            movementEngine.moveRover(simulationState);
            resourceAnalyzer.analyze(simulationState);
            int nextStepNumber = simulationState.getNumberOfStepsTaken() + 1;
            simulationState.setNumberOfStepsTaken(nextStepNumber);
            if (nextStepNumber >= simulationState.getSimulationTimeout()) {
                simulationState.setIsRunningToFalse();
            }
            if (rover.getResources().get("%").size() >= simulationState.getMineralsInt()) {
                simulationState.setIsRunningToFalse();
                simulationState.setSuccessToTrue();
            }

        }
        if (simulationState.isSuccess()) {System.out.println("Success!");}
        else {
            System.out.println("The only thing I found was a photo of your wife.");
        }

            //start simulation loop (until timeout)
            //move, scan, analyze outcome of step, log & update context, increment loop
            //Journey seems to suggest a SimulationStep interface with move etc. as implementations
    }
    //receive a map loader
    //receive a config record
    //receive a list of SOME validator implementations
    //receive a list of outcome analyzers

    //validate mapFile
        //validate symbols and timeout
        //create/load map
            //create landingCoordinates validator and rover deployment validator
                //check if landingCoordinates and rover deployment are good

    //QUESTION: dependency injection? we need the map to create validators, but we're supposed to create the map in here?
    //QUESTION: should we have an outsourced simulation validator class that does all the validation before we get to the actual loop?
        //and then an outsourced outcome validator class?
        //SRP: the simulation only cares about the loop, the validators only about validating things


    //generate the "simulation context"

    //when sim is finished, log the final outcome and/or store it in a SQL database
}
