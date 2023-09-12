package com.codecool.marsexploration.mapexplorer.rover;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

import java.util.*;

public class Rover {
    private final String id;
    private final int visibilityRange;
    private Coordinate currentPos;
    private Map<String, Set<Coordinate>> resources = new HashMap<>();

    public Rover(String id, Coordinate currentPos, int visibilityRange, List<String> resourcesToScanFor) {
        this.id = id;
        this.currentPos = currentPos;
        this.visibilityRange = visibilityRange;
        resourcesToScanFor.forEach(resourceName -> resources.put(resourceName, new HashSet<>()));
    }

    public String getId(){
        return id;
    }

}
