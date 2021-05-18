package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Account {

	private String name;
	private String userName;
	private String password;	
	private List<Address> shippingAdresses;
	
	public Account(String name, String userName, String password) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.shippingAdresses = new ArrayList<Address>();
	}
}
