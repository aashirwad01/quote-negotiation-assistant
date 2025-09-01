package com.quote.dto;

import com.quote.model.UrgencyLevel;
import lombok.Data;

@Data
public class FormRequestDTO {
    private Long customerId;
    private Long productId;
    private Integer quantity;
    private UrgencyLevel urgency;
    private String quoteNote; // Used for LLM input
}
