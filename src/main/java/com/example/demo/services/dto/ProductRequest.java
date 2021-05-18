package com.example.demo.services.dto;

import com.example.demo.model.ProductCategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

	private String id;
	private String name;
	private ProductCategory productCategory;
	private Double price;
	private Integer stockAvailable;
	private String sellerId;
}
