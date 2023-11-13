# <h1 align="center"> Task-Management-Application </h1>
___ 
<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
    <a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.4-brightgreen.svg" />
</a>
<a href="License url" >
    <img alt="BSD Clause 3" src="https://img.shields.io/badge/License-BSD_3--Clause-blue.svg"/>
</a>
</p>

---

<p align="left">

## Overview

Task Management Backend Application is a Spring Boot-based backend system designed to provide task input, update and deletion features with different users having different authorizations. This provides admin level users ability to add and remove tasks and employee level users ability to update tasks.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java 21
- **Database:** MySQL
- **Build Tool:** Maven
- **Documentation:** SpringDoc OpenAPI (Swagger UI)

## For a list of APIs Used and to make HTTP requests
- http://localhost:8080/swagger-ui/index.html#/

## Dependencies Used

The project utilizes the following dependencies:

- **Spring Boot Starter Data JPA**: Simplifies database access using Spring Data repositories.

- **Spring Boot Starter Web**: Provides support for building web applications, including RESTful APIs.

- **MySQL Connector/J (Runtime Dependency)**: The MySQL JDBC driver for connecting to MySQL databases.

- **Project Lombok (Optional)**: A library for reducing boilerplate code, such as getters and setters.

- **Spring Boot Starter Test (For Testing)**: Provides support for testing Spring Boot applications.

- **spring-boot-starter-security**: Includes security modules used for user authentication and authorization.

- **Springdoc OpenAPI (Swagger UI)**: Adds Swagger UI for documenting and testing API endpoints.

- **Spring Boot Starter Validation**: Includes validation support for request data binding and response data rendering.

- **Other Dependencies:** Various other dependencies are included in the `pom.xml` file for specific functionalities, such as Jackson for JSON serialization, Spring Web for web-related features, and more.

Please refer to the project's `pom.xml` file for a comprehensive list of all dependencies and their respective versions.


## Project Structure

The project follows a clean and organized structure:

- **Main Application Class:** `TaskManagementApplication.java` serves as the entry point for the Spring Boot application.
- **Entities:** The application includes entities for `Role`, `Task`, `User`
- **Security Configuration:** Spring Security is employed to secure the application with authentication and authorization.
- **Database Configuration:** The `application.properties` file configures the database connection and Spring Data JPA properties.
- **Controller Classes:** These classes define and document the RESTful API endpoints for user management, tasks and roles.
- **Service Classes:** Business logic is implemented in service classes, ensuring separation of concerns.
- **Repository Interfaces:** Spring Data JPA repository interfaces manage data access to the underlying database.

### RESTful API Endpoints


## Database Details

The Application utilizes a MySQL database to persist user data, roles, tasks, and other relevant information. Here are the key details about the database:

- **Database Engine:** MySQL


### Database Configuration

The database connection properties can be found in the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_management
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```

Make sure to replace `your_username` and `your_password` with your actual MySQL credentials.





