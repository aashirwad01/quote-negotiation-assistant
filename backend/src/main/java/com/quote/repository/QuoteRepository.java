package com.quote.repository;

import com.quote.model.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long> {
    // save(Quote), findById(Long) etc. are already available
}
