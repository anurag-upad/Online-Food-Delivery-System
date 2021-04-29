package com.anurag.order.domain;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Restaurant {

	private Long Id;
	private String restaurantName;
	private String restaurantCatalog;
	private List<FoodMenu> foodMenu;

}
