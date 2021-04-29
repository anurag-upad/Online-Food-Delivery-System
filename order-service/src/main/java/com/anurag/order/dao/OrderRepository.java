package com.anurag.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anurag.order.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	@Query("From Order o where o.userId = ?1")
	List<Order> findByUserId(Long userId);

	@Query("From Order o where o.restaurantId = ?1")
	List<Order> findByRestaurantId(Long restaurantId);

}
