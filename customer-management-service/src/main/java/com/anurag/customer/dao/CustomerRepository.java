package com.anurag.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.customer.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
