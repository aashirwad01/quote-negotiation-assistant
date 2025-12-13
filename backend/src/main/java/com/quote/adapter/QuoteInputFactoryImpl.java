package com.quote.adapter;

import com.quote.dto.FormRequestDTO;
import com.quote.dto.LLMOverrideDTO;
import com.quote.exception.InvalidInputException;
import com.quote.model.input.QuoteInput;
import com.quote.service.LLMEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.quote.exception.InvalidInputException;

@Component
@RequiredArgsConstructor
public class QuoteInputFactoryImpl implements QuoteInputFactory{
    private  final LLMEngine llmEngine;

    @Override
    public QuoteInput fromForm(FormRequestDTO request) {
        if ((request.getQuoteNote() == null || request.getQuoteNote().isBlank()) &&
                (request.getQuantity() == null || request.getUrgency() == null)) {
            throw new InvalidInputException("Either quoteNote or both quantity and urgency must be provided.");
        }

        LLMOverrideDTO override = null;
        if (request.getQuoteNote() != null && !request.getQuoteNote().isBlank()) {
            override = llmEngine.parse(request.getQuoteNote());
        }

        return new FormRequestAdapter(request, override).toQuoteInput();
    }

}
