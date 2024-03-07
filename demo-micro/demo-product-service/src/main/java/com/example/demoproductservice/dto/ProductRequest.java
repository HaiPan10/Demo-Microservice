package com.example.demoproductservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
}
