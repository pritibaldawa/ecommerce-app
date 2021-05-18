package com.example.demo.services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartRequest {

	private String userId;
	private String productId;
	private Integer qty;
}
