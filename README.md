# Payments Application

## Description
Payments is a demo application built with Spring Boot to manage payments. This application allows you to create and retrieve payments via a REST API. It uses a PostgreSQL database to store data.

## Prerequisites
Before setting up and running the application, ensure you have the following installed:

- **Java 17**: The application is configured to use Java 17.
- **Maven 3.8+**: For managing dependencies and building the project.
- **Docker**: For containerization and easy deployment of the application.
- **PostgreSQL**: PostgreSQL is used as the database. Make sure you have a running instance of PostgreSQL or a configured Docker container for PostgreSQL.

## Setup

### 1. Clone the Repository
Clone the repository to your local machine:

```bash
git clone https://github.com/DevGonza/payment.git
```

### 2. Configure Environment Variables

Set up the following environment variables:

- **DB_URL**: The URL for connecting to the PostgreSQL database.
- **DB_USERNAME**: The database username.
- **DB_PASSWORD**: The database user's password.
- **DB_PLATFORM**: The database platform. Example: org.hibernate.dialect.PostgreSQLDialect

### 3. Using the API

Create a Payment
To create a payment, send a POST request to the following endpoint with a JSON body containing the payment details:
- **Endpoint**: POST /api/payments

```json
{
  "cardNumber": "4000846295737800",
  "amount": 10000,
  "paymentDate": "2024-08-27",
  "description": "test"
}
```

View All Payments
To view all payments, send a GET request to the following endpoint:
- **Endpoint**: GET /api/payments
