package com.codecool.marsexploration.mapexplorer.rover;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

import java.util.*;

public class Rover {
    private final int visibilityRange;
    private Coordinate currentPos;
    private Map<String, Set<Coordinate>> resources = new HashMap<>();

    public Rover(Coordinate currentPos, int visibilityRange, List<String> resourcesToScanFor, Coordinate direction) {
        this.currentPos = currentPos;
        this.visibilityRange = visibilityRange;
        resourcesToScanFor.forEach(resourceName -> resources.put(resourceName, new HashSet<>()));
    }

    public int getVisibilityRange() {
        return visibilityRange;
    }

    public void setCurrentPos(Coordinate coordinate) {
        this.currentPos = coordinate;
    }

    public Coordinate getCurrentPos() {
        return currentPos;
    }

    public void setResources(String name, Coordinate coordinates){
        resources.get(name).add(coordinates);
    }

    public Map<String, Set<Coordinate>> getResources() {
        return resources;
    }

}
