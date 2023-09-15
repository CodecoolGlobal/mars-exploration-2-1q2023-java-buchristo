package com.codecool.marsexploration.mapexplorer.logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        //TODO maybe instert timestamp
        System.out.println("Log: " + message);
    }
}
