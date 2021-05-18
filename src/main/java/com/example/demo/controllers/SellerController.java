package com.example.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.SellerAlreadyExistsException;
import com.example.demo.manager.UsersManager;
import com.example.demo.model.Product;
import com.example.demo.model.Seller;
import com.example.demo.services.SellerService;
import com.example.demo.services.dto.ProductRequest;
import com.example.demo.services.dto.SellerRequest;
import com.example.demo.services.dto.SellerResponse;

@RestController
@RequestMapping("/api")
public class SellerController {

	private SellerService sellerService;
	private UsersManager userManager;

	@Autowired
	public Map<String, Seller> sellers;

	@Autowired
	private ModelMapper modelMapper;

	public SellerController(SellerService sellerService, UsersManager userManager) {
		this.sellerService = sellerService;
		this.userManager = userManager;
	}

	@PostMapping(value = "/seller/product")
	public ResponseEntity<String> createProduct(@RequestBody ProductRequest prodRequest) {
		String name = sellerService
				.createProduct(prodRequest.getId(), prodRequest.getName(), prodRequest.getPrice(),
						prodRequest.getProductCategory(), prodRequest.getStockAvailable(), prodRequest.getSellerId())
				.getName();
		return ResponseEntity.ok("New product " + name + " added successfully");
	}

	@GetMapping(value = "/seller/product")
	public ResponseEntity<List<Product>> getProductsFromSeller(@RequestParam(required = true) String sellerId) {
		Seller seller = userManager.getSeller(sellerId);
		return ResponseEntity.ok(seller.getProducts());
	}

	@GetMapping("/seller")
	public ResponseEntity<List<SellerResponse>> getSellers() {
		return ResponseEntity.ok(userManager.sellers.values().stream()
				.map(i -> modelMapper.map(i, SellerResponse.class)).collect(Collectors.toList()));
	}

	@PostMapping("/seller")
	public ResponseEntity<Seller> addSeller(@RequestBody SellerRequest sellerRequest) {
		Seller seller = new Seller(sellerRequest.getSellerId(), sellerRequest.getAccDetails());
		if (sellers.containsKey(sellerRequest.getSellerId()))
			throw new SellerAlreadyExistsException();
		userManager.sellers.put(sellerRequest.getSellerId(), seller);
		return ResponseEntity.ok(seller);
	}

}
