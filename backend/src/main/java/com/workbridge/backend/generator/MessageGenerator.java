package com.workbridge.backend.generator;

public interface MessageGenerator {

    String generateBusinessMessage(
            String relationshipLevel,
            String message,
            String scenario
    );
}