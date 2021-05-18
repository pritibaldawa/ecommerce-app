package com.example.demo.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class ShoppingCart {

	private String cartId;
	@Setter
	private List<Item> items;
	@Setter
	private int totalItems;
	@Setter
	private double totalCartValue;

	public ShoppingCart(String cartId, List<Item> items, int totalItems, double totalCartValue) {
		this.cartId = cartId;
		this.items = items;
		this.totalItems = totalItems;
		this.totalCartValue = totalCartValue;
	}

	public void addItem(@NonNull final Item item) {
		items.add(item);
	}

}
