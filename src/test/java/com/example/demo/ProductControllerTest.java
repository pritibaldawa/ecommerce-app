package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.config.MyConfiguration;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.ProductCategory;
import com.example.demo.services.ProductService;
import com.example.demo.services.impl.ProductServiceImpl;

@SpringBootTest
@ContextConfiguration(classes = MyConfiguration.class)
class ProductControllerTest {

	Map<String, Product> productsNew = new HashMap<>();

	@Mock
	@Qualifier("products")
	Map<String, Product> products;

	@InjectMocks
	ProductService productService = new ProductServiceImpl();

	@BeforeEach
	void setUp() {
		Product p1 = new Product("121", "abc", ProductCategory.BOOKS, 100.0, 12);
		productsNew.put("121", p1);
		when(products.values()).thenReturn(productsNew.values());
	}

	@Test
	void testGetProducts() {
		List<Product> prods = productService.getProducts();
		assertEquals(1, prods.size());
	}

	@Test
	void testGetProductsByName() {
		List<Product> prods = productService.getProductsByName("abc");
		assertEquals(1, prods.size());
		assertThrows(ResourceNotFoundException.class, () -> {
			productService.getProductsByName("abcd");
		});
	}

	@Test
	void testGetProductsByCategory() {
		List<Product> prods = productService.getProductByCategory("BOOKS");
		assertEquals(1, prods.size());
		assertThrows(ResourceNotFoundException.class, () -> {
			productService.getProductByCategory("kitchen");
		});

	}
}