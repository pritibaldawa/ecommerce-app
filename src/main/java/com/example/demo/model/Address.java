package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Address {

	private int pinCode; 
	private String street;
	private String city;
	private String state;
	private String country;
}
