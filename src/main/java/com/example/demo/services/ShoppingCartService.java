package com.example.demo.services;

import com.example.demo.model.Item;
import com.example.demo.model.ShoppingCart;
import lombok.NonNull;

public interface ShoppingCartService {

	public ShoppingCart getCart(String userId);

	public Item createCartItem(@NonNull String productId, int qty);

	public ShoppingCart addToCart(String userId, String productId, int qty);

	public void deleteCart(@NonNull String userId);

}
