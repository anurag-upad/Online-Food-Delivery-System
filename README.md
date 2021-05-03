# OnlineFoodDeliverySystem
 Online food delivery back end system developed using Spring Boot, Spring Cloud, REST API, Kafka and PostgreSQL. There are 4 major microservices that work together and managed by Eureka Service Discovery : </br>
 
**Member Management Service**</br>
Register customer, save profile details, credit card information and delivery address information.

**Order Service**</br>
Order food by choosing different menu items and their quantity.</br>
Get valid payment information from Payment Microservice.</br>
Send Email to the customer about any order updates.

**Payment Service**</br>
Validate if customer's credit card information is valid or not. If yes, send the success status response as PAID.

**Restaurant Service**</br>
Manage all the restaurants and their food menu information such as registering a new restaurant or a food menu and 
finding a restaurant or their food menus.</br></br>

You can also use **Swagger UI console** to view/manage/consume the REST endpoints: </br>>
localhost:8080/swagger-ui.html
