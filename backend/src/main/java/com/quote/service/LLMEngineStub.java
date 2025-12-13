package com.quote.service;

import com.quote.dto.ElasticityMetricsDTO;
import com.quote.dto.LLMOverrideDTO;
import com.quote.model.UrgencyLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LLMEngineStub implements LLMEngine {

    private final ElasticityService elasticityService;

    @Autowired
    public LLMEngineStub(ElasticityService elasticityService) {
        this.elasticityService = elasticityService;
    }

    @Override
    public LLMOverrideDTO parse(String quoteNoteText) {
        LLMOverrideDTO override = new LLMOverrideDTO();

        // Parse quantity
        Matcher quantityMatcher = Pattern.compile("(\\d+)\\s*(units|pieces|qty|quantity)", Pattern.CASE_INSENSITIVE)
                .matcher(quoteNoteText);
        if (quantityMatcher.find()) {
            override.setQuantity(Integer.parseInt(quantityMatcher.group(1)));
        }

        // Parse urgency
        if (quoteNoteText.toLowerCase().contains("urgent") || quoteNoteText.toLowerCase().contains("asap")) {
            override.setUrgency(UrgencyLevel.HIGH);
        } else if (quoteNoteText.toLowerCase().contains("critical")) {
            override.setUrgency(UrgencyLevel.CRITICAL);
        } else if (quoteNoteText.toLowerCase().contains("whenever") || quoteNoteText.toLowerCase().contains("low priority")) {
            override.setUrgency(UrgencyLevel.LOW);
        } else {
            override.setUrgency(UrgencyLevel.MEDIUM); // default
        }

        // Parse requested discount
        Matcher discountMatcher = Pattern.compile("(\\d+(\\.\\d+)?)%\\s*discount", Pattern.CASE_INSENSITIVE)
                .matcher(quoteNoteText);
        if (discountMatcher.find()) {
            String discountStr = discountMatcher.group(1);
            BigDecimal discount = new BigDecimal(discountStr).divide(BigDecimal.valueOf(100));
            override.setRequestedDiscount(discount);
        }


        // Parse price match
        Matcher priceMatcher = Pattern.compile("(match|price to match|competitor price).*?(\\d+(\\.\\d+)?)", Pattern.CASE_INSENSITIVE)
                .matcher(quoteNoteText);
        if (priceMatcher.find()) {
            override.setPriceMatchTo(priceMatcher.group(2));
        }

        // Parse delivery deadline (very basic: looks for 'by YYYY-MM-DD' or 'by DATE')
        Matcher deadlineMatcher = Pattern.compile("by\\s+(\\d{4}-\\d{2}-\\d{2})", Pattern.CASE_INSENSITIVE)
                .matcher(quoteNoteText);
        if (deadlineMatcher.find()) {
            try {
                override.setDeliveryDeadline(LocalDate.parse(deadlineMatcher.group(1)));
            } catch (DateTimeParseException ignored) {}
        }

        // Optional: add parsed explanation as commentary
        override.setCommentary("Parsed using regex-based NLP simulation.");

        // Now compute elasticity using parsed values
        ElasticityMetricsDTO metrics = elasticityService.calculateElasticity(override);
        override.setElasticityMetrics(metrics);

        return override;
    }
}
