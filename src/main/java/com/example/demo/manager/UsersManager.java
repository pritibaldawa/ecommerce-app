package com.example.demo.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.exceptions.SellerNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.Seller;
import com.example.demo.model.User;

import lombok.NonNull;

/** In memory database for storing sellers and users. */
@Component
public class UsersManager {

	@Autowired
	public Map<String, Seller> sellers;

	@Autowired
	public Map<String, User> users;

	public Seller getSeller(@NonNull final String sellerId) {
		if (!sellers.containsKey(sellerId)) {
			throw new SellerNotFoundException();
		}
		return sellers.get(sellerId);
	}

	public User getUser(@NonNull final String userId) {
		if (!users.containsKey(userId)) {
			throw new UserNotFoundException();
		}
		return users.get(userId);
	}
}
