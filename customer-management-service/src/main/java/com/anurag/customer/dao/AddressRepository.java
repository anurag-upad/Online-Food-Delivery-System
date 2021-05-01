package com.anurag.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.customer.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
	}
