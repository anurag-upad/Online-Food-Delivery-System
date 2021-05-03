package com.anurag.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.anurag.order.dao.OrderRepository;
import com.anurag.order.domain.Order;
import com.anurag.order.domain.Payment;
import com.anurag.order.service.OrderService;

@Service
@Transactional 
public class OrderServiceImpl implements OrderService{
	
	@Value("${payment.microservice.url}")
	private String paymentManagmentUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Override
    public void saveOrder(Order order) {
    	orderRepository.save(order);
	}
    
    @Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	
	@Override
	public Order getOrderByOrderId(Long id) {
		return orderRepository.findById(id).orElse(new Order());
	}
	
	@Override
	public List<Order> getOrdersByUserId(Long id) {
		return orderRepository.findByUserId(id);
	}
	
	@Override
	public List<Order> getAllOrdersByRestaurantId(Long restaurantId){

		List<Order> orders = orderRepository.findByRestaurantId(restaurantId);
		//populate all since LAZY load
		orders.get(0).getFoodItems().get(0);
		
		return orders;
	}

	@Override
	public Payment getPaymentResponse(Order order) {
		
		Payment payment = new Payment();
		payment.setOrderId(order.getId());
		payment.setTotalPrice(order.getTotalPrice());
		payment.setCustomerId(order.getUserId());
		
		//make a REST call to Payment microservice with the order details for payment processing and validation
		Payment paymentresponse = restTemplate.postForObject(paymentManagmentUrl, payment, Payment.class);
		return paymentresponse;
	}
	
	

}