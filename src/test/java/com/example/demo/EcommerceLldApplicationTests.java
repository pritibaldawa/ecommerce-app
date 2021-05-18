package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.controllers.OrderController;
import com.example.demo.controllers.ProductController;
import com.example.demo.controllers.SellerController;
import com.example.demo.controllers.ShoppingCartController;
import com.example.demo.manager.ProductsManager;
import com.example.demo.manager.UsersManager;
import com.example.demo.model.Account;
import com.example.demo.model.Product;
import com.example.demo.model.ProductCategory;
import com.example.demo.model.Seller;
import com.example.demo.model.User;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;
import com.example.demo.services.SellerService;
import com.example.demo.services.ShoppingCartService;
import com.example.demo.services.dto.SellerRequest;
import com.example.demo.services.impl.OrderServiceImpl;
import com.example.demo.services.impl.ProductServiceImpl;
import com.example.demo.services.impl.SellerServiceImpl;
import com.example.demo.services.impl.ShoppingCartServiceImpl;

@SpringBootTest
class EcommerceLldApplicationTests {
	ProductController productController;
	OrderController orderController;
	SellerController sellerController;
	ShoppingCartController cartController;

	@BeforeEach
	void setUp() {
		UsersManager usersManager = new UsersManager();
		ProductsManager prodsManager = new ProductsManager();
		ProductService productService = new ProductServiceImpl();
		SellerService sellerService = new SellerServiceImpl();
		ShoppingCartService cartService = new ShoppingCartServiceImpl(prodsManager);
		OrderService orderService = new OrderServiceImpl();
		productController = new ProductController(productService);
		orderController = new OrderController(orderService, usersManager);
		sellerController = new SellerController(sellerService, usersManager);
		cartController = new ShoppingCartController(cartService);

		Map<String, Product> products = new HashMap<>();
		products.put("123", new Product("123", "HP Laptop", ProductCategory.ELECTRONICS, 60000.0, 10));
		products.put("234", new Product("234", "Becoming", ProductCategory.BOOKS, 451.0, 30));
		products.put("345", new Product("345", "Tshirt Polo", ProductCategory.FASHION, 340.0, 3));
		products.put("456", new Product("456", "Study Table", ProductCategory.FURNITURE, 999.0, 10));
		products.put("789", new Product("789", "JBL earphones", ProductCategory.ELECTRONICS, 6000.0, 15));

		Map<String, Seller> sellers = new HashMap<>();
		sellers.put("111", new Seller("111", new Account("CloudTail Retailers", "cretailers@gmail.com", "password")));
		sellers.put("222", new Seller("222", new Account("Appario Retailers", "appario@gmail.com", "password")));
		sellers.put("333", new Seller("333", new Account("Scott International", "scott@gmail.com", "password")));

		Map<String, User> users = new HashMap<>();
		users.put("111", new User("101", new Account("John Mathews", "john@gmail.com", "password")));
		users.put("222", new User("102", new Account("Rick Morty", "rick@gmail.com", "password")));
		users.put("333", new User("103", new Account("Paul G", "paul@gmail.com", "password")));

	}

	@Test
	void testSellerFlow() {
		SellerRequest sellerRequest = new SellerRequest("444", new Account("happy Sales", "happy@gmail.com", "password"));
		//sellerController.addSeller(sellerRequest);
		
	}

}
