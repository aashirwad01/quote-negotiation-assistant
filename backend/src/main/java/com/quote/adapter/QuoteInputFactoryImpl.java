package com.quote.adapter;

import com.quote.dto.FormRequestDTO;
import com.quote.dto.LLMOverrideDTO;
import com.quote.model.input.QuoteInput;
import com.quote.service.LLMEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuoteInputFactoryImpl implements QuoteInputFactory{
    private  final LLMEngine llmEngine;

    @Override
    public QuoteInput fromForm(FormRequestDTO request) {
        LLMOverrideDTO llmOverride = null;
        if(request.getQuoteNote() != null && !request.getQuoteNote().isBlank()) {
            llmOverride = llmEngine.parse(request.getQuoteNote());
        }
        return new FormRequestAdapter(request, llmOverride).toQuoteInput();
    }
}
