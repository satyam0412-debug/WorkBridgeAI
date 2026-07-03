package com.workbridge.backend.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private final ChatClient chatClient;

    public AIService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String generateBusinessMessage(String relationshipLevel, String message) {

        String prompt = """
                Convert the following message into polite Japanese.

                Relationship:
                %s

                Message:
                %s
                """.formatted(relationshipLevel, message);

        return chatClient.prompt(prompt)
                .call()
                .content();
    }
}