package com.anurag.payment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.anurag.payment.dao.PaymentRepository;
import com.anurag.payment.domain.CreditCard;
import com.anurag.payment.domain.Payment;
import com.anurag.payment.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Value("customer.managment.validate.cc")
	private String customerCrediCardUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public void save(Payment payment) {
		paymentRepository.save(payment);
	}

	@Override
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentRepository.findById(id).get();
	}

	@Override
	public CreditCard getCrediCardDetails(Long customerId) {
		CreditCard crediCard=restTemplate.getForObject(customerCrediCardUrl + customerId, CreditCard.class);
		return crediCard;
	}

}
