package com.example.demo.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Product;

import lombok.NonNull;

/** In memory database for storing products. */
@Component
public class ProductsManager {

	@Autowired
	public Map<String, Product> products;

	public Product getProduct(@NonNull final String productId) {
		if (!products.containsKey(productId)) {
			throw new ResourceNotFoundException("Product Not Found");
		}
		return products.get(productId);
	}
}
