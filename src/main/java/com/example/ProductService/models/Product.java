package com.example.ProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{

    private String title;
    private Double price;
    private String description;
    private String imageUrl;

    @ManyToOne
    private Category category;


}
