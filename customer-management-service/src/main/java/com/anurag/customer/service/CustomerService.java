package com.anurag.customer.service;

import java.util.List;

import com.anurag.customer.domain.Customer;

public interface CustomerService {
	
	public void saveCustomer(Customer customer);
	
	public List<Customer> findAll();
	
	public Customer getCustomerById(Long id);

}