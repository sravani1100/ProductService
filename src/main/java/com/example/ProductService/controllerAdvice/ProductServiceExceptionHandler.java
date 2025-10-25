package com.example.ProductService.controllerAdvice;

import com.example.ProductService.dtos.ExceptionDto;
import com.example.ProductService.dtos.ProductNotFoundExceptionDto;
import com.example.ProductService.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {

    /*@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(){

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong.");
        exceptionDto.setResolutionDetails("You need to pay more money to get it resolved.");

        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.UNAUTHORIZED
        );
    }*/

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException e){

        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();

        //e.printStackTrace();
        productNotFoundExceptionDto.setProductId(e.getProductId());
        productNotFoundExceptionDto.setMessage("Product not found!");
        productNotFoundExceptionDto.setResolution("please try again with a valid productId.");

        return new ResponseEntity<>(
                productNotFoundExceptionDto,
                HttpStatus.NOT_FOUND
        );
    }
}
