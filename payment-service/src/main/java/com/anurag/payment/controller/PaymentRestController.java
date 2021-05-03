package com.anurag.payment.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.payment.domain.CreditCard;
import com.anurag.payment.domain.OrderStatus;
import com.anurag.payment.domain.Payment;
import com.anurag.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {

	@Autowired
	PaymentService paymentService;


	@HystrixCommand(fallbackMethod = "failureMakePayment")
	@PostMapping("/save")
	public ResponseEntity<?> payment(@RequestBody Payment payment) {

		try {
			//System.out.println("Customer id of payer : " + payment.getCustomerId());
			CreditCard creditCard=paymentService.getCrediCardDetails(payment.getCustomerId());

			if(creditCard == null)
				return new ResponseEntity<String>("Something went wrong, customer not found or doesn't have credit card", 
						HttpStatus.BAD_REQUEST);

			if (isCreditCardValid(creditCard)) {

				LocalDateTime paymentTime = LocalDateTime.now();
				payment.setPaymentTime(paymentTime);
				payment.setOrderStatus(OrderStatus.PAID);
				paymentService.save(payment);
				
				return new ResponseEntity<Payment>(payment, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("You card has expired. Please provide another card.", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong. Payment was unsuccessful. Please try again.", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> failureMakePayment() {
		return new ResponseEntity<String>("Customer service is temporarily unavailable", HttpStatus.BAD_REQUEST);
	}

	public boolean isCreditCardValid(CreditCard creditCard) {
		LocalDate today = LocalDate.now();
		int expMonth = Integer.parseInt(creditCard.getExpiryMonth());
		int expYear = Integer.parseInt(creditCard.getExpiryYear());
		int todayMonth = today.getMonthValue();
		int todayYear = today.getYear();

		if (expYear >= todayYear && expMonth >= todayMonth) {
			return true;
		}

		return false;
	}

	@GetMapping("/all")
	public List<Payment> findAll() {
		return paymentService.findAll();
	}

	@GetMapping("/{id}")
	public Payment findOne(@PathVariable Long id) {
		return paymentService.getPaymentById(id);
	}
}
