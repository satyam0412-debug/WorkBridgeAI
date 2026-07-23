package com.workbridge.backend.generator;

import org.springframework.stereotype.Component;

@Component
public class MessageGeneratorFactory {

    private final GeminiMessageGenerator geminiGenerator;
    private final OpenAIMessageGenerator openAIGenerator;

    public MessageGeneratorFactory(GeminiMessageGenerator geminiGenerator, OpenAIMessageGenerator openAIGenerator) {
        this.geminiGenerator = geminiGenerator;
        this.openAIGenerator = openAIGenerator;
    }

    public MessageGenerator getGenerator(String provider) {

        if ("gemini".equalsIgnoreCase(provider)) {
            return geminiGenerator;
        }
        
        if ("openai".equalsIgnoreCase(provider)) {
            return openAIGenerator;
        }
        throw new IllegalArgumentException("Unsupported AI provider: " + provider);
    }
}