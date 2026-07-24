package com.workbridge.backend.generator;
import com.workbridge.backend.dto.GeneratedMessage;

public interface MessageGenerator {

    GeneratedMessage generateBusinessMessage(
            String relationshipLevel,
            String message,
            String scenario
    );
}