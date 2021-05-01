package com.anurag.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.customer.dao.CreditCardRepository;
import com.anurag.customer.domain.CreditCard;
import com.anurag.customer.service.CreditCardService;

@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService {
	
	@Autowired
	private CreditCardRepository crediCardRepository;

	@Override
	public CreditCard getCreditCardByCustomerId(Long customerId) {
		return crediCardRepository.findCrediCardByCustomerId(customerId);
	}

	@Override
	public void saveCreditCard(CreditCard creditCard) {
		crediCardRepository.save(creditCard);
	}

	@Override
	public List<CreditCard> findAll() {
		return crediCardRepository.findAll();
	}

	@Override
	public CreditCard getCreditCardById(Long id) {
		return crediCardRepository.findById(id).get();
	}

}
