package com.anurag.restaurant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anurag.restaurant.domain.FoodMenu;
import com.anurag.restaurant.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	@Query("select r.foodMenu from Restaurant r  where r.id = ?1")
	List<FoodMenu> findFoodMenusByRestaurantId(Long restaurantId);

}
