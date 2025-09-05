package com.quote.dto;

import com.quote.model.Quote;
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

    public static QuoteResponseDTO from(Quote quote) {
        QuoteResponseDTO dto = new QuoteResponseDTO();
        dto.setQuoteId(quote.getQuoteId());
        dto.setCustomerName(quote.getCustomer().getName());
        dto.setRegionName(quote.getCustomer().getRegion().getName());
        dto.setProductName(quote.getProduct().getName());
        dto.setQuantity(quote.getQuantity());
        dto.setListPrice(quote.getListPrice());
        dto.setFinalPrice(quote.getFinalPrice());
        dto.setDiscount(quote.getDiscount());
        dto.setCreatedAt(quote.getCreatedAt());

        // TODO: if you're tracking rules, fetch from quote/appliedRules
        dto.setAppliedRules(List.of()); // Empty for now
        return dto;
    }
}
