package com.example.demoinventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demoinventoryservice.model.Inventory;

import java.util.List;


public interface InventoryRepository extends JpaRepository<Inventory, Long>{
    // Optional<Inventory> findBySkuCode(String skuCode);

    @Query("Select a From Inventory a Where a.skuCode In ?1")
    List<Inventory> findBySkuCode(List<String> skuCode);
}
