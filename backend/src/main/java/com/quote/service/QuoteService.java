package com.quote.service;

import com.quote.dto.FormRequestDTO;
import com.quote.dto.QuoteResponseDTO;
import com.quote.model.input.QuoteInput;

public interface QuoteService {
    public QuoteResponseDTO processQuote(QuoteInput input);
    public QuoteResponseDTO getQuoteById(Long id);
}
