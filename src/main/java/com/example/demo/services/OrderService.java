package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Order;
import lombok.NonNull;

public interface OrderService {

	public List<Order> fetchOrderHistory(@NonNull final String userId);

	public Order createOrder(@NonNull String userId);

	public String makePayment(Order order, String userId);
}