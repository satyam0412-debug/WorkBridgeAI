package com.workbridge.backend.dto;

public class GenerateMessageResponse {

    private String formattedMessage;
    private String culturalInsight;

    public GenerateMessageResponse() {
    }

    public GenerateMessageResponse(String formattedMessage, String culturalInsight) {
        this.formattedMessage = formattedMessage;
        this.culturalInsight = culturalInsight;
    }

    public String getFormattedMessage() {
        return formattedMessage;
    }

    public void setFormattedMessage(String formattedMessage) {
        this.formattedMessage = formattedMessage;
    }

    public String getCulturalInsight() {
        return culturalInsight;
    }

    public void setCulturalInsight(String culturalInsight) {
        this.culturalInsight = culturalInsight;
    }
}