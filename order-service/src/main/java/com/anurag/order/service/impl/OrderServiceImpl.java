package com.anurag.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.order.dao.OrderRepository;
import com.anurag.order.domain.Order;
import com.anurag.order.service.OrderService;

@Service
@Transactional 
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

    public void saveOrder(Order order) {
    	orderRepository.save(order);
	}
    
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order getOrderByOrderId(Long id) {
		return orderRepository.findById(id).orElse(new Order());
	}
	
	public List<Order> getOrdersByUserId(Long id) {
		return orderRepository.findByUserId(id);
	}
	
	public List<Order> getAllOrdersByRestaurantId(Long restaurantId){

		List<Order> orders = orderRepository.findByRestaurantId(restaurantId);
		//populate all since LAZY load
		orders.get(0).getFoodItems().get(0);
		
		return orders;
	}
	
	

}