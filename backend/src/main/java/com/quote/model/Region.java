package com.quote.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionId;

    private String name;
}
