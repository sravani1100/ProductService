package com.example.ProductService.inheritanceDemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_instructors")
public class Instructor extends User{
    private String subject;
    private Double rating;
}
