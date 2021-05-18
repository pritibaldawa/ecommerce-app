package com.example.demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.example.demo.config.MyConfiguration;
import com.example.demo.controllers.ProductController;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.ProductCategory;
import com.example.demo.services.ProductService;
import com.example.demo.services.impl.ProductServiceImpl;

@SpringBootTest
@ContextConfiguration(classes = MyConfiguration.class)
class ProductControllerTest {

	ProductController productController;

	@MockBean
	@Qualifier("products")
	Map<String, Product> products;

	@InjectMocks
	ProductService productService = new ProductServiceImpl();

	@BeforeEach
	void setUp() {
		productService = mock(ProductServiceImpl.class);
		productController = new ProductController(productService);
	}

	@Test
	void testGetProducts() {
		Product p1 = new Product("121", "abc", ProductCategory.BOOKS, 100.0, 12);
		Map<String, Product> productsNew = new HashMap<>();
		productsNew.put("121", p1);
		System.out.print(products);
		when(products.values()).thenReturn(productsNew.values());
		productService.getProducts();
		assertEquals(1, productsNew.size());
	}
	/*
	 * @Test void testGetProductsByName() { Product p1 = new Product("121", "abc",
	 * ProductCategory.BOOKS, 100.0, 12); Map<String, Product> productsNew = new
	 * HashMap<>(); productsNew.put("121", p1); System.out.print(products);
	 * when(products.values()).thenReturn(productsNew.values()); //
	 * productController.getProductByName("abc"); // assertEquals(1,
	 * productsNew.size());
	 * 
	 * assertThrows(ResourceNotFoundException.class, () -> {
	 * productController.getProductByName("abcd"); }); }
	 */

}
