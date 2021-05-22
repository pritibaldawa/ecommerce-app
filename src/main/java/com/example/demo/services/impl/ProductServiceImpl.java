package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.ProductCategory;
import com.example.demo.services.ProductService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	public Map<String, Product> products;

	@Override
	public List<Product> getProducts() {
		List<Product> result = new ArrayList<Product>();
		System.out.print(products);
		for (Product prod : products.values()) {
			result.add(prod);
		}
		return result;
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		List<Product> result = new ArrayList<Product>();
		for (Product prod : products.values()) {
			if (prod.getName().equalsIgnoreCase(productName))
				result.add(prod);
		}
		if (result.isEmpty())
			throw new ResourceNotFoundException("Product '" + productName + "' Not Found");
		return result;
	}

	@Override
	public List<Product> getProductByCategory(String categoryName) {
		List<Product> result = new ArrayList<Product>();
		if (!checkIfProductCategoryExists(categoryName))
			throw new ResourceNotFoundException(
					"Product category :" + categoryName + " is either invalid or does not exist!");

		for (Product prod : products.values()) {
			if (prod.getProductCategory().name().equals(categoryName))
				result.add(prod);
		}
		return result;
	}

	public boolean checkIfProductCategoryExists(String prodCategory) {
		for (ProductCategory cat : ProductCategory.values()) {
			if (cat.name().equals(prodCategory))
				return true;
		}
		return false;
	}

}
