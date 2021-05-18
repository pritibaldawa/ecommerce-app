package com.example.demo.services;

import java.util.List;
import com.example.demo.model.Product;

public interface ProductService {

	public List<Product> getProducts();

	public List<Product> getProductsByName(String productName);

	public List<Product> getProductByCategory(String categoryName);

}
