package com.codecool.marsexploration.mapexplorer.exploration.simulation;

public class ExplorationSimulator {
    //receive a map loader
    //receive a config record
    //receive a list of validator implementations
    //receive a list of outcome analyzers

    //load the map file
    //validate config
    //generate the "simulation context"

    //start simulation loop (until timeout)
        //move, scan, analyze outcome of step, log & update context, increment loop
            //Journey seems to suggest a SimulationStep interface with move etc. as implementations

    //when sim is finished, log the final outcome and/or store it in a SQL database
}
