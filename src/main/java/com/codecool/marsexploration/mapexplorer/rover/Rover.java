package com.codecool.marsexploration.mapexplorer.rover;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

import java.util.*;

public class Rover {
    private final int visibilityRange;
    private Coordinate currentPos;
    private Coordinate previousPos;
    private Map<String, Set<Coordinate>> resources = new HashMap<>();
    private Coordinate direction;

    public Rover(Coordinate currentPos, int visibilityRange, List<String> resourcesToScanFor, Coordinate previousPos, Coordinate direction) {
        this.currentPos = currentPos;
        this.visibilityRange = visibilityRange;
        this.previousPos = previousPos;
        this.direction = direction;
        // No.
        // No logic, plis.
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

    public Coordinate getDirection() {
        return direction;
    }

    public void setDirection(Coordinate direction) {
        this.direction = direction;
    }

    public Coordinate getPreviousPos() {
        return previousPos;
    }

    public void setPreviousPos(Coordinate previousPos) {
        this.previousPos = previousPos;
    }
}
