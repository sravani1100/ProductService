package com.example.ProductService.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{

    private String title;
    private Double price;
    private String description;
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Category category;


}
