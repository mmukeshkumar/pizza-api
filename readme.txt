Building and running the tests:
---------------------------------
To build and run tests use this command:
gradlew clean test

Building and running the web app:
---------------------------------
Windows:
-----------
@ECHO OFF
set JAVA_HOME=C:\dev\java_installs\jdk-8u191
Set PATH=%JAVA_HOME%\bin;%PATH%
set JAVA_OPTS=-Xms3g -Xmx3g

gradlew clean build && java -jar build/libs/pizza-api-0.0.1-SNAPSHOT.jar

LINUX;
---------
#!/bin/bash -x
export JAVA_HOME=/usr/local/java_installs/jdk-8u191
export JAVA_PATH=$JAVA_HOME/bin
export PATH=$JAVA_PATH:$PATH
chmod +x grailsw
./gradlew clean build && java -jar build/libs/pizza-api-0.0.1-SNAPSHOT.jar

How to connect to the in-memory Database through browser to the see the tables and data: ?
--------------------------------------------------------------------------------
Step 1: Open URL : http://localhost:8080/h2
Step 2:
enter JDBC URL as: jdbc:h2:mem:pizzadb
username as sa
Password is empty string
Step 3: Click on Connect button

I have already added insert statements which run on startup and add some topping and inventory for the added toppings
You can check them out by running these URLs:
http://localhost:8080/v1/topping
http://localhost:8080/v1/inventory

ALL working REST URLS with curl examples:
-----------------------------------------------

Add a new order:
----------------

curl --header "Content-Type: application/json" \
--header "Accept: application/json" \
--request POST \
--data '{
   "customer":{
      "firstName":"Mukesh",
      "lastName":"Kumar",
      "emailId":"mukesh@compiletstatic.net",
      "phoneNumber":"818-518-6807"
   },
   "crustSize": "LARGE",
   "variety": "PEPPERONI",
   "cheese" : "AMERICAN",
   "extraCheese": true,
   "extraToppings": "MUSHROOM",
   "orderDate": "2019-01-06T08:00:00.000+0000"
}' \
http://localhost:8080/v1/order

{
  "totalPrice": 17.0,
  "variety": "PEPPERONI",
  "extraCheese": true,
  "crustSize": "LARGE",
  "cheese": "AMERICAN",
  "extraToppings": "MUSHROOM",
  "orderId": 4,
  "orderDate": "2019-01-06T08:00:00.000+0000",
  "customer": {
    "firstName": "Mukesh",
    "lastName": "Kumar",
    "phoneNumber": "818-518-6807",
    "customerId": 3
  }
}

curl --header "Content-Type: application/json" \
--header "Accept: application/json" \
--request POST \
--data '{
   "customer":{
      "firstName":"John",
      "lastName":"Kalstrom",
      "emailId":"john@gmail.com",
      "phoneNumber":"805-999-9999"
   },
   "crustSize": "MEDIUM",
   "variety": "MARGARITA_PIZZA",
   "cheese" : "AMERICAN",
   "extraCheese": true,
   "extraToppings": "MUSHROOM,CANADIAN_BACON",
   "orderDate": "2019-01-09T08:00:00.000+0000"
}' \
http://localhost:8080/v1/order
{
  "totalPrice": 24.5,
  "variety": "MARGARITA_PIZZA",
  "extraCheese": true,
  "crustSize": "MEDIUM",
  "cheese": "AMERICAN",
  "extraToppings": "MUSHROOM,CANADIAN_BACON",
  "promotionCode": null,
  "orderId": 6,
  "orderDate": 1547020800000,
  "customer": {
    "firstName": "John",
    "lastName": "Kalstrom",
    "phoneNumber": "805-999-9999",
    "emailId": "john@gmail.com",
    "customerId": 4
  }
}

List all orders:
------------------
http://localhost:8080/v1/order

Get specific order:
---------------------
http://localhost:8080/v1/order/2


Get all  availablepizza varieties:
------------------
http://localhost:8080/v1/variety
[
  "MARGARITA_PIZZA",
  "REGULAR_CHEESE_PIZZA",
  "PEPPERONI"
]

Get all available pizza sizes:
----------------------
http://localhost:8080/v1/crust_size
["SMALL","MEDIUM","LARGE"]

Get all available pizza sauces:
---------------------------------
http://localhost:8080/v1/sauce

[
  "CLASSIC_RED",
  "PESTO"
]


Get all available pizza cheeses:
---------------------------------
http://localhost:8080/v1/cheese

["AMERICAN","PROVOLONE","MOZZARELLA","CHEDDAR"]


Get all available pizza toppings:
----------------------------------
http://localhost:8080/v1/topping

[
  {
    "toppingId": 1000,
    "name": "SAN_MARZANO_TOMATO",
    "price": 2.5
  },
  {
    "toppingId": 2000,
    "name": "ROMA_TOMATO",
    "price": 2
  },
  {
    "toppingId": 3000,
    "name": "OLIVE_OIL",
    "price": 2
  },
  {
    "toppingId": 4000,
    "name": "PEPPERONI",
    "price": 2.5
  },
  {
    "toppingId": 5000,
    "name": "MUSHROOM",
    "price": 1.5
  }
]


Add a new topping:
--------------

curl --header "Content-Type: application/json" \
--header "Accept: application/json" \
--request POST \
--data '{"name": "BROCOLLI", "price": 1.50 }' \
http://localhost:8080/v1/topping
 
{"toppingId":2,"name":"BROCOLLI","price":1.5}
 
Get Topping by ID:
---------------------- 
  
http://localhost:8080/v1/topping/1

{"toppingId":1,"name":"PEPPERONI","price":10.0}


update topping:
-------------------------------

curl --header "Content-Type: application/json" \
--request PUT \
--data '{ "price": 50.00 }' \
http://localhost:8080/v1/topping/1000

{"toppingId":1000,"name":"SAN_MARZANO_TOMATO","price":50.0}

Add a new Inventory:
----------------

First add topping:
curl --header "Content-Type: application/json" \
--header "Accept: application/json" \
--request POST \
--data '{"name": "BROCOLLI", "price": 1.50 }' \
http://localhost:8080/v1/topping
 
{"toppingId":2,"name":"BROCOLLI","price":1.5}
 
 Then add Inventory for the topping:
 -------------------------------------

curl --header "Content-Type: application/json" \
--request POST \
--data '{"toppingId": 1, "quantity": 100 }' \
http://localhost:8080/v1/inventory

{"inventoryId":2,"quantity":100,"topping":{"toppingId":1,"name":"BROCOLLI","price":1.5},"toppingId":1,"version":0}


update inventory:
-------------------------------

curl --header "Content-Type: application/json" \
--request PUT \
--data '{ "quantity": 50 }' \
http://localhost:8080/v1/inventory/1000

{"inventoryId":1000,"quantity":50,"topping":{"toppingId":1000,"name":"SAN_MARZANO_TOMATO","price":2.5},"version":2}


Get all promotions:
------------------
http://localhost:8080/v1/promotion

[
  {
    "promotionId": 1000,
    "promotionCode": "10_PERCENT_OFF_DEAL",
    "expiryDate": "2020-01-01T08:00:00.000+0000",
    "dateCreated": "2019-01-06T08:00:00.000+0000",
    "percentageOff": 10
  },
  {
    "promotionId": 2000,
    "promotionCode": "SUPER_BOWL_DEAL",
    "expiryDate": "2020-01-01T08:00:00.000+0000",
    "dateCreated": "2019-01-06T08:00:00.000+0000",
    "percentageOff": 50
  }
]

Get PROMOTION by ID:
---------------------- 
http://localhost:8080/v1/promotion/1000
{
  "promotionId": 1000,
  "promotionCode": "10_PERCENT_OFF_DEAL",
  "expiryDate": "2020-01-01T08:00:00.000+0000",
  "dateCreated": "2019-01-06T08:00:00.000+0000",
  "percentageOff": 10
}

Add a new PROMOTION:
----------------
curl --header "Content-Type: application/json" \
--request POST \
--data '{"promotionCode":"SUNDAY_DEAL", "expiryDate":"2020-01-01T08:00:00.000+0000","dateCreated":"2019-01-06T08:00:00.000+0000","percentageOff":10}' \
http://localhost:8080/v1/promotion

{"promotionId":1,"promotionCode":"SUNDAY_DEAL","expiryDate":"2020-01-01T08:00:00.000+0000","dateCreated":"2019-01-06T08:00:00.000+0000","percentageOff":10}


