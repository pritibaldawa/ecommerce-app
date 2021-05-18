package com.example.demo.services.impl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceAlreadyExistsException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.manager.UsersManager;
import com.example.demo.model.Product;
import com.example.demo.model.ProductCategory;
import com.example.demo.model.Seller;
import com.example.demo.services.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private UsersManager usersManager;
	@Autowired
	public Map<String, Product> products;
	@Autowired
	private ProductServiceImpl productService;

	@Override
	public Product createProduct(final String productId, final String productName, final double price,
			final ProductCategory prodCategory, final int qty, final String sellerId) {
		Seller seller = usersManager.getSeller(sellerId);
		if (!productService.checkIfProductCategoryExists(prodCategory)) {
			throw new ResourceNotFoundException("Product Category:" + prodCategory + " is invalid");
		}
		Product product = new Product(productId, productName, prodCategory, price, qty);
		seller.addProduct(product);
		if (products.containsKey(productId))
			throw new ResourceAlreadyExistsException("Product with ID:" + productId + " not found");
		products.put(productId, product);
		return product;
	}

}
