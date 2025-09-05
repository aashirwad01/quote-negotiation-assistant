package com.quote.service;

import com.quote.model.input.QuoteInput;

public interface QuoteInputSource {
    QuoteInput toQuoteInput();
}
