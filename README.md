# LLD - Ecommerce App

This is a sample Java-Spring Boot application/ Following key functionalities are covered as part of problem statement.

1. User can get all products and search products by filters (name and category)
2. Seller can add new products
3. User can add products to cart
4. User can place order and make payment

## How to Run 

This application is packaged as a war which has Tomcat8 embedded. You can run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you have JRE/JDK 1.8 or higher 
```
        java -jar  ecommerce-lld-1.0.jar
or
        mvnw spring-boot:run 
```


## API details

##### Get all products

##### Request

  curl --location --request GET 'http://localhost:8080/api/products'

##### Get all products by name

##### Request

  curl --location --request GET 'http://localhost:8080/api/products/name'


#####  Get all products by category

##### Request

  curl --location --request GET 'http://localhost:8080/api/products/cat/name'


#####  Get all sellers

##### Request

  curl --location --request GET 'http://localhost:8080/api/seller'
  
#####  Get all products by a particular seller

##### Request

  curl --location --request GET 'http://localhost:8080/api/seller?sellerId=111'

#####  Add product by a particular seller

##### Request

  curl --location --request POST 'http://localhost:8080/api/seller/product' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": "416",
    "name": "Chair",
    "productCategory": "FURNITURE",
    "price": 3999.0,
    "stockAvailable": 15,
    "sellerId":111
}'

#####  Add products to cart

##### Request

  curl --location --request POST 'http://localhost:8080/api/cart' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": 101,
    "productId": 123,
    "qty": 1
}'

#####  View shopping cart

##### Request

  curl --location --request GET 'http://localhost:8080/api/cart?userId=102' 

#####  Place order and make payment

##### Request

  curl --location --request POST 'http://localhost:8080/api/cart/order' \
--header 'Content-Type: application/json' \
--data-raw '101'

#####  View order history

##### Request

curl --location --request GET 'http://localhost:8080/api/orders?userId=101' \

