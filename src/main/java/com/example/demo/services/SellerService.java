package com.example.demo.services;

import com.example.demo.model.Product;
import com.example.demo.model.ProductCategory;

public interface SellerService {

	public Product createProduct(final String productId, final String productName, final double price,
			final ProductCategory prodCategory, final int qty, final String sellerId);
}
