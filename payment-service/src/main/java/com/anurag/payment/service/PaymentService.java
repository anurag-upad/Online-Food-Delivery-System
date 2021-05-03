package com.anurag.payment.service;

import java.util.List;

import com.anurag.payment.domain.CreditCard;
import com.anurag.payment.domain.Payment;

public interface PaymentService {
	
	public void save(Payment payment);
	
	public List<Payment> findAll();
	
	public Payment getPaymentById(Long id);
	
	public CreditCard getCrediCardDetails(Long customerId);

	public List<Payment> getPaymentHistoryByOrderId(Long orderId);


}
