package com.quote.repository;

import com.quote.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    // findById(Long id) is already available
}
