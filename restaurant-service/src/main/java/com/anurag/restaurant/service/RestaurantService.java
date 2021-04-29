package com.anurag.restaurant.service;

import java.util.List;

import com.anurag.restaurant.domain.FoodMenu;
import com.anurag.restaurant.domain.Restaurant;

public interface RestaurantService {
	
	public Long saveRestaurant(Restaurant restaurant);
	
	public List<Restaurant> getAllRestaurants();
	
	public Restaurant getRestaurantById(Long id);
	
	public List<FoodMenu> getFoodMenusByRestaurantId(Long restaurantId);
	
}
