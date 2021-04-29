package com.anurag.restaurant.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {

	private Long id;
	private Long userName;
	private Long restaurantId;
	private String restaurantName;
	private LocalDateTime orderTime = LocalDateTime.now();
	private OrderStatus orderStatus = OrderStatus.CREATED;
	private double totalPrice;
	private List<FoodItem> foodItem;

}
