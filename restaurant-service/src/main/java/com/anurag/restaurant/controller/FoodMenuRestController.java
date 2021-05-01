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
import com.anurag.restaurant.service.FoodMenuService;

@RestController
@RequestMapping("/foodMenu")
public class FoodMenuRestController {
	
	@Autowired
	private FoodMenuService foodMenuService;


	@GetMapping("/{restaurantId}")
	public List<FoodMenu> restaurantFoodMenus(@PathVariable Long restaurantId) {
		
		if(restaurantId == null)
			throw new IllegalArgumentException("Restaurant Id is invalid.");
		
		return foodMenuService.getFoodMenusByRestaurantId(restaurantId);
	}

	@GetMapping("/{foodMenuId}")
	public  FoodMenu foodMenu(@PathVariable Long foodMenuId) {
		
		if(foodMenuId == null)
			throw new IllegalArgumentException("FoodMenu Id is invalid.");
		
		return foodMenuService.getFoodMenuById(foodMenuId);
	}

	@PostMapping("/upload")
	public Long uploadFoodMenu(@RequestBody @Valid FoodMenu foodMenu) {
		
		//save Food Menu after validating the input @Valid
		Long foodMenuId= foodMenuService.saveFoodMenu(foodMenu);
		return foodMenuId;
	}

}
