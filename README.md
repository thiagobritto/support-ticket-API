# Support Ticket API

A simple **Support Ticket Management API** built with **Java and Spring Boot**.

This project demonstrates a clean backend architecture with domain modeling, business rules, REST endpoints, validation, and API documentation.

The goal of the project is to showcase backend development practices suitable for a **junior backend developer portfolio**.

---

## Features

- Create support tickets
- List tickets
- Update ticket status
- Enforce status transition rules
- Track ticket status history
- Input validation
- Interactive API documentation with Swagger / OpenAPI

---

## Ticket Lifecycle

Tickets follow a simple workflow:

OPEN → IN_PROGRESS → CLOSED

Invalid transitions are rejected by the service layer.

---

## API Endpoints

| Method | Endpoint | Description |
|-------|---------|-------------|
| POST | /tickets | Create a new ticket |
| GET | /tickets | List all tickets |
| PATCH | /tickets/{id}/status | Update ticket status |
| GET | /tickets/{id}/history | Retrieve ticket status history |

---

## Example Requests

### Create Ticket

POST `/tickets`

```json
{
  "title": "Login problem",
  "description": "User cannot login"
}
```

### Update Ticket Status

PATCH `/tickets/1/status`

```json
{
  "status": "IN_PROGRESS"
}
```

---

## Architecture

The project follows a layered architecture:

```
controller  -> REST API endpoints
service     -> business rules
repository  -> data persistence
domain      -> core entities
dto         -> request / response objects
config      -> OpenAPI configuration
```

---

## Technologies

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Jakarta Validation
- OpenAPI / Swagger (springdoc)

---

## Running the Project

### Requirements

- Java 17+
- Maven

### Run the application

```
mvn spring-boot:run
```

The application will start at:

```
http://localhost:8080
```

---

## API Documentation

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

You can test all endpoints directly in the browser.

---

## Database

The project uses an **in-memory H2 database**.

H2 console:

```
http://localhost:8080/h2-console
```

JDBC URL:

```
jdbc:h2:mem:testdb
```

---

## Possible Improvements

Future enhancements:

- Authentication with Spring Security
- Pagination for ticket listing
- Integration tests
- PostgreSQL support
- Docker containerization

---

## Author

Thiago Messias

Backend development portfolio project.
