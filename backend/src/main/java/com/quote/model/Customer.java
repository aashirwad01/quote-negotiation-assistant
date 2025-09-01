package com.quote.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id") // Foreign key column name in Customer table
    private Region region;

    @Enumerated(EnumType.STRING)
    private CustomerTier customerTier;
}
