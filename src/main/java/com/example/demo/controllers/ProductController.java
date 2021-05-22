package com.example.demo.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(value = "/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productService.getProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping(value = "/products/{name}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable("name") final String productName) {
		List<Product> products = productService.getProductsByName(productName);
		return ResponseEntity.ok(products);
	}

	@GetMapping(value = "/products/cat/{name}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("name") final String categoryName) {
		List<Product> products = productService.getProductByCategory(categoryName.toUpperCase());
		return ResponseEntity.ok(products);
	}

}
