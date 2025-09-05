package com.quote.service;


import com.quote.model.Quote;
import com.quote.model.input.QuoteInput;

public interface RuleEngine {
    Quote applyRules(QuoteInput input);
}

