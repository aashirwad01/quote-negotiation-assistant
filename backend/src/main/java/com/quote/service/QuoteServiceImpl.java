package com.quote.service;

import com.quote.dto.QuoteResponseDTO;
import com.quote.exception.ResourceNotFoundException;
import com.quote.model.Quote;
import com.quote.model.input.QuoteInput;
import com.quote.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final RuleEngine ruleEngine;

    @Override
    public QuoteResponseDTO processQuote(QuoteInput input) {
        Quote quote = ruleEngine.applyRules(input);
        quoteRepository.save(quote);
        return QuoteResponseDTO.from(quote);
    }

    @Override
    public QuoteResponseDTO getQuoteById(Long id) {
        Quote quote = quoteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quote with ID " + id + " not found"));
        return QuoteResponseDTO.from(quote);
    }
}
