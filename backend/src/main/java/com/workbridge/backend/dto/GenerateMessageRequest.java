package com.workbridge.backend.dto;

public class GenerateMessageRequest {

    private String relationshipLevel;
    private String message;

    public GenerateMessageRequest() {
    }

    public GenerateMessageRequest(String relationshipLevel, String message) {
        this.relationshipLevel = relationshipLevel;
        this.message = message;
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
}