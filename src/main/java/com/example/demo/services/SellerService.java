package com.example.demo.services;

import com.example.demo.model.Product;

public interface SellerService {

	public Product createProduct(final String productId, final String productName, final double price,
			final String prodCategory, final int qty, final String sellerId);
}
