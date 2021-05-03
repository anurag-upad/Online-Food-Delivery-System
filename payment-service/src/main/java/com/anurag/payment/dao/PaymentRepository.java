package com.anurag.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.payment.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
