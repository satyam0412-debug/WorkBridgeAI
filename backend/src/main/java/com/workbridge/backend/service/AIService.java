package com.workbridge.backend.service;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {
    private static final Logger logger = LoggerFactory.getLogger(AIService.class);
    private static final Map<String, String> SCENARIO_PROMPTS = Map.of(
        "Late for work",
        """
        The user is informing someone they will be late.
        Be apologetic.
        Keep the message concise.
        Use humble and polite Japanese.
        """,

        "Leave request",
        """
        The user is requesting leave.
        Be respectful and professional.
        Express appreciation.
        """,

        "Meeting request",
        """
        The user wants to schedule a meeting.
        Be polite and business-like.
        Keep the tone friendly.
        """,

        "Apology",
        """
        The user is apologizing.
        Be sincere and humble.
        Use natural business Japanese.
        """
);

    private final ChatClient chatClient;

    public AIService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    private String getScenarioInstruction(String scenario) {

    return SCENARIO_PROMPTS.getOrDefault(
            scenario,
            """
            Use natural and polite Japanese suitable for the workplace.
            """
    );
}

    public String generateBusinessMessage(String relationshipLevel, String message, String scenario) {
         logger.info("Generating business message ....");
         String scenarioInstruction = getScenarioInstruction(scenario);
        String prompt = """
You are a Japanese business communication expert.

Convert the user's message into natural Japanese.

Rules:
- Return ONLY the final Japanese message.
- No explanation.
- No English.
- No romaji.
- Sound natural in a Japanese workplace.

Instructions:
%s

Relationship:
%s

Message:
%s
""".formatted(
        scenarioInstruction,
        relationshipLevel,
        message
);
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