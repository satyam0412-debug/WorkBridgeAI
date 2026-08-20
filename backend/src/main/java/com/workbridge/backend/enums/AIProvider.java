package com.workbridge.backend.enums;

public enum AIProvider {
    GEMINI,
    OPENAI,
    AUTO;

    public static AIProvider fromString(String value) {
        try {
            return AIProvider.valueOf(value.trim().toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Unsupported AI provider: " + value);
        }
    }
}