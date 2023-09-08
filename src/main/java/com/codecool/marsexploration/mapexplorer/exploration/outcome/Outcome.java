package com.codecool.marsexploration.mapexplorer.exploration.outcome;

import java.util.Map;

public record Outcome(int numberOfSteps, Map<String, Integer> resources, boolean successfulOutcome) {
}
