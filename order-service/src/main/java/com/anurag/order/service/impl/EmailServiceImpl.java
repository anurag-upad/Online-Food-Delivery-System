package com.anurag.order.service.impl;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.order.domain.Order;
import com.anurag.order.service.EmailService;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendOrderReceivedMail(final String recipientName, final String recipientEmail, Order order) 
			throws MessagingException {

		SimpleMailMessage message = setCommonAttributes(recipientEmail);
		message.setText(String.format("Hello %d, your Order is successfully placed !! Your order id is %d ", 
				recipientName, order.getId()));

		this.mailSender.send(message);
	}

	@Override
	public void sendOrderCompletedMail(final String recipientName, final String recipientEmail, Order order) 
			throws MessagingException {

		SimpleMailMessage message = setCommonAttributes(recipientEmail);
		message.setText(String.format("Hello %d, your Order with order id : %d is complete. Kindly collect your order.", 
				recipientName, order.getId()));

		this.mailSender.send(message);
	}

	private SimpleMailMessage setCommonAttributes(final String recipientEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("anurag.upadhyay89@gmail.com");
		message.setTo(recipientEmail);
		message.setSubject("Order Details");
		return message;
	}

}
