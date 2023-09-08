package com.codecool.marsexploration.mapexplorer.repository.log;

import java.util.Map;

public record DatabaseLog(String timeStamp, int numberOfSteps, Map<String, Integer> resources, boolean successfulOutcome) {
}
