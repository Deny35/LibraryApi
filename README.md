# Library Management System

## Description

This project is a simple library management system that enables the management of books and users, as well as the process of borrowing books.

## Prerequisites

Before running, ensure you have installed:

- Java (version 11 or higher)
- Maven
- MySQL - installed and running database

## Configuration

Before launching the application, configure the `application.properties` file in the `src/main/resources` directory. Update the database settings to match your MySQL environment.

spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password

markdown
Copy code

Change `your_database_name`, `your_username`, and `your_password` to the appropriate values.

## Running

To run the project, follow these steps:

1. Clone the repository to your local environment.
2. Navigate to the main directory of the project.
3. Launch the application using Maven: `mvn spring-boot:run`
4. The application will be available at `http://localhost:8080`.

## API Endpoints

### Books

- `POST /api/books` - add a new book
- `DELETE /api/books/{id}` - delete a book with the specified ID
- `GET /api/books/search?title={title}` - search for books by title

### Users

- `POST /api/users` - add a new user
- `DELETE /api/users/{id}` - delete a user with the specified ID

### Borrowing

- `POST /api/borrowings/borrow?bookId={bookId}&studentNumber={studentNumber}` - borrow a book
- `POST /api/borrowings/return/{borrowingId}` - return a book
- `GET /api/borrowings/user/{userId}` - display books borrowed by a user

