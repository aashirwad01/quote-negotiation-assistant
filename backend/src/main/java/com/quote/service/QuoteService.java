package com.quote.service;

import com.quote.dto.FormRequestDTO;
import com.quote.dto.QuoteResponseDTO;

public interface QuoteService {
    public QuoteResponseDTO processQuote(FormRequestDTO request);
    public QuoteResponseDTO getQuoteById(Long id);
}
