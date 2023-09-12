package com.codecool.marsexploration.mapexplorer.repository.log;

import java.util.Map;

public record DatabaseLog(String timeStamp, int numberOfSteps, int minerals, int water, boolean successfulOutcome) {
}
