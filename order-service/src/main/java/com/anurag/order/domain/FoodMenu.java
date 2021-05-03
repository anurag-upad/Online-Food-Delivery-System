package com.anurag.order.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FoodMenu {

	private Long id;
	private String foodName;
	private String foodDescription;
	private String foodCatalog;
	private BigDecimal foodPrice;
	private Long restaurantId;

}
