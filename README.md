# Scrum_ally

[![keep growing logo](readme-images/logo_250x60.png)](https://keepgrowing.in)

Scrum_ally is a web application designed for project management.
This project is a multi-module app, built with Spring Boot and Angular. It can be built into a single jar file using Maven.

## Overview and technical features

![dashboard](readme-images/dashboard-page.png)

The project currently supports creating and managing tasks for multiple projects.

Some of the more interesting technologies used are:

* REST API
* JWT token-based authentication
* Role-based access to resources
* Material design
* Pagination

## Getting Started

To clone this repository, execute the following in the command line:
```bash
$ git clone https://github.com/little-pinecone/scrum-ally.git
```

You can build the application with:
```bash
$ mvn clean install
```

### Create a test user

Endpoint:

```bash
http://localhost:8080/api/users
```
Body:

```json
{
    "userCredentials": {
        "username": "user",
        "password": "test"
    }
}
```

## Running tests

Run all backend tests with the following command in the root directory:
```bash
$ mvn test
```
Run all frontend tests with the following command in the `frontend/src/main/angular` directory:
```bash
$ ng test
```

## API documentation

To see the API docs generated by Swagger build and run the application, and visit the ```http://localhost:8080/swagger-ui.html``` link in your browser.

## Built With

* [Spring Boot 2.1.2](https://start.spring.io/)
* [Angular 7](https://angular.io/)
* [Maven](https://maven.apache.org/)
* [frontend-maven-plugin](https://github.com/eirslett/frontend-maven-plugin)
* [Daemonite's Material UI](https://daemonite.github.io/material/)

## Screenshots

![landing page](readme-images/landing-page.png)
![dashboard](readme-images/dashboard-page.png)
![project list](readme-images/project-list-page.png)
![project details](readme-images/project-details-page.png)
![side navigation](readme-images/side-nav-component.png)
![login page](readme-images/login-page.png)

## To do

* HATEOAS
* Managing project members, sharing projects
* Custom messages for successful and failed operations
* Sorting
* Breadcrumbs


## License

This project is licensed under the MIT License - see the [license details](https://opensource.org/licenses/MIT).
