package com.anurag.payment.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_id")
	private Long id;
	
	private Long orderId;
	
	private Long customerId;
	
	@Column(name = "order_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime paymentTime = LocalDateTime.now();
	
	private BigDecimal totalPrice;

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

}
