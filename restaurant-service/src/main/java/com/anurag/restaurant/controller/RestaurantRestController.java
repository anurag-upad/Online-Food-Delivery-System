package com.anurag.restaurant.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.restaurant.domain.FoodMenu;
import com.anurag.restaurant.domain.Restaurant;
import com.anurag.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantRestController {

	@Autowired
	private RestaurantService restaurantService;
	
	
	@PostMapping("/create")
	public Long uploadNewRestaurant(@Valid @RequestBody Restaurant restaurant) {
		
		//save Restaurant and its info after validating input @Valid
		Long restaurantId = restaurantService.saveRestaurant(restaurant);
		return restaurantId;
	}

	@GetMapping("/{restaurantId}")
	public Restaurant restaurant(@PathVariable Long restaurantId) {
		
		if(restaurantId == null)
			throw new IllegalArgumentException("Restaurant Id is invalid.");
		
		return restaurantService.getRestaurantById(restaurantId);
	}
	
	@GetMapping("/all")
	public List<Restaurant> restaurantsListing() {
		return restaurantService.getAllRestaurants();
	}

	@GetMapping(value = "/{restaurantId}/menu")
    public List<FoodMenu> showFoodMenu(@PathVariable Long restaurantId) {
		
		if(restaurantId == null)
			throw new IllegalArgumentException("Restaurant Id is invalid.");
		
        return restaurantService.getFoodMenusByRestaurantId(restaurantId);
    }

}
