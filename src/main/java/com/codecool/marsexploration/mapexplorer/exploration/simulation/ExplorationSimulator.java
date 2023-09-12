package com.codecool.marsexploration.mapexplorer.exploration.simulation;

public class ExplorationSimulator {
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

    
    //start simulation loop (until timeout)
        //move, scan, analyze outcome of step, log & update context, increment loop
            //Journey seems to suggest a SimulationStep interface with move etc. as implementations

    //when sim is finished, log the final outcome and/or store it in a SQL database
}
