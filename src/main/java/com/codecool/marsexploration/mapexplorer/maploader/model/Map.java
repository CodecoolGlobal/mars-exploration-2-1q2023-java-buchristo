package com.codecool.marsexploration.mapexplorer.maploader.model;

import java.util.List;
import java.util.stream.Collectors;

public class Map {
    private String[][] representation;

    public Map(String[][] representation) {
        this.representation = representation;
    }

    public int getDimension() {
        return representation.length;
    }

    public String[][] getRepresentation() {
        return representation;
    }

    private static String createStringRepresentation(String[][] arr) {
        StringBuilder sb = new StringBuilder();

        for (String[] strings : arr) {
            StringBuilder s = new StringBuilder();
            for (String string : strings) {
                s.append(string == null ? " " : string);
            }

            sb.append(s).append("\n");
        }

        return sb.toString();
    }

    public String getByCoordinate(Coordinate coordinate) {
        return representation[coordinate.X()][coordinate.Y()];
    }

    public boolean isEmpty(Coordinate coordinate) {
        return representation[coordinate.X()][coordinate.Y()] == null
                || representation[coordinate.X()][coordinate.Y()].isEmpty()
                || representation[coordinate.X()][coordinate.Y()].equals(" ");
    }

    public List<Coordinate> getEmptyCoordinates(List<Coordinate> coordinates) {
        return coordinates.stream().filter(this::isEmpty).toList();
    }

    public List<Coordinate> removeOutOfMapCoordinates(List<Coordinate> coordinates) {
        return coordinates.stream()
                .filter(this::coordinateIsOnMap)
                .collect(Collectors.toList());
    }

    public boolean coordinateIsOnMap (Coordinate coordinate) {
        int x = coordinate.X();
        int y = coordinate.Y();
        int mapLength = representation.length;
        return x >= 0 && x < mapLength && y >= 0 && y < mapLength;
    }

    @Override
    public String toString() {
        return createStringRepresentation(representation);
    }
}
