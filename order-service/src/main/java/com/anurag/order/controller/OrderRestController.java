package com.anurag.order.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anurag.order.domain.Order;
import com.anurag.order.domain.OrderStatus;
import com.anurag.order.domain.Payment;
import com.anurag.order.domain.Restaurant;
import com.anurag.order.service.OrderService;
import com.anurag.order.service.OrderServiceKafka;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderServiceKafka orderServiceKafka;
	
	@Value("${restaurant.microservice.url}")
	private String restaurantServiceUrl;
	
	@Value("${payment.microservice.url}")
	private String paymentManagmentUrl;

	
	@PostMapping(value = "/create")
	public String placeOrder(@Valid @RequestBody Order order) throws MessagingException {
		
		//Create the order for the customer after validating the input @Valid
		orderService.saveOrder(order);
		
		//validate customer's payment by calling payment microservice
		Payment payment = new Payment();
		payment.setOrderId(order.getId());
		payment.setTotalPrice(order.getTotalPrice());
		payment.setCustomerId(order.getUserId());
		Payment paymentreturn = restTemplate.postForObject(paymentManagmentUrl, payment, Payment.class);
		
		if(paymentreturn.getOrderStatus()== OrderStatus.PAID) {
			order.setOrderStatus(OrderStatus.PAID);
			
			//payment is successful
			//now, publish the message on to the Kafka Topic using KafkaTemplate
			//from where it will be consumed by the Restaurant Microservice
			orderServiceKafka.publishOrder(order);
		}
		
		//return a dummy response to the customer
		return "Order has been placed successfully !!";
	}

	@GetMapping("/{restaurantId}")
	public List<Order> ordersByRestaurantId(@PathVariable Long restaurantId) {
		
		if(restaurantId == null)
			throw new IllegalArgumentException("Restaurant Id is invalid.");
		
		return orderService.getAllOrdersByRestaurantId(restaurantId);
	}
	
	@GetMapping("/{userId}/orders")
	public List<Order> ordersByUserID(@PathVariable Long userId) {
		
		if(userId == null)
			throw new IllegalArgumentException("User Id is invalid.");
		
		return orderService.getOrdersByUserId(userId);
	}

	@GetMapping("/{orderId}")
	public Order orderByOrderId(@PathVariable Long orderId) {
		
		if(orderId == null)
			throw new IllegalArgumentException("Order Id is invalid.");
		
		return orderService.getOrderByOrderId(orderId);
	}
	
	@GetMapping("/restaurant/{restaurantId}")
	public Restaurant restaurant(@PathVariable Long restaurantId) {
		
		//make a REST call to Restaurant Microservice through Service Discovery
		Restaurant restaurant = restTemplate.getForObject(restaurantServiceUrl + restaurantId, 
				Restaurant.class);
		return restaurant;
	}

}
