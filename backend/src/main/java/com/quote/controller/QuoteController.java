package com.quote.controller;

import com.quote.dto.FormRequestDTO;
import com.quote.dto.QuoteResponseDTO;
import com.quote.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;

    @PostMapping
    public ResponseEntity<QuoteResponseDTO> generateQuote(@Valid @RequestBody FormRequestDTO request) {
        QuoteResponseDTO response = quoteService.processQuote(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuoteResponseDTO> getQuoteById(@PathVariable Long id) {
        QuoteResponseDTO response = quoteService.getQuoteById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Quote Negotiation API is running!");
    }
}
