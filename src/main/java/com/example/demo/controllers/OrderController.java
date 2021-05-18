package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.manager.UsersManager;
import com.example.demo.model.Order;
import com.example.demo.services.OrderService;

import lombok.NonNull;

@RestController
@RequestMapping("/api")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService, UsersManager userManager) {
		this.orderService = orderService;
	}

	@PostMapping(value = "/cart/order")
	public ResponseEntity<String> placeOrder(@RequestBody @NonNull final String userId) {
		Order order = orderService.createOrder(userId);
		String response = orderService.makePayment(order, userId);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/orders")
	public ResponseEntity<List<Order>> fetchOrderHistory(@RequestParam(required = true) String userId) {
		return ResponseEntity.ok(orderService.fetchOrderHistory(userId));
	}
}
