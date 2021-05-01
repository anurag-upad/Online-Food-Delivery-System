package com.anurag.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.customer.domain.Address;
import com.anurag.customer.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressRestController {

	@Autowired
	AddressService addressService;

	@PostMapping("/save")
	public void saveAddress(@RequestBody Address address) {
		addressService.saveAddress(address);
	}

	@GetMapping("/all")
	public List<Address> findAllAddresses() {
		return addressService.getAllAddresses();
	}

	@GetMapping("/{id}")
	public Address addressById(@PathVariable Long id) {
		return addressService.getAddressById(id);
	}
	
}
