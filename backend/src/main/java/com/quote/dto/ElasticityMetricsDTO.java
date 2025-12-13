package com.quote.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElasticityMetricsDTO {
    private BigDecimal elasticityScore;
    private String interpretation; // Optional: "High", "Low", etc.
}
