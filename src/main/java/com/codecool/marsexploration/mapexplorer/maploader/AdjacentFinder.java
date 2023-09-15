package com.codecool.marsexploration.mapexplorer.maploader;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class AdjacentFinder {
    public List<Coordinate> getAdjacent(Coordinate coordinate, int radius) {
        int xStart = (coordinate.X() - radius);
        int yStart = (coordinate.Y() - radius);
        int scanEdgeLength = (radius*2)+1;

        List<Coordinate> fieldOfView = new ArrayList<>();
        for (int i = 0; i < scanEdgeLength ; i++) {
            for (int j= 0; j < scanEdgeLength; j++) {
                if(i + xStart != coordinate.X() || j + yStart != coordinate.Y()){
                    fieldOfView.add(new Coordinate(xStart + i, yStart + j));
                }
            }
        }
        return fieldOfView;
    }
}
