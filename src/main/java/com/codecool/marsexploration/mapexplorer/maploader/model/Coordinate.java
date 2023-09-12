package com.codecool.marsexploration.mapexplorer.maploader.model;

import java.util.ArrayList;
import java.util.List;

public record Coordinate(int X, int Y) {

    public List<Coordinate> getAdjacent(int scanRadius) {
        int xStart = (this.X - scanRadius);
        int yStart = (this.Y - scanRadius);
        int scanEdgeLength = (scanRadius*2)+1;

        List<Coordinate> fieldOfView = new ArrayList<>();
        for (int i = 0; i <scanEdgeLength ; i++) {
            for (int j= 0; j < scanEdgeLength; j++) {
                if(i != xStart && j != yStart){
                    fieldOfView.add(new Coordinate(i,j));
                }
            }
        }

        return fieldOfView;
    }
}
