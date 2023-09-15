package com.codecool.marsexploration.mapexplorer.maploader;

import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class MapLoader {

    public Map load(String mapFile) {
        try (Stream<String> lines = Files.lines(Path.of(mapFile))) {
            String[][] map = lines.map(line -> line.split("")).toArray(String[][]::new);
            return new Map(map);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        throw new IllegalStateException("Map couldn't be created");
    }
}
