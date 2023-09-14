package com.codecool.marsexploration.mapexplorer.initialization;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

public class InitialDirectionGenerator {
    public Coordinate generateInitialDirection (Map map, Coordinate landingCoordinate) {
        Coordinate mapCenter = getMapCenter(map);
        int facingX = Integer.signum(mapCenter.X()- landingCoordinate.X());
        int facingY = Integer.signum(mapCenter.Y() - landingCoordinate.Y());
        return new Coordinate(facingX, facingY);
    }

    private Coordinate getMapCenter (Map map) {
        int dim = map.getDimension();
        int halfDim = Math.round((float) dim/2);
        return new Coordinate(halfDim, halfDim);
    }
}
