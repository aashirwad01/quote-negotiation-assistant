package com.quote.controller;

import com.quote.dto.FormRequestDTO;
import com.quote.dto.QuoteResponseDTO;
import com.quote.model.input.QuoteInput;
import com.quote.service.QuoteService;
import com.quote.adapter.QuoteInputFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;
    private final QuoteInputFactory inputFactory;

    @PostMapping
    public ResponseEntity<QuoteResponseDTO> generateQuote(@Valid @RequestBody FormRequestDTO request) {
        // Use factory to normalize the input
        QuoteInput input = inputFactory.fromForm(request);
        return ResponseEntity.ok(quoteService.processQuote(input));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuoteResponseDTO> getQuoteById(@PathVariable Long id) {
        return ResponseEntity.ok(quoteService.getQuoteById(id));
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Quote Negotiation API is running!");
    }
}
