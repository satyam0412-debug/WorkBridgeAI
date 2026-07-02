package com.workbridge.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workbridge.backend.dto.GenerateMessageRequest;
import com.workbridge.backend.dto.GenerateMessageResponse;
import com.workbridge.backend.service.MessageService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/generate")
    public GenerateMessageResponse generateMessage(
            @RequestBody GenerateMessageRequest request) {

        return messageService.generateMessage(request);
    }
}