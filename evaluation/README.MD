# Test Evaluation

## Requirements
- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

## Run Project

There are several ways to run a Spring Boot application on your local machine. 

One way is to execute the `main` method in the `com.ar.integration.shopify.ShopifyIntegrationApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Then you can access http://<host>:<port>/ or you can change `server.port` value in `application.properties` file.
default port == 8080