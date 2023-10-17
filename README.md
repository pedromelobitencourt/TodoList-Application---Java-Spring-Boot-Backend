# TodoList Application - Java Spring Boot Backend

This repository contains the backend code for a TodoList application developed in Java Spring Boot. The application includes user management, task creation with fields like "startAt," "endAt," "title," "description," and "priority." It also supports parameter validation, task modification, and listing all tasks for a user.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- User registration and management
- Task creation with attributes: "startAt," "endAt," "title," "description," and "priority"
- Validation of input parameters to ensure data integrity
- Ability to modify user tasks
- Listing all tasks for a user

## Technologies

This project is built using the following technologies:

- Java Spring Boot
- Hibernate
- RESTful API design
- MySQL or another relational database
- Maven for dependency management

## Getting Started

To set up this project locally, follow these steps:

1. Clone the repository to your local machine.

2. Configure your database connection settings in `application.properties`.

3. Build and run the application.

The application will be accessible at `http://localhost:8080`.

## API Endpoints

The following are the main API endpoints available in the application.

- `POST /api/users` - Register a new user
- `POST /api/tasks` - Create a new task
- `PUT /api/tasks/{taskId}` - Update an existing task
- `GET /api/tasks` - Retrieve all tasks for the authenticated user
- More detailed API documentation can be found in the source code or at `/swagger-ui.html`.

## Usage

Provide examples and instructions for how to use your application here.

## Contributing

If you want to contribute to this project, feel free to submit a pull request. Please make sure to follow the project's coding standards and guidelines.

## License

This project is licensed under the MIT License. See the [LICENSE.md](LICENSE.md) file for details.
