package com.workbridge.backend.generator;

import org.springframework.stereotype.Component;

import com.workbridge.backend.enums.AIProvider;

@Component
public class MessageGeneratorFactory {

    private final GeminiMessageGenerator geminiGenerator;
    private final OpenAIMessageGenerator openAIGenerator;

    public MessageGeneratorFactory(GeminiMessageGenerator geminiGenerator, OpenAIMessageGenerator openAIGenerator) {
        this.geminiGenerator = geminiGenerator;
        this.openAIGenerator = openAIGenerator;
    }

    public MessageGenerator getGenerator(AIProvider provider) {
        return switch (provider) {
            case GEMINI -> geminiGenerator;
            case OPENAI -> openAIGenerator;
            case AUTO -> throw new IllegalArgumentException(
                "AUTO is not a resolvable provider — handle it in AIRouter, not the Factory."
            );
        };
    }
}