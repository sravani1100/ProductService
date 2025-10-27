package com.example.ProductService.inheritanceDemo.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    private Long id;
    private String name;
    private String email;

}
