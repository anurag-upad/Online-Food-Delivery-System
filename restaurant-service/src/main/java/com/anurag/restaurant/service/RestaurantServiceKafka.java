package com.anurag.restaurant.service;

import org.springframework.messaging.MessagingException;

import com.anurag.restaurant.domain.Order;

public interface RestaurantServiceKafka {

	public String publishOrder(Order order) throws MessagingException;

	public void subscribeOrder(Order order) throws MessagingException;

}
