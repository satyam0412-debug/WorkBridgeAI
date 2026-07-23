package com.workbridge.backend.generator;

import org.springframework.stereotype.Service;

@Service
public class OpenAIMessageGenerator implements MessageGenerator {

    @Override
    public String generateBusinessMessage(
            String relationshipLevel,
            String message,
            String scenario) {

        return """
                [Mock OpenAI Response]

                Scenario: %s
                Relationship: %s

                %s
                """.formatted(
                scenario,
                relationshipLevel,
                message
        );
    }
}