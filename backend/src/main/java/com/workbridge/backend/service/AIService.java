package com.workbridge.backend.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private final ChatClient chatClient;

    public AIService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String generateBusinessMessage(String relationshipLevel, String message, String scenario) {

        String prompt = """
                            You are a Japanese business communication expert.

                        Your task is to convert the user's message into natural and polite Japanese.

                        Rules:
                            - Return ONLY the final Japanese message.
                            - Do NOT explain your answer.
                            - Do NOT provide multiple options.
                            - Do NOT include romaji.
                            - Do NOT include English.
                            - Make it sound natural in a Japanese workplace.
                            - Use the relationship to choose the correct politeness level.

                        Scenario: 
                                %s
                        Message:
                                %s
                        """.formatted(scenario, relationshipLevel, message);

       try {
    return chatClient.prompt(prompt)
            .call()
            .content();
        } catch (Exception e) {
            return "Sorry, the AI service is currently unavailable. Please try again later.";
        }
    }
}