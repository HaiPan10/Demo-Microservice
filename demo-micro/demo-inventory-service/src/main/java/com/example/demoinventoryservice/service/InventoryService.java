package com.example.demoinventoryservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoinventoryservice.dto.InventoryResponse;
import com.example.demoinventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
        return inventoryRepository.findBySkuCode(skuCode).stream()
            .map(item -> {
                return InventoryResponse.builder()
                    .skuCode(item.getSkuCode())
                    .isInStock(item.getQuantity() > 0)
                    .build();
            })
            .collect(Collectors.toList());
    }
}
