package com.anurag.restaurant.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FoodItem {

	private Long id;
	private Long foodMenuId;
	private String foodName;
	private BigDecimal foodPrice;
	private int quantity;

}
