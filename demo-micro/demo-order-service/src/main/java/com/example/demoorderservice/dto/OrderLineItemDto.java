package com.example.demoorderservice.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemDto implements Serializable{
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
