package com.example.demo;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.stubbing.Answer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import com.example.demo.config.MyConfiguration;
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
@ContextConfiguration(classes = MyConfiguration.class)
class EcommerceLldApplicationTests {
	ProductController productController;
	OrderController orderController;
	SellerController sellerController;
	ShoppingCartController cartController;
	@MockBean @Qualifier("products")
	Map<String, Product> products;
	Map<String, Seller> sellers;
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() {
		UsersManager usersManager = new UsersManager();
		ProductsManager prodsManager = new ProductsManager();
		ProductService productService = new ProductServiceImpl();
		SellerService sellerService = new SellerServiceImpl();
		ShoppingCartService cartService = new ShoppingCartServiceImpl(prodsManager, usersManager);
		OrderService orderService = new OrderServiceImpl();
		productController = new ProductController(productService);
		orderController = new OrderController(orderService, usersManager);
		sellerController = new SellerController(sellerService, usersManager);
		cartController = new ShoppingCartController(cartService);

		
	}

	/*
	 * @Test void testSellerFlow() { Map<String, Seller> sellersNew = new
	 * HashMap<>(); sellers.put("111", new Seller("111", new
	 * Account("CloudTail Retailers", "cretailers@gmail.com", "password")));
	 * sellers.put("222", new Seller("222", new Account("Appario Retailers",
	 * "appario@gmail.com", "password"))); sellers.put("333", new Seller("333", new
	 * Account("Scott International", "scott@gmail.com", "password")));
	 * 
	 * SellerRequest sellerRequest = new SellerRequest("444", new
	 * Account("happy Sales", "happy@gmail.com", "password"));
	 * when(sellers.containsKey(sellerRequest.getSellerId())).thenReturn(sellersNew.
	 * containsKey(sellerRequest.getSellerId()));
	 * sellerController.addSeller(sellerRequest); assertEquals(4,
	 * sellersNew.size());
	 * 
	 * }
	 */
	@SuppressWarnings("unchecked")
	@Test
	void getProducts() {
		Product p1 = new Product("121", "abc", ProductCategory.BOOKS, 100.0, 12);
		Map<String, Product> productsNew = new HashMap<>();
		productsNew.put("121", p1);	
		System.out.print(products);
		when(products.values()).thenReturn(productsNew.values());
		assertEquals(1, productsNew.size());

	}

}
