package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exceptions.CartOrderMismatchException;
import com.example.demo.exceptions.InvalidStateException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.UserNotLoggedInException;
import com.example.demo.manager.UsersManager;
import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import com.example.demo.model.ShoppingCart;
import com.example.demo.model.User;
import com.example.demo.services.OrderService;
import com.example.demo.services.ShoppingCartService;

import lombok.NonNull;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ShoppingCartService cartService;
	@Autowired
	private UsersManager usersManager;
	@Autowired
	private PaymentServiceImpl paymentService;

	@Override
	public List<Order> fetchOrderHistory(@NonNull final String userId) {
		User user = usersManager.getUser(userId);
		return user.getOrders();
	}

	@Override
	public Order createOrder(@NonNull String userId) {
		ShoppingCart cart = cartService.getCart(userId);
		if (cart.getCartId() == null)
			throw new ResourceNotFoundException("No items present in the cart to place order");
		User user = usersManager.getUser(userId);
		if (user == null)
			throw new UserNotLoggedInException();
		String orderId = userId + "-" + (user.getOrders().size() + 1);
		Order order = new Order(orderId, cart.getItems(), cart.getTotalCartValue());
		// cartService.deleteCart(userId);
		user.addOrder(order);
		return order;
	}

	@Override
	public String makePayment(Order order, String userId) {
		if (order.getOrderStatus() == OrderStatus.confirmed || order.getOrderStatus() == OrderStatus.cancelled)
			throw new InvalidStateException();
		else if (!paymentService.getAmount(order)
				.equals(usersManager.users.get(userId).getCart().getTotalCartValue())) {
			order.setOrderStatus(OrderStatus.cancelled);
			throw new CartOrderMismatchException();
		} else
			order.setOrderStatus(OrderStatus.confirmed);

		cartService.deleteCart(userId);
		usersManager.users.get(userId).setCart(null);
		return "Payment Done successfully. Order " + order.getOrderId() + " is confimed";

	}
}