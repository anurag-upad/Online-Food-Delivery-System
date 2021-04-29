package com.anurag.order.service;

import javax.mail.MessagingException;

import com.anurag.order.domain.Order;

public interface EmailService {

	public void sendOrderReceivedMail(final String recipientName, final String recipientEmail, Order order) 
			throws MessagingException ;

	public void sendOrderCompletedMail(String recipientName, String recipientEmail, Order order) 
			throws MessagingException;

}