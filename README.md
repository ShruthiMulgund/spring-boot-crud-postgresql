# 🧑‍💼 Employee Management Application

## 📌 Overview
The Employee Management Application is a dockerized **Spring Boot** project designed to manage employee records efficiently. It follows a layered architecture with clear separation of concerns, making the codebase maintainable and scalable.

---

## ⚙️ Project Structure
- **Entity**: Represents the `Employee` table in the PostgreSQL database.
- **DTO (Data Transfer Object)**: Used to transfer data between layers without exposing the entity directly.
- **Repository**: Interfaces with the database using Spring Data JPA.
- **Service Interface & Implementation**: Encapsulates business logic and interacts with the repository.
- **Controller**: Exposes REST APIs for managing employees.
- **Custom Exception**: Handles cases where requested resources are not found.

---

## 🗄️ Database
- **Database**: PostgreSQL
- **Configuration**: Connection details (URL, username, password, driver) are defined in `application.properties`.

## 📦 Dependencies
All necessary dependencies are managed in the `pom.xml` file, including:
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- PostgreSQL Driver
- Lombok (optional, for reducing boilerplate code)

---

## 🚀 Features
- Add, update, delete, and fetch employee details.
- Fetch employee by **ID** or **first name**.
- Custom exception handling for missing employees.

---

## 🔮 Future Enhancements
- ✅ **Unit Tests**: Add JUnit and Mockito-based tests for services and controllers.

---

## ▶️ Getting Started
### Prerequisites
- Java 21
- Spring Boot 4+
- Maven
- PostgreSQL installed and running

## Dockerizing
- Add the Dockerfile
- Run postgreSQL in docker first:

```
    docker run --name employees -e POSTGRES_USER=<username> -e POSTGRES_PASSWORD=<pwd> -e POSTGRES_DB=ems -p 5432:5432 -d postgres:15
```
- Build the application image:
```
    docker build -t emp-mgmt-app .
```
- Run the built image:
```
    docker run -p 8080:8080 -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/<db-name> -e SPRING_DATASOURCE_USERNAME=<uname> -e SPRING_DATASOURCE_PASSWORD=<pwd> emp-mgmt-app
```

---

