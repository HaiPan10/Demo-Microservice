package com.example.demoproductservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demoproductservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
    
}
