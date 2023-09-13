package com.codecool.marsexploration.mapexplorer.repository.model;

public record DatabaseLog(String timeStamp, int numberOfSteps, int minerals, int water, int success) {
}
