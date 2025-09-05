package com.quote.service;

import com.quote.dto.FormRequestDTO;
import com.quote.dto.LLMOverrideDTO;
import com.quote.dto.QuoteResponseDTO;
import com.quote.model.Quote;
import com.quote.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService{

    private final QuoteRepository quoteRepository;
    private final RuleEngine ruleEngine;
    private final LLMEngine llmEngine;

    @Override
    public QuoteResponseDTO processQuote(FormRequestDTO request) {
        LLMOverrideDTO llmOverride = null;
        if(request.getQuoteNote() != null && !request.getQuoteNote().isBlank()) {
            llmOverride = llmEngine.parse(request.getQuoteNote());
        }
        QuoteInputSource inputSource = new FormRequestAdapter(request, llmOverride);
        var quoteInput = inputSource.toQuoteInput();

        Quote quote = ruleEngine.applyRules(quoteInput);
        quoteRepository.save(quote);
        return QuoteResponseDTO.from(quote);
    }

    @Override
    public QuoteResponseDTO getQuoteById(Long id) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Quote not found"));
        return QuoteResponseDTO.from(quote);
    }
}
