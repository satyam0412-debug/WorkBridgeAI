package com.workbridge.backend.router;

import org.springframework.stereotype.Component;
import com.workbridge.backend.exception.ProviderUnavailableException;
import com.workbridge.backend.dto.GeneratedMessage;
import com.workbridge.backend.enums.AIProvider;
import com.workbridge.backend.generator.MessageGenerator;
import com.workbridge.backend.generator.MessageGeneratorFactory;

@Component
public class AIRouter {

    private final MessageGeneratorFactory factory;

    public AIRouter(MessageGeneratorFactory factory) {
        this.factory = factory;
    }

    public GeneratedMessage generate(
            AIProvider provider,
            String relationshipLevel,
            String message,
            String scenario) {

        if (provider != AIProvider.AUTO) {
            MessageGenerator generator = factory.getGenerator(provider);
            return generator.generateBusinessMessage(relationshipLevel, message, scenario);
        }

        try {
            MessageGenerator generator = factory.getGenerator(AIProvider.GEMINI);
            return generator.generateBusinessMessage(relationshipLevel, message, scenario);
        } catch (ProviderUnavailableException e) {
            MessageGenerator generator = factory.getGenerator(AIProvider.OPENAI);
            return generator.generateBusinessMessage(relationshipLevel, message, scenario);
        }
    }
}