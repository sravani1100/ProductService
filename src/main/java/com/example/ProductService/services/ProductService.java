package com.example.ProductService.services;

import com.example.ProductService.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    boolean deleteProduct(Long productId);
}
