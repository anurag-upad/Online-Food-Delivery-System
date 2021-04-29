package com.anurag.order.service;

import javax.mail.MessagingException;

import com.anurag.order.domain.Order;

public interface OrderServiceKafka {
	
	public void publishOrder(Order order) throws MessagingException;
	
	public void subscribeOrder(Order order) throws MessagingException;
	
}
