package com.anurag.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.customer.dao.AddressRepository;
import com.anurag.customer.domain.Address;
import com.anurag.customer.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void saveAddress(Address address) {
		addressRepository.save(address);
	}

	@Override
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	@Override
	public Address getAddressById(Long id) {
		return addressRepository.findById(id).get();
	}

}
