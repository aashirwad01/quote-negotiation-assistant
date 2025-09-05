package com.quote.model.input;

import com.quote.model.UrgencyLevel;

import java.math.BigDecimal;

public interface QuoteInput {
    Long getCustomerId();
    Long getProductId();
    Integer getQuantity();
    UrgencyLevel getUrgency();
    BigDecimal getRequestedDiscount(); // Optional override
}
