/************  System Feature  *****************/

Register customer and save customer' profile and credit card information alongwith customer's delivery address information

/************  API Overview Customer Management Microservice  *****************/

Method	              Path	                                                       Description
POST	         http://localhost:9003/customer/signup                        	Register new customer's profile, address & payment info
GET	       	   http://localhost:9003/customer/checkCard/{customerId}          Get customer's credit card info
GET	       	   http://localhost:9003/customer/all	 	 						              Get all registered customers
GET	           http://localhost:9003/api/customer/{id}	 	 					          Get customer by customer id

POST	         http://localhost:9003/address/save	                 			      Save a customer's address
GET	       	   http://localhost:9003/address/all               					      Get all the addresses
GET	       	   http://localhost:9003/address/{id}	 	 						              Get an address by address id
