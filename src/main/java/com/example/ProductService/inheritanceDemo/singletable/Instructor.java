package com.example.ProductService.inheritanceDemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "st_instructors")
@DiscriminatorValue(value = "1")
public class Instructor extends User {

    private String subject;
    private Double rating;
}
