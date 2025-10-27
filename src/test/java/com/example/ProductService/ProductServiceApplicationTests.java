package com.example.ProductService;

import com.example.ProductService.models.Product;
import com.example.ProductService.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {

	private ProductRepository productRepository;

	public ProductServiceApplicationTests(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testQuery(){
		Product product = productRepository.findProductWithGivenId(1L);
		System.out.println("DEBUG");
	}

}
