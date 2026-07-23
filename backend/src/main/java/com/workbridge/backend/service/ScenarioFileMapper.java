package com.workbridge.backend.service;

public final class ScenarioFileMapper {
    private ScenarioFileMapper() {
        // Prevent instantiation
    }

    public static String getFileName(String scenario) {
        if (scenario == null || scenario.isBlank()) {
            return null;
        }
        return scenario
            .trim()
            .toLowerCase()
            .replace(" ", "-")
            + ".txt";
    }
}