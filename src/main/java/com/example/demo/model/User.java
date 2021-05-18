package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Getter
public class User extends Customer {

	private String userId;
	private Account account;
	private List<Order> orders;

	public User(String userId, Account account) {
		this.userId = userId;
		this.account = account;
		this.orders = new ArrayList<Order>();
	}

	public void addOrder(@NonNull final Order order) {
		this.orders.add(order);
	}
}
