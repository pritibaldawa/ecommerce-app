package com.example.demo.services.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.manager.ProductsManager;
import com.example.demo.manager.UsersManager;
import com.example.demo.model.Item;
import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCart;
import com.example.demo.model.User;
import com.example.demo.services.ShoppingCartService;

import lombok.NonNull;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private Map<String, ShoppingCart> shoppingCarts = new HashMap<>();
	private ProductsManager productsManager;
	private UsersManager usersManager;

	public ShoppingCartServiceImpl(ProductsManager productsManager, UsersManager usersManager) {
		this.productsManager = productsManager;
		this.usersManager = usersManager;
	}

	@Override
	public ShoppingCart getCart(final String userId) {
		if (shoppingCarts.containsKey(userId)) {
			return shoppingCarts.get(userId);
		}
		return new ShoppingCart();
	}

	@Override
	public Item createCartItem(@NonNull String productId, int qty) {
		Product product = productsManager.getProduct(productId);
		if (product == null)
			throw new ResourceNotFoundException("Product with ID: " + productId + " Not Found");
		// List<Product> products =
		// productIds.stream().map(productsManager::getProduct).collect(Collectors.toList());
		Item item = new Item(product, qty);
		return item;

	}

	@Override
	public ShoppingCart addToCart(String userId, String productId, int qty) {
		Item item = createCartItem(productId, qty);
		ShoppingCart cart = getCart(userId);
		if (cart.getCartId() != null) {
			if (checkItemAlreadyExistsInCart(cart.getItems(), item))
				item.setQuantity(item.getQuantity() + qty);
			else
				cart.addItem(item);
			cart.setTotalItems(cart.getTotalItems() + qty);
			cart.setTotalCartValue(cart.getTotalCartValue() + item.getProduct().getPrice() * qty);
		} else {
			final String cartId = UUID.randomUUID().toString();
			cart = new ShoppingCart(cartId, Arrays.asList(item), qty, item.getProduct().getPrice() * qty);
		}
		shoppingCarts.put(userId, cart);
		usersManager.getUser(userId).setCart(cart);
		return cart;
	}

	@Override
	public void deleteCart(@NonNull String userId) {
		if (shoppingCarts.containsKey(userId)) {
			shoppingCarts.remove(userId);
		}
	}

	public boolean checkItemAlreadyExistsInCart(List<Item> items, Item item) {
		boolean idExists = items.stream().anyMatch(i -> i.getProduct().getId().equals(item.getProduct().getId()));
		return idExists;
	}

}
