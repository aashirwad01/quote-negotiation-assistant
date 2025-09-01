package com.quote.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class QuoteResponseDTO {
    private Long quoteId;
    private String customerName;
    private String regionName;
    private String productName;
    private Integer quantity;
    private BigDecimal listPrice;
    private BigDecimal finalPrice;
    private BigDecimal discount;
    private List<String> appliedRules;
    private LocalDateTime createdAt;
}
