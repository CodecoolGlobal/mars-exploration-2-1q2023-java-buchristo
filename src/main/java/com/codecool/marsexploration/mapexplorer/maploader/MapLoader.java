package com.codecool.marsexploration.mapexplorer.maploader;

import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapLoaderImpl implements MapLoader {

    @Override
    public Map load(String mapFile) {
        try(Stream<String> lines = Files.lines(Path.of(mapFile))){

            List<String> collectedLines = lines.collect(Collectors.toList());
            String[][] map = new String[collectedLines.size()][collectedLines.get(0).length()];

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = String.valueOf(collectedLines.get(i).charAt(j));
                }
            }

            return new Map(map);

        } catch (FileNotFoundException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return null;
    }
}
