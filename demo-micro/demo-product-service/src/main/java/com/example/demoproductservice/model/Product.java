package com.example.demoproductservice.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(value = "product")
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
