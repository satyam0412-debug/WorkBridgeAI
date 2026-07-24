package com.workbridge.backend.generator;
import org.springframework.stereotype.Service;

import com.workbridge.backend.dto.GeneratedMessage;

@Service
public class OpenAIMessageGenerator implements MessageGenerator {

    @Override
    public GeneratedMessage generateBusinessMessage(
            String relationshipLevel,
            String message,
            String scenario) {

        String response = """
                [Mock OpenAI Response]

                Scenario: %s
                Relationship: %s

                %s
                """.formatted(
                scenario,
                relationshipLevel,
                message
        );
        return new GeneratedMessage(response, "OpenAI");
    }
}