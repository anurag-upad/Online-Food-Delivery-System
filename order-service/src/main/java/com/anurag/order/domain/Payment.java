package com.anurag.order.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Payment {
	
	private long id;
	private long orderId;
	private long customerId;
	private LocalDateTime paymentTime = LocalDateTime.now();
	private double totalPrice;
	private OrderStatus orderStatus;

}
