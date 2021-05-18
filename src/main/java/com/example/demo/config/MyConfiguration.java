package com.example.demo.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Account;
import com.example.demo.model.Product;
import com.example.demo.model.ProductCategory;
import com.example.demo.model.Seller;
import com.example.demo.model.User;

@Configuration
public class MyConfiguration {

	Product p1 = new Product("123", "HP Laptop", ProductCategory.ELECTRONICS, 60000.0, 10);
	Product p2 = new Product("234", "Becoming", ProductCategory.BOOKS, 451.0, 30);
	Product p3 = new Product("345", "Tshirt Polo", ProductCategory.FASHION, 340.0, 3);
	Product p4 = new Product("456", "Study Table", ProductCategory.FURNITURE, 999.0, 10);
	Product p5 = new Product("789", "JBL earphones", ProductCategory.ELECTRONICS, 6000.0, 15);

	@Bean
	public Map<String, Product> products() {
		Map<String, Product> products = new HashMap<>();
		products.put("123", p1);
		products.put("234", p2);
		products.put("345", p3);
		products.put("456", p4);
		products.put("789", p5);

		return products;
	}

	@Bean
	public Map<String, Seller> sellers() {
		Map<String, Seller> sellers = new HashMap<>();
		sellers.put("111", new Seller("111", new Account("CloudTail Retailers", "cretailers@gmail.com", "password"),
				new ArrayList<Product>(Arrays.asList(p1, p2))));
		sellers.put("222", new Seller("222", new Account("Appario Retailers", "appario@gmail.com", "password"),
				new ArrayList<Product>(Arrays.asList(p3))));
		sellers.put("333", new Seller("333", new Account("Scott International", "scott@gmail.com", "password"),
				new ArrayList<Product>(Arrays.asList(p4, p5))));

		return sellers;
	}

	@Bean
	public Map<String, User> users() {
		Map<String, User> users = new HashMap<>();
		users.put("101", new User("101", new Account("John Mathews", "john@gmail.com", "password")));
		users.put("102", new User("102", new Account("Rick Morty", "rick@gmail.com", "password")));
		users.put("103", new User("103", new Account("Paul G", "paul@gmail.com", "password")));

		return users;
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
}
