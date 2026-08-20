package com.workbridge.backend.router;

import org.springframework.stereotype.Component;

import com.workbridge.backend.dto.GeneratedMessage;
import com.workbridge.backend.generator.MessageGenerator;
import com.workbridge.backend.generator.MessageGeneratorFactory;

@Component
public class AIRouter {

    private final MessageGeneratorFactory factory;

    public AIRouter(MessageGeneratorFactory factory) {
        this.factory = factory;
    }

public GeneratedMessage generate(
        String provider,
        String relationshipLevel,
        String message,
        String scenario) {
            if (!"auto".equalsIgnoreCase(provider)) {
    MessageGenerator generator = factory.getGenerator(provider);
    return generator.generateBusinessMessage(
            relationshipLevel,
            message,
            scenario
    );
}


try {
    MessageGenerator generator = factory.getGenerator("gemini");
    return generator.generateBusinessMessage(
            relationshipLevel,
            message,
            scenario
    );
}
catch (Exception e) {
    MessageGenerator generator = factory.getGenerator("openai");
    return generator.generateBusinessMessage(
            relationshipLevel,
            message,
            scenario
    );
}
}
}