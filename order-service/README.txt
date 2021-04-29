/************  System Feature  *****************/

Order food by choosing different menu items and their quantity
Get valid payment information from Payment Microservice 
Send Email to the customer about any order updates

/************  API Overview Order Microservice  *****************/

Method	              Path	                                                       Description
POST	       http://localhost:9001/api/order	                 		 Create a new order
GET	       http://localhost:9001/api/order/{restaurantId}                    Get all orders for a restaurant
GET	       http://localhost:9001/api/{userId}/orders	 	 	 Get all orders for a customer
GET	       http://localhost:9001/api/order/{orderId}	 	         Get an order by order id
GET	       http://localhost:9001/api/order/restaurant/{restaurantId}	 Get restaurant's information