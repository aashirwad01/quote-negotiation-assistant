package com.quote.adapter;

import com.quote.dto.FormRequestDTO;
import com.quote.model.input.QuoteInput;

public interface QuoteInputFactory {
    QuoteInput fromForm (FormRequestDTO request);
}
