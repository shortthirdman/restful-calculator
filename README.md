# restful-calculator

[![Java CI with Maven](https://github.com/shortthirdman/restful-calculator/actions/workflows/maven.yml/badge.svg)](https://github.com/shortthirdman/restful-calculator/actions/workflows/maven.yml)

A simple and lightweight Java-based calculator service built using Maven, implementing basic arithmetic operations (addition, subtraction, multiplication, and division) through HTTP REST APIs. This project serves as a backend API where users can send HTTP requests to perform mathematical calculations, providing a flexible and scalable way to integrate arithmetic functionality into any web application. The API supports JSON responses and is designed for ease of use and integration.  

Features include:  
- Supports basic arithmetic operations (addition, subtraction, multiplication, division)
- RESTful API endpoints for each operation
- JSON formatted input and output  
- Easy setup and deployment with Maven

This project serves as a great starting point for anyone learning how to build and deploy REST APIs using Java and Maven.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.10/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.10/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.3.10/reference/web/servlet.html)
* [Validation](https://docs.spring.io/spring-boot/3.3.10/reference/io/validation.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

### Test

```shell
$ curl -X POST "http://localhost:8080/calculate" -H "Content-type:application/json" -d '{"operationType": "+", "operands": [1, 2, 3]}'
```

```shell
$ curl -X POST "http://localhost:8080/calculate" -H "Content-type:application/json" -d '{"operationType": "+", "operands": []}'
```
