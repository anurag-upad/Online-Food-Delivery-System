package com.anurag.customer.service;

import java.util.List;

import com.anurag.customer.domain.Address;

public interface AddressService {

	public void saveAddress(Address address);
	
	public List<Address> getAllAddresses();
	
	public Address getAddressById(Long id);
	
}
