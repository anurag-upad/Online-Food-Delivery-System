package com.anurag.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.customer.domain.Address;
import com.anurag.customer.domain.CreditCard;
import com.anurag.customer.domain.Customer;
import com.anurag.customer.dto.CustomerDTO;
import com.anurag.customer.service.AddressService;
import com.anurag.customer.service.CreditCardService;
import com.anurag.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;

	@Autowired
	AddressService addressService;

	@Autowired
	CreditCardService creditCardService;

	@PostMapping("/signup")
	public void registerCustomer(@Valid @RequestBody CustomerDTO customerData) {

		Address address = customerData.getAddress();
		addressService.saveAddress(address);

		Customer customer = customerData.getCustomer();
		customer.setAddress(address);
		customerService.saveCustomer(customerData.getCustomer());

		CreditCard creditCard = customerData.getCreditCard();
		creditCard.setCardHolder(customer);
		creditCardService.saveCreditCard(creditCard);
		
	}
	
	@GetMapping("/checkCard/{customerId}")
    public CreditCard findCreditCard(@PathVariable Long customerId) {
		
		if(customerId == null)
			throw new IllegalArgumentException("Customer Id is invalid.");
		
        return creditCardService.getCreditCardByCustomerId(customerId);
    }

	@GetMapping("/all")
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/{id}")
	public Customer customer(@PathVariable Long id) {
		
		if(id == null)
			throw new IllegalArgumentException("Customer Id is invalid.");
		
		return customerService.getCustomerById(id);
	}

}
