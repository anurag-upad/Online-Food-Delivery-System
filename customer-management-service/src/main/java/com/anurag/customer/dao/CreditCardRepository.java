package com.anurag.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anurag.customer.domain.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{
	
	@Query("from CreditCard cc where cc.cardHolder.id = ?1")
	CreditCard findCrediCardByCustomerId(Long customerId);

}
