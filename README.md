# myRetail RESTful product service

API to return product name and pricing.

Url should contain product id as a number:
```
/products/{id}
```
Product name is retrieved from another service.  Pricing is stored in a NoSQL data store (MongoDB):
```groovy
{"productName":"The Big Lebowski (Blu-ray)","productPrice":{"value":18.99,"currency":"USD"}}
```
Pricing can be updated by using an HTTP PUT to the same url, with a request body containing json similar to what's returned from the HTTP GET
API is a Spring Boot application built using Gradle.  Can be run using java:
```java
java -jar <projectdir>/build/libs/myRetail-0.0.1-SNAPSHOT.jar
```
Or by using Gradle bootrun task (from project root directory):
```groovy
gradle bootrun
```
Product name service (RedSky) and MongoDB config data is kept in resources/application.yml file