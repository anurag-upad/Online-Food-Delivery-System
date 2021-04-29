package com.anurag.restaurant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anurag.restaurant.domain.FoodMenu;

public interface FoodMenuRepository extends JpaRepository<FoodMenu, Long>{
	
	@Query("From FoodMenu fm where fm.restaurant.id = ?1")
	List<FoodMenu> findAllMenuByResturantID(Long restaurantId);

}
