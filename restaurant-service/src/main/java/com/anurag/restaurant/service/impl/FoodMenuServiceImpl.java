package com.anurag.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.restaurant.dao.FoodMenuRepository;
import com.anurag.restaurant.domain.FoodMenu;
import com.anurag.restaurant.service.FoodMenuService;

@Service
@Transactional
public class FoodMenuServiceImpl implements FoodMenuService {
	
	@Autowired
	private FoodMenuRepository foodMenuRepository;

	public Long saveFoodMenu(FoodMenu foodMenu) {
		return foodMenuRepository.save(foodMenu).getId();
	}

	public List<FoodMenu> getFoodMenusByRestaurantId() {
		return (List<FoodMenu>) foodMenuRepository.findAll();
	}

	public FoodMenu getFoodMenuById(Long id) {
		return foodMenuRepository.findById(id).orElse(new FoodMenu());
	}

	public List<FoodMenu> getFoodMenusByRestaurantId(Long restaurantId) {
		return foodMenuRepository.findAllMenuByResturantID(restaurantId);
	}

}