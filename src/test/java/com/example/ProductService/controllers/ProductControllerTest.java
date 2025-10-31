package com.example.ProductService.controllers;

import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;
import com.example.ProductService.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockitoBean
    private ProductService productService;

    //AAA
    /*@Test
    public void testGetSingleProductPositiveCase() throws ProductNotFoundException {
        //ARRANGE
        Long productId = 10L;
        Product expectedProduct = new Product();
        expectedProduct.setId(productId);
        expectedProduct.setTitle("Iphone16");
        expectedProduct.setPrice(70000.0);

        when(productService.getSingleProduct(productId)).thenReturn(expectedProduct);

        //ACT
        Product actualProduct = productController.getSingleProduct(productId);

        //ASSERT
        assertEquals(expectedProduct, actualProduct);

    }*/

    /*@Test
    public void testGetSingleProductThrowsProductNotFoundException() throws ProductNotFoundException {
        ProductNotFoundException productNotFoundException = new ProductNotFoundException("Please pass the correct producrtId");
        when(productService.getSingleProduct(-1L)).thenThrow(productNotFoundException);

        Exception exception = assertThrows(ProductNotFoundException.class,
                                            () -> productController.getSingleProduct(-1L));

        assertEquals(productNotFoundException.getMessage(), exception.getMessage());

    }*/
}