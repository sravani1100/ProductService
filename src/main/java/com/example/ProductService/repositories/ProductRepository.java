package com.example.ProductService.repositories;

import com.example.ProductService.models.Category;
import com.example.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long productId);

    List<Product> findByTitleContainsIgnoreCase(String title);

    List<Product> findByPriceBetween(Double priceAfter, Double priceBefore);

    List<Product> findByCategory(Category category);

    List<Product> findAllByCategory_Id(Long categoryId);

    List<Product> findAllByCategory_Title(String categoryTitle);

    Product save(Product product);

    @Override
    void deleteById(Long productId);

    @Query(value = "Select * from products p where p.id = :id", nativeQuery = true) //SQL query
    Product findProductWithGivenId(@Param("id") Long productId);
}
