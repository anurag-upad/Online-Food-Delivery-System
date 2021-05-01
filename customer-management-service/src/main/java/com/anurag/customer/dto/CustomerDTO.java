package com.anurag.customer.dto;

import com.anurag.customer.domain.Address;
import com.anurag.customer.domain.CreditCard;
import com.anurag.customer.domain.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
	
	private Customer customer;
	private Address address;
	private CreditCard creditCard;

}
