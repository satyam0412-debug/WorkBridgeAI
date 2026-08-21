package com.workbridge.backend.exception;

public class ProviderUnavailableException extends RuntimeException {
    private final String provider;

    public ProviderUnavailableException(String provider, String message, Throwable cause) {
        super(message, cause);
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }
}