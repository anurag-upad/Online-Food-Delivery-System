package com.anurag.customer.service;

import java.util.List;

import com.anurag.customer.domain.CreditCard;

public interface CreditCardService {
	
	public CreditCard getCreditCardByCustomerId(Long customerId);
	
	public void saveCreditCard(CreditCard creditCard);
	
	public List<CreditCard> findAll();
	
	public CreditCard getCreditCardById(Long id);
	
}
