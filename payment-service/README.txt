/************  System Feature  *****************/

Validate if customer's credit card information is valid or not. If yes, send the success status response as PAID

/************  API Overview Payment Microservice  *****************/

Method	              Path	                                                       Description
POST	         http://localhost:9004/payment/save                       	Update Customer's payment status to Paid
GET	       	     http://localhost:9004/payment/all         					Get all payments
GET	       	     http://localhost:9004/payment/{paymentId} 	 	 			Get payment by payment id