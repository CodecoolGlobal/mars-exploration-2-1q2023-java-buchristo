package com.codecool.marsexploration.mapexplorer.rover;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

import java.util.Map;
import java.util.Set;

public interface Rover{
    public String getId();

    public int getVisibilityRange();

    public void setCurrentPos(Coordinate coordinate);

    public Coordinate getCurrentPos();

    public void setResources(String name, Coordinate coordinates);

    public Map<String, Set<Coordinate>> getResources();
}
