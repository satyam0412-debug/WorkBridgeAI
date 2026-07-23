package com.workbridge.backend.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class PromptLoader {

    public String loadPrompt(String fileName) {

        try {
            ClassPathResource resource =
                    new ClassPathResource("prompts/" + fileName);

            return new String(
                    resource.getInputStream().readAllBytes(),
                    StandardCharsets.UTF_8
            );

        } catch (IOException e) {

            return loadPrompt("default.txt");
        }
    }
    public String loadBasePrompt() {
        return loadPrompt("base-prompt.txt");
    }
}