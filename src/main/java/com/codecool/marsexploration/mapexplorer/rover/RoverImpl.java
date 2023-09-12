package com.codecool.marsexploration.mapexplorer.rover;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

import java.util.*;

public class RoverImpl implements Rover{
    private final String id;
    private final int visibilityRange;
    private Coordinate currentPos;
    private Map<String, Set<Coordinate>> resources = new HashMap<>();

    public RoverImpl(String id, Coordinate currentPos, int visibilityRange, List<String> resourcesToScanFor) {
        this.id = id;
        this.currentPos = currentPos;
        this.visibilityRange = visibilityRange;
        resourcesToScanFor.forEach(resourceName -> resources.put(resourceName, new HashSet<>()));
    }

    @Override
    public String getId(){
        return id;
    }

    @Override
    public int getVisibilityRange() {
        return visibilityRange;
    }

    @Override
    public void setCurrentPos(Coordinate coordinate) {
        this.currentPos = coordinate;
    }

    @Override
    public Coordinate getCurrentPos() {
        return currentPos;
    }

    @Override
    public void setResources(String name, Coordinate coordinates){
        resources.get(name).add(coordinates);
    }

    @Override
    public Map<String, Set<Coordinate>> getResources() {
        return resources;
    }

}
