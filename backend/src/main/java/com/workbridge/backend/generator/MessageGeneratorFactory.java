package com.workbridge.backend.generator;

import org.springframework.stereotype.Component;

@Component
public class MessageGeneratorFactory {

    private final GeminiMessageGenerator geminiGenerator;

    public MessageGeneratorFactory(GeminiMessageGenerator geminiGenerator) {
        this.geminiGenerator = geminiGenerator;
    }

    public MessageGenerator getGenerator(String provider) {

        if ("gemini".equalsIgnoreCase(provider)) {
            return geminiGenerator;
        }

        throw new IllegalArgumentException("Unsupported AI provider: " + provider);
    }
}