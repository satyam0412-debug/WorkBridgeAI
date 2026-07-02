package com.workbridge.backend.service;

import org.springframework.stereotype.Service;

import com.workbridge.backend.dto.GenerateMessageRequest;
import com.workbridge.backend.dto.GenerateMessageResponse;

@Service
public class MessageService {

    public GenerateMessageResponse generateMessage(GenerateMessageRequest request) {

        String formattedMessage =
                "[" + request.getRelationshipLevel() + "] "
                + request.getMessage();

        String culturalInsight =
                "This is a temporary response. AI integration will come next.";

        return new GenerateMessageResponse(formattedMessage, culturalInsight);
    }
}