package com.workbridge.backend.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {
    private static final Logger logger = LoggerFactory.getLogger(AIService.class);

    private final ChatClient chatClient;

    public AIService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String generateBusinessMessage(String relationshipLevel, String message, String scenario) {
         logger.info("Generating business message ....");

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
        String response = chatClient.prompt(prompt)
                .call()
                .content();
            logger.info("Business message generated successfully.");

            return response;

        } catch (Exception e) {
            logger.error("Failed to generate business message.", e);
            return "Sorry, the AI service is currently unavailable. Please try again later.";
        }
    }
}