package com.example.demoproductservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demoproductservice.dto.ProductRequest;
import com.example.demoproductservice.dto.ProductResponse;
import com.example.demoproductservice.model.Product;
import com.example.demoproductservice.repository.ProductRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();

        productRepository.save(product);
        System.out.println("Product " + product.getId() + " is saved");
    }

    public List<ProductResponse> getProducts(){
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> ProductResponse.builder()
                    .id(product.getId())
                    .description(product.getDescription())
                    .name(product.getName())
                    .price(product.getPrice()).build()).collect(Collectors.toList());
    }
}
