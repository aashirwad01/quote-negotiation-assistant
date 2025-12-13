package com.quote.service;

import com.quote.dto.LLMOverrideDTO;
import com.quote.dto.ElasticityMetricsDTO;

public interface ElasticityService {
    ElasticityMetricsDTO calculateElasticity(LLMOverrideDTO overrideDTO);
}
