package com.quote.service;

import com.quote.dto.FormRequestDTO;
import com.quote.dto.LLMOverrideDTO;
import com.quote.model.UrgencyLevel;
import com.quote.model.input.FormQuoteInput;
import com.quote.model.input.QuoteInput;

import java.math.BigDecimal;

public class FormRequestAdapter implements QuoteInputSource{
    private final FormRequestDTO form;
    private final LLMOverrideDTO override;

    public FormRequestAdapter(FormRequestDTO form, LLMOverrideDTO override) {
        this.form = form;
        this.override = override;
    }


    @Override
    public QuoteInput toQuoteInput() {
     return new FormQuoteInput(
             form.getCustomerId(),
             form.getProductId(),
             form.getQuantity() != null ? form.getQuantity() : override != null ? override.getQuantity() : null,
             form.getUrgency() != null ? form.getUrgency() : override != null ? override.getUrgency() : UrgencyLevel.MEDIUM,
             override != null ? override.getRequestedDiscount() : BigDecimal.ZERO);

    }
}
