package com.example.ProductService.services;

import com.example.ProductService.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public void deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
