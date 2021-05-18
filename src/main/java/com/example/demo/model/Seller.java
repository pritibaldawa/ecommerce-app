package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Seller extends Customer {

	private String sellerId;
	private Account accDetails;
	private List<Product> products;
	
	public Seller(String sellerId, Account accDetails) {
		this.sellerId = sellerId;
		this.accDetails = accDetails;
		this.products = new ArrayList<>();	
	}
	
	public void addProduct(@NonNull final  Product product) {
        products.add(product);
    }
}
