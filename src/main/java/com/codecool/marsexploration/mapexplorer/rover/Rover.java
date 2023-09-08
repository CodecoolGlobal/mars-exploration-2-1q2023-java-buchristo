package com.codecool.marsexploration.mapexplorer.rover;

public interface Rover {
    //fields needed in impl: id, currentPos, visibilityRange, one or more collections for spotted resources
    //what methods would be good? move/deploy, scanForResources, recordCoordinates, returnToBase?
    //Journey seems to suggest that Move/Scan/etc. could be implementations of a SimulationStep interface (rather than rover methods)
        //let's talk about it and decide how we want to do it
}
