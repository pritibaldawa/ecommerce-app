package com.example.demo.services.dto;

import com.example.demo.model.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class SellerRequest {

	private String sellerId;
	private Account accDetails;
	
}
