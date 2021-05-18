package com.example.demo.services.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	public Double getAmount(Order order) {
		return order.getOrderValue();
	}
}
