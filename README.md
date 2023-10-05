# springboot3-consumingRestAPI-by-restClient-demo
WebClient is the replacement for RestTemplate supporting both synchronous and asynchronous calls. 
It is part of the Spring Web Reactive project. Now Spring 6.1 M1 version presents RestClient. 
A new synchronous http client which works in a similar way to WebClient, using the same infrastructure as RestTemplate.

- Why to use? 
As you can see this new API is easier to manage than the old RestTemplate.
It also avoids adding the reactive web libraries in case your project only uses the WebClient API.

- "product-crud-api" is producer, and "springboot-3.2-rest-client" is consumer,
where we are consuming rest api via restclient.

# How to use this sample programs from github?
- Start the "product-crud-api" first so that producer must run in localhost:9090. 
- Do not forget to create database schema with name "test" in mysql.(as given in application.properties file)
- Now start "springboot-3.2-rest-client" consumer, and fetch that producer in port 8080 where consumer is running: <br>
   For POST : http://localhost:8080/product-client/products <br>
   For GET : http://localhost:8080/product-client/products <br>
   For GET by id : http://localhost:8080/product-client/products/1 <br>
   For PUT : http://localhost:8080/product-client/products/1 <br>
   For DELETE : http://localhost:8080/product-client/products/1 <br>


# Source to learn :
- https://spring.io/blog/2023/07/13/new-in-spring-6-1-restclient
- https://dev.to/noelopez/new-restclient-in-spring-61-10ac 
