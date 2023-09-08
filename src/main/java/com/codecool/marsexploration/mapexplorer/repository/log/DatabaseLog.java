package com.codecool.marsexploration.mapexplorer.repository.log;

import java.util.Map;

public record DatabaseLog(int numberOfSteps, Map<String, Integer> resources, boolean successfulOutcome) {
}
