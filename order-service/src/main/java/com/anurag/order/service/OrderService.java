package com.anurag.order.service;

import java.util.List;

import com.anurag.order.domain.Order;
import com.anurag.order.domain.Payment;

public interface OrderService {
	
	public void saveOrder(Order order);
	
	public List<Order> findAll();
	
	public Order getOrderByOrderId(Long id);
	
	public List<Order> getOrdersByUserId(Long userId);
	
	public List<Order> getAllOrdersByRestaurantId(Long restaurantId);
	
	public Payment getPaymentResponse(Order order);
	
}
