package com.workbridge.backend.dto;

public class GeneratedMessage {

    private final String formattedMessage;
    private final String provider;

    public GeneratedMessage(String formattedMessage, String provider) {
        this.formattedMessage = formattedMessage;
        this.provider = provider;
    }

    public String getFormattedMessage() {
        return formattedMessage;
    }

    public String getProvider() {
        return provider;
    }
}