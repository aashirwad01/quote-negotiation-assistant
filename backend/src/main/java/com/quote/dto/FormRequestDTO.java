package com.quote.dto;

import com.quote.model.UrgencyLevel;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;


@Data
public class FormRequestDTO {
    @NotNull(message = "Customer ID is required")
    private Long customerId;
    
    @NotNull(message = "Product ID is required")
    private Long productId;
    
    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
    
    @NotNull(message = "Urgency level is required")
    private UrgencyLevel urgency;
    
    private String quoteNote; // Used for LLM input - optional field
}
