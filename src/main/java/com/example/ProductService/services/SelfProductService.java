package com.example.ProductService.services;

import com.example.ProductService.exceptions.CategoryNotFoundException;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Category;
import com.example.ProductService.models.Product;
import com.example.ProductService.repositories.CategoryRepository;
import com.example.ProductService.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        /*Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id "+productId +" doesn't exist.");
        }
        return optionalProduct.get();*/

        return productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId, "Product with id "+productId +" doesn't exist."));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws CategoryNotFoundException{
        /*Category category = new Category();
        if(category == null){
            throw new CategoryNotFoundException("Product can't be created without category, please try again with category.");
        }

        Optional<Category> optionalCategory = categoryRepository.findByTitle(category.getTitle());

        if(optionalCategory.isEmpty()){
            category = categoryRepository.save(category);
        }else{
            category = optionalCategory.get();
        }
        product.setCategory(category);*/
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Page<Product> getProductsByTitle(String title, int pageNumber, int pageSize) {

        /*Sort sort = Sort
                .by(Sort.Direction.ASC, "price")
                .by(Sort.Direction.DESC, "title");
*/
        return productRepository.findByTitleContainsIgnoreCase(
                title,
                PageRequest.of(
                        pageNumber,
                        pageSize,
                        Sort.by(Sort.Direction.ASC, "price")
                                .by(Sort.Direction.DESC, "title"))
        );
    }
}
