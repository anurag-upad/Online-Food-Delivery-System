package com.anurag.payment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anurag.payment.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	
	@Query("from Payment p where p.orderId = ?1 ")
	List<Payment> findPaymentHistoryByOrderId(Long orderId);

}
