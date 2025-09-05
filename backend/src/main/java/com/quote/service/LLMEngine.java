package com.quote.service;


import com.quote.dto.LLMOverrideDTO;

public interface LLMEngine {
    LLMOverrideDTO parse(String quoteNoteText);
}

