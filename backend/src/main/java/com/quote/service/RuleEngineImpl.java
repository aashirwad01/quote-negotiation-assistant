package com.quote.service;

import com.quote.model.*;
import com.quote.model.input.QuoteInput;
import com.quote.repository.CustomerRepository;
import com.quote.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class RuleEngineImpl implements RuleEngine {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Override
    public Quote applyRules(QuoteInput input) {
        Customer customer = customerRepository.findById(input.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Product product = productRepository.findById(input.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        BigDecimal listPrice = product.getListPrice();
        Integer quantity = input.getQuantity();
        UrgencyLevel urgency = input.getUrgency();

        BigDecimal discount = calculateDiscount(customer, quantity, urgency, input.getRequestedDiscount());

        BigDecimal discountAmount = listPrice.multiply(discount);
        BigDecimal finalPrice = listPrice.subtract(discountAmount);

        Quote quote = new Quote();
        quote.setCustomer(customer);
        quote.setProduct(product);
        quote.setQuantity(quantity);
        quote.setListPrice(listPrice);
        quote.setDiscount(discount);
        quote.setFinalPrice(finalPrice);
        quote.setCreatedAt(LocalDateTime.now());

        return quote;
    }

    private BigDecimal calculateDiscount(Customer customer, Integer quantity, UrgencyLevel urgency, BigDecimal override) {
        BigDecimal discount = BigDecimal.ZERO;

        // Tier-based
        switch (customer.getCustomerTier()) {
            case SILVER -> discount = discount.add(BigDecimal.valueOf(0.05));
            case GOLD -> discount = discount.add(BigDecimal.valueOf(0.10));
        }

        // Volume-based
        if (quantity != null && quantity > 100) {
            discount = discount.add(BigDecimal.valueOf(0.07));
        }

        // Urgency penalty
        if (urgency == UrgencyLevel.HIGH || urgency == UrgencyLevel.CRITICAL) {
            discount = discount.subtract(BigDecimal.valueOf(0.05));
        }

        // Override from LLM (if any)
        if (override != null && override.compareTo(BigDecimal.ZERO) > 0) {
            discount = override;
        }

        return discount.max(BigDecimal.ZERO); // Avoid negative discount
    }
}
