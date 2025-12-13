package com.quote.service;

import com.quote.dto.LLMOverrideDTO;
import com.quote.dto.ElasticityMetricsDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ElasticityServiceStub implements ElasticityService {

    @Override
    public ElasticityMetricsDTO calculateElasticity(LLMOverrideDTO overrideDTO) {
        // Example rule-based dummy logic
        BigDecimal elasticity = BigDecimal.valueOf(1.0);

        if (overrideDTO.getUrgency() != null) {
            switch (overrideDTO.getUrgency()) {
                case CRITICAL -> elasticity = BigDecimal.valueOf(0.3);
                case HIGH -> elasticity = BigDecimal.valueOf(0.6);
                case MEDIUM -> elasticity = BigDecimal.valueOf(0.9);
                case LOW -> elasticity = BigDecimal.valueOf(1.2);
            }
        }

        return ElasticityMetricsDTO.builder()
                .elasticityScore(elasticity)
                .interpretation("Based on urgency")
                .build();
    }
}
