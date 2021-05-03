package com.anurag.order.service.impl;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.order.domain.Order;
import com.anurag.order.listener.OrderStatusUpdateListener;
import com.anurag.order.service.OrderServiceKafka;

@Service
@Transactional
public class OrderServiceKafkaImpl implements OrderServiceKafka {
	
	private static final Logger log = LoggerFactory.getLogger(OrderServiceKafkaImpl.class);
	
	@Autowired
	private KafkaTemplate<String, Order> orderKafkaTemplate;
	
	@Autowired
	private OrderStatusUpdateListener orderStatusUpdateListener;
	
	public static final String TOPIC = "Topic_Order";

	
	@Override
	public void publishOrder(Order order) throws MessagingException {
		
		log.info("Sending the order request on the Kafka topic : " + TOPIC);
		
		//Kafka template will publish the message on to the Kafka Topic
		//from where it will be consumed by the Restaurant's consumer API 
		orderKafkaTemplate.send(TOPIC, order);
		
		//Send an email to customer with his order details
		orderStatusUpdateListener.listenOrderStatusMessage(order);
		
	}
	
	@KafkaListener(topics = TOPIC, groupId = "group_order", containerFactory = "orderKafkaListenerFactory")
    public void subscribeOrder(Order order) throws MessagingException {
		
		//Kafka Listener will consume the message from the Kafka Topic
		orderStatusUpdateListener.listenOrderStatusMessage(order);
        System.out.println("Consumed Order : " + order);
    }

}
