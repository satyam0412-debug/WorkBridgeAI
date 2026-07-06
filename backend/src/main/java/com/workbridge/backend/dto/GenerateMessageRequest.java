package com.workbridge.backend.dto;

public class GenerateMessageRequest {

    private String relationshipLevel;
    private String message;
    private String scenario;

    public GenerateMessageRequest() {
    }

    public GenerateMessageRequest(String relationshipLevel, String message, String scenario) {
        this.relationshipLevel = relationshipLevel;
        this.message = message;
        this.scenario = scenario;
    }

    public String getRelationshipLevel() {
        return relationshipLevel;
    }

    public void setRelationshipLevel(String relationshipLevel) {
        this.relationshipLevel = relationshipLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }
}