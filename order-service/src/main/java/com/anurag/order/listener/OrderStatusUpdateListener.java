package com.anurag.order.listener;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.anurag.order.domain.Customer;
import com.anurag.order.domain.Order;
import com.anurag.order.domain.OrderStatus;
import com.anurag.order.service.EmailService;

@Component
public class OrderStatusUpdateListener {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${customer.microservice.url}")
	private String customerManagementUrl;


	public void listenOrderStatusMessage(Order order) throws MessagingException {

		System.out.println("inside the listener ............." + order.getRestaurantName() + order.getTotalPrice() + order.getUserId());
		
		Customer customer = restTemplate.getForObject(customerManagementUrl + order.getUserId(), Customer.class);
		
		if (order.getOrderStatus() == OrderStatus.FINISHED) {
			emailService.sendOrderCompletedMail(customer.getFirstName(), customer.getEmail(), order);
		}else {
			emailService.sendOrderReceivedMail(customer.getFirstName(), customer.getEmail(), order);
		}

		System.out.println("The Email is on the WAY!!!");
	}

}
