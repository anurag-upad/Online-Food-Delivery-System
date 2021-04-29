package com.anurag.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.restaurant.dao.RestaurantRepository;
import com.anurag.restaurant.domain.FoodMenu;
import com.anurag.restaurant.domain.Restaurant;
import com.anurag.restaurant.service.RestaurantService;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;

    public Long saveRestaurant(Restaurant restaurant) {  		
    	return restaurantRepository.save(restaurant).getId();
	}
    
	public List<Restaurant> getAllRestaurants() {
		return (List<Restaurant>)restaurantRepository.findAll();
	}

	public Restaurant getRestaurantById(Long id) {
		return restaurantRepository.findById(id).orElse(new Restaurant());
	}
	
	public List<FoodMenu> getFoodMenusByRestaurantId(Long restaurantId){
		return restaurantRepository.findFoodMenusByRestaurantId(restaurantId);
	}

}