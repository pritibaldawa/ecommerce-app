package com.example.demo.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

	private String id;
	private String name;
	private String productCategory;
	private Double price;
	private Integer stockAvailable;
	private String sellerId;
}
