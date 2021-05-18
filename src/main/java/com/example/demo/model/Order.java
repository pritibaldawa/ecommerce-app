package com.example.demo.model;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.exceptions.InvalidStateException;

import lombok.Getter;
import lombok.Setter;

public class Order {

	@Getter
	private final String orderId;
	private final List<Item> orderItems;
	@Getter
	private final double orderValue;
	@Getter @Setter
	private OrderStatus orderStatus;

	public Order(String orderId, List<Item> orderItems, double orderValue) {
		super();
		this.orderId = orderId;
		List<Item> tempList = orderItems.stream().collect(Collectors.toList());
		this.orderItems = tempList;
		this.orderValue = orderValue;
		this.orderStatus = OrderStatus.pending;
	}

	public List<Item> getOrderItems() {
		List<Item> tempList = orderItems.stream().collect(Collectors.toList());
		return tempList;
	}
	
	public void confirmBooking() {
        if (this.orderStatus != OrderStatus.pending) {
            throw new InvalidStateException();
        }
        this.orderStatus = OrderStatus.confirmed;
    }

}
