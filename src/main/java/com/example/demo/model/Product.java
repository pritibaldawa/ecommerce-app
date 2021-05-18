package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@NoArgsConstructor
@lombok.EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

	@lombok.EqualsAndHashCode.Include
	private String id;
	private String name;
	private ProductCategory productCategory;
	private Double price;
	private Integer stockAvailable;
	// private Seller seller;

}
