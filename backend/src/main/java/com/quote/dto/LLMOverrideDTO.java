package com.quote.dto;

import com.quote.model.UrgencyLevel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LLMOverrideDTO {
    private Integer quantity;
    private UrgencyLevel urgency;
    private BigDecimal requestedDiscount;
    private String priceMatchTo;
    private LocalDate deliveryDeadline;
    private String commentary; // Optional explanation from LLM
}
