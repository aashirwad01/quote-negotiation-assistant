package com.quote.model.input;

import com.quote.model.UrgencyLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class FormQuoteInput implements QuoteInput{
    private final Long customerId;
    private final Long productId;
    private final Integer quantity;
    private final UrgencyLevel urgency;
    private final BigDecimal requestedDiscount;
}
