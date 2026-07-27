package com.workbridge.backend.generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.workbridge.backend.dto.GeneratedMessage;
import com.workbridge.backend.service.PromptLoader;
import com.workbridge.backend.service.ScenarioFileMapper;

@Service
public class GeminiMessageGenerator implements MessageGenerator {
    private static final Logger logger = LoggerFactory.getLogger(GeminiMessageGenerator.class);

    private final ChatClient chatClient;
    private final PromptLoader promptLoader;

    public GeminiMessageGenerator(ChatClient.Builder builder, PromptLoader promptLoader) {
        this.chatClient = builder.build();
        this.promptLoader = promptLoader;
    }


    @Override
    public GeneratedMessage generateBusinessMessage(String relationshipLevel, String message, String scenario) {
         logger.info("Generating business message ....");
         String fileName = ScenarioFileMapper.getFileName(scenario);
        String scenarioInstruction = promptLoader.loadPrompt(fileName);


        String prompt = promptLoader.loadBasePrompt()
        .replace("{{scenarioInstruction}}", scenarioInstruction)
        .replace("{{relationship}}", relationshipLevel)
        .replace("{{message}}", message);

       try {
        String response = chatClient.prompt(prompt)
                .call()
                .content();
            logger.info("Business message generated successfully.");

            return new GeneratedMessage(response, "Google Gemini");

        } catch (Exception e) {
            logger.error("Failed to generate business message.", e);
            return new GeneratedMessage("Sorry, the AI service is currently unavailable. Please try again later.", "Google Gemini");
        }
    }
}