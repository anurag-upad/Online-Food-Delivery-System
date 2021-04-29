package com.anurag.restaurant.service;

import java.util.List;

import com.anurag.restaurant.domain.FoodMenu;

public interface FoodMenuService {
	
	public Long saveFoodMenu(FoodMenu foodMenu);
	
	public List<FoodMenu> getFoodMenusByRestaurantId();
	
	public FoodMenu getFoodMenuById(Long id);
	
	public List<FoodMenu> getFoodMenusByRestaurantId(Long restaurantId);
	
}
