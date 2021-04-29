package com.anurag.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
		
	}
	
	/* Once order is payed send message to restaurant With order information and
	 * payment confirmation through Kafka topics
	 * 
	*/
}
