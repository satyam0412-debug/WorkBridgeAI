package com.workbridge.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workbridge.backend.dto.ApiResponse;
import com.workbridge.backend.dto.GenerateMessageRequest;
import com.workbridge.backend.dto.GenerateMessageResponse;
import com.workbridge.backend.service.MessageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/generate")
    public ApiResponse<GenerateMessageResponse> generateMessage(
           @Valid @RequestBody GenerateMessageRequest request) {

        GenerateMessageResponse response =
        messageService.generateMessage(request);

return new ApiResponse<>(
        true,
        "Message generated successfully.",
        response
        );

    }
}