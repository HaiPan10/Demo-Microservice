package com.example.demoorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoorderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
