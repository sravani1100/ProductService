package com.example.ProductService.controllers;

import com.example.ProductService.commons.AuthCommons;
import com.example.ProductService.dtos.UserDto;
import com.example.ProductService.exceptions.CategoryNotFoundException;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.exceptions.UnAuthorizedException;
import com.example.ProductService.models.Product;
import com.example.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final RestTemplate restTemplate;
    private ProductService productService;
    private AuthCommons authCommons;

    public ProductController(ProductService productService,
                             RestTemplate restTemplate,
                             AuthCommons authCommons){
        this.productService = productService;
        this.restTemplate = restTemplate;
        this.authCommons = authCommons;
    }

    @GetMapping("/{id}/{token}")
    public Product getSingleProduct(@PathVariable("id") Long productId, @PathVariable String token) throws ProductNotFoundException {

        /*ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getSingleProduct(productId),
                HttpStatus.OK
        );*/

        UserDto userDto = authCommons.validateToken(token);
        if(userDto == null){
            throw new UnAuthorizedException("Invalid Token provided.");
        }
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) throws CategoryNotFoundException {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId){

        return null;
    }
}
