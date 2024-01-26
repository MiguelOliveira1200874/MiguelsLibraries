
# MiguelsLibrary

## Overview
MiguelsLibrary is a comprehensive Java-based application designed for managing a bookstore. It offers functionalities for handling books, authors, customers, orders, suppliers, and supply orders. The application is structured in a modular manner, promoting ease of maintenance and scalability.

## Repository Structure
- `bin/main/bookstore`: Contains compiled classes for different modules like model, controller, dto, exception, repository, service, and util.
- `src/main/java/bookstore`: Houses the source code for various modules including model, controller, dto, exception, repository, service, and util.
- `gradle/wrapper`: Contains Gradle wrapper properties and scripts for project building and dependencies management.
- `build.gradle.kts`: Kotlin-based build script for setting up project dependencies and configurations.
- `settings.gradle.kts`: Gradle settings file, primarily for project name configuration.

## Key Components
- **Model**: Defines the data structure for entities such as Author, Book, BookAuthor, Customer, Order, OrderDetails, Supplier, and SupplyOrder.
- **Repository**: Interfaces for data access, leveraging Spring Data JPA.
- **Service**: Business logic layer.
- **Controller**: RESTful APIs for interacting with the application.
- **DTO (Data Transfer Objects)**: Custom objects for transferring data across processes.
- **Exception Handling**: Custom exceptions for handling specific error cases.
- **Utilities**: Helper functions and utilities.

## Building the Project
- Ensure you have Java and Gradle installed.
- Navigate to the project root directory.
- Run `gradlew build` to build the project.

## Running the Application
- After building, run `gradlew bootRun` to start the application.
- The application will be accessible on the configured port (default: 8080).

## Dependencies
- Spring Boot
- Spring Data JPA
- PostgreSQL JDBC Driver
- JUnit Jupiter for testing

## Contributing
Contributions to MiguelsLibrary are welcome. Please ensure that your code adheres to the project's coding standards and includes adequate test coverage.

## License
This project is licensed under the Apache License Version 2.0. See the LICENSE file for more details.
