package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ShoppingCart;
import com.example.demo.services.ShoppingCartService;
import com.example.demo.services.dto.CartRequest;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {

	ShoppingCartService cartService;

	public ShoppingCartController(ShoppingCartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping(value = "/cart")
	public ResponseEntity<ShoppingCart> addToCart(@RequestBody CartRequest cartRequest) {
		ShoppingCart cart = cartService.addToCart(cartRequest.getUserId(), cartRequest.getProductId(),
				cartRequest.getQty());
		return ResponseEntity.ok(cart);

	}

	@GetMapping(value = "/cart")
	public ResponseEntity getCart(@RequestParam String userId) {
		ShoppingCart cart = cartService.getCart(userId);
		return (cart.getCartId() == null) ? ResponseEntity.ok("Shopping cart is empty") : ResponseEntity.ok(cart);
	}

}
