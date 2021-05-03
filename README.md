# Online Food Delivery System
**Online food delivery** back end system developed using **Spring Boot, Spring Cloud, REST API, Kafka and PostgreSQL**. There are **4 major microservices** that work together and managed by **Eureka Service Discovery** : </br><br/>

**Service Discovery**</br>
* All 4 microservices register themselves with Eureka Server acting as a Service Discovery and will communicate with each other using service name rather than the hostname and port number.</br></br>

**API Gateway**</br>
* Defined an API Gateway which will intercept all the HTTP requests from the client and route them to the appropriate microservice using the request's URL pattern</br>
* Port of API Gateway defined is 9000. So all the REST endpoints defined below can be accessed using API Gateway's port number. Just replace the port number with 9000.

**Order Service**</br>
* Order food by choosing different menu items and their quantity.</br>
* Get valid payment information from Payment Microservice.</br>
* Send Email to the customer about any order updates.<br/>
* Its REST endpoints are :<br/>
Method&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Path&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Description</br>
POST&nbsp; &nbsp; &nbsp; 	       http://localhost:9001/order/create&nbsp; &nbsp; &nbsp; &nbsp; 	                 		Create a new order</br>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	       	   http://localhost:9001/order/{restaurantId}&nbsp; &nbsp; &nbsp; &nbsp;                    Get all orders for a restaurant</br>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	           http://localhost:9001/order/{userId}/orders	&nbsp; &nbsp; &nbsp; &nbsp;  	 	 		Get all orders for a customer</br>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	           http://localhost:9001/order/{orderId}	&nbsp; &nbsp; &nbsp; &nbsp;  	         		Get an order by order id</br>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	           http://localhost:9001/order/restaurant/{restaurantId}	&nbsp; &nbsp; &nbsp; &nbsp;  	Get restaurant's information</br><br/>

**Restaurant Service**</br>
* Manage all the restaurants and their food menu information such as registering a new restaurant or a food menu and 
finding a restaurant or their food menus.</br>
* Its REST endpoints are :<br/>
Method&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Path&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Description</br>
POST&nbsp; &nbsp; &nbsp; 	       http://localhost:9002/restaurant/create&nbsp; &nbsp; &nbsp; &nbsp; 	                     Upload new restaurant and its information</br>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	           http://localhost:9002/restaurant/all&nbsp; &nbsp; &nbsp; &nbsp;                     		 Get all restaurants information</br>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	           http://localhost:9002/restaurant/{restaurantId}&nbsp; &nbsp; &nbsp; &nbsp; 	 	 		 Get restaurant by restaurant Id</br>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	           http://localhost:9002/restaurant/{restaurantId}/menu&nbsp; &nbsp; &nbsp; &nbsp; 	 	 	 Get restaurant's FoodMenu by restaurant Id</br>
POST&nbsp; &nbsp; &nbsp; 	       http://localhost:9002/restaurant/foodMenu&nbsp; &nbsp; &nbsp; &nbsp; 	                 Upload a restaurant's FoodMenu</br>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	           http://localhost:9002/{restaurantId}/foodMenu&nbsp; &nbsp; &nbsp; &nbsp;                  Get a restaurant's FoodMenu by restaurant Id</br>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	           http://localhost:9002/restaurant/{foodMenuId}&nbsp; &nbsp; &nbsp; &nbsp; 	 	 		 Get a restaurant's FoodMenu by food menu Id</br></br>

**Customer Management Service**</br>
* Register customer, save profile details, credit card information and delivery address information.<br/>
* Its REST endpoints are :<br/> 
Method&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Path&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Description</br>
POST&nbsp; &nbsp; &nbsp; 	      http://localhost:9003/customer/signup&nbsp; &nbsp; &nbsp; &nbsp;                   Register new customer's profile, address & payment info <br/>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	       http://localhost:9003/customer/checkCard/{customerId}&nbsp; &nbsp; &nbsp; &nbsp;   Get customer's credit card info<br/>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	       http://localhost:9003/customer/all&nbsp; &nbsp; &nbsp; &nbsp;  	 				             Get all registered customers<br/>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	       http://localhost:9003/customer/{id}	&nbsp; &nbsp; &nbsp; &nbsp;  	 			         Get customer by customer id<br/><br/>
POST&nbsp; &nbsp; &nbsp; 	      http://localhost:9003/address/save	 &nbsp; &nbsp; &nbsp; &nbsp;                 	  Save a customer's address<br/>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	       http://localhost:9003/address/all&nbsp; &nbsp; &nbsp; &nbsp;                			    Get all the addresses<br/>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	       http://localhost:9003/address/{id}	 &nbsp; &nbsp; &nbsp; &nbsp; 	 				             Get an address by address id<br/><br/>


**Payment Service**</br>
* Validate if customer's credit card information is valid or not. If yes, send the success status response as PAID.</br>
* Using **Hystrix** as circuit breaker, in case Payment fails for some reason for an order </br>
* Its REST endpoints are :<br/>
Method&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Path&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Description</br>
POST&nbsp; &nbsp; &nbsp; 	         http://localhost:9004/payment/save&nbsp; &nbsp; &nbsp; &nbsp;                        	Update Customer's payment status to Paid</br>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	       	     http://localhost:9004/payment/all &nbsp; &nbsp; &nbsp; &nbsp;         				Get all payments</br>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	       	     http://localhost:9004/payment/{paymentId} &nbsp; &nbsp; &nbsp; &nbsp; 	 	 		Get payment by payment id</br>
GET&nbsp; &nbsp; &nbsp; &nbsp; 	       	     http://localhost:9004/payment/{orderId} &nbsp; &nbsp; &nbsp; &nbsp; 	 	 			Get Payment History by order id</br></br>



You can also use **Swagger UI console** to view/manage/consume the individual microservice's REST endpoints: </br>
**localhost:900X/swagger-ui.html** where X in the Port number can be 1,2,3,4 based on the services defined above.
