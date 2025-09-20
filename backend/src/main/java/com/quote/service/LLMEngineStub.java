package com.quote.service;

import com.quote.dto.LLMOverrideDTO;
import org.springframework.stereotype.Component;

@Component
public class LLMEngineStub implements LLMEngine {
    
    @Override
    public LLMOverrideDTO parse(String quoteNoteText) {
        // Dummy stub implementation - always returns null
        // This satisfies Spring Boot's dependency injection requirements
        // Real LLM implementation will be added in the future
        return null;
    }
}
