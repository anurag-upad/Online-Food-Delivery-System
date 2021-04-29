/************  System Feature  *****************/

Manage all the restaurants and their food menu information such as registering a new restaurant or a food menu and finding restaurant or their food menus

/************  API Overview Restaurant Microservice  *****************/

Method	              Path	                                                       Description
POST	       http://localhost:9002/api/restaurant	                         Upload new restaurant and its information
GET	       http://localhost:9002/api/restaurant/all                    	 Get all restaurants information
GET	       http://localhost:9002/api/restaurant/{restaurantId}	 	 Get restaurant by restaurant Id
GET	       http://localhost:9002/api/restaurant/{restaurantId}/menu	 	 Get restaurant's FoodMenu by restaurant Id

POST	       http://localhost:9002/api/restaurant/foodMenu	                 Upload a restaurant's FoodMenu
GET	       http://localhost:9002/api/{restaurantId}/foodMenu                 Get a restaurant's FoodMenu by restaurant Id
GET	       http://localhost:9002/api/restaurant/{foodMenuId}	 	 Get a restaurant's FoodMenu by food menu Id