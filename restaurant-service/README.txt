/************  System Feature  *****************/

Manage all the restaurants and their food menu information such as registering a new restaurant or a food menu and 
finding a restaurant or their food menus.

/************  API Overview Restaurant Microservice  *****************/

Method	              Path	                                                       Description
POST	       http://localhost:9002/restaurant/create	                     Upload new restaurant and its information
GET	           http://localhost:9002/restaurant/all                    		 Get all restaurants information
GET	           http://localhost:9002/restaurant/{restaurantId}	 	 		 Get restaurant by restaurant Id
GET	           http://localhost:9002/restaurant/{restaurantId}/menu	 	 	 Get restaurant's FoodMenu by restaurant Id

POST	       http://localhost:9002/restaurant/foodMenu	                 Upload a restaurant's FoodMenu
GET	           http://localhost:9002/{restaurantId}/foodMenu                 Get a restaurant's FoodMenu by restaurant Id
GET	           http://localhost:9002/restaurant/{foodMenuId}	 	 		 Get a restaurant's FoodMenu by food menu Id