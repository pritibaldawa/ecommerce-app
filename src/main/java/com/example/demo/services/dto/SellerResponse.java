package com.example.demo.services.dto;

import java.util.List;

import com.example.demo.model.Product;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SellerResponse {

	private String sellerId;
	private List<Product> products;
}
