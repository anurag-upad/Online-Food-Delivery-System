package com.anurag.restaurant.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.restaurant.domain.Order;
import com.anurag.restaurant.domain.OrderStatus;
import com.anurag.restaurant.service.RestaurantServiceKafka;

@Service
@Transactional
public class RestaurantServiceKafkaImpl implements RestaurantServiceKafka {
	
	private static final Logger log = LoggerFactory.getLogger(RestaurantServiceKafkaImpl.class);
	
	@Autowired
	private KafkaTemplate<String, Order> restaurantKafkaTemplate;
	
	public static final String TOPIC = "Topic_Order";

	@Override
	public String publishOrder(Order order) throws MessagingException {
		
		log.info("Sending the order completion update on the Kafka topic : " + TOPIC);
		
		//Kafka template will publish the message on to the Kafka Topic
		//from where it will be consumed by the Order's Kafka Listener 
		restaurantKafkaTemplate.send(TOPIC, order);
		
		return "Order has been prepared !!";
	}

	@KafkaListener(topics = TOPIC, groupId = "group_order", containerFactory = "restaurantKafkaListenerFactory")
	public void subscribeOrder(Order order) throws MessagingException {

		System.out.println("inside the listener : " + order.getRestaurantName() + order.getTotalPrice()
			+ order.getUserName() + order.getOrderStatus());

		if (order.getOrderStatus() == OrderStatus.PAID) {
			
			//mimicking order prepared time
			try {
				Thread.sleep(15 * 60 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			order.setOrderStatus(OrderStatus.FINISHED);
		}

		publishOrder(order);
		
		System.out.println("Order has been prepared : " + order);
	}

}
