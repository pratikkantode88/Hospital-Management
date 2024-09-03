The Hospital Management System is a web-based application developed using Spring Boot to efficiently manage hospital operations, including patient records, appointment scheduling, and medical inventory. The system aims to streamline hospital workflows and improve overall patient care.

## Features

- **Patient Management**: Register and manage patient information.
- **Appointment Scheduling**: Schedule and manage patient appointments with doctors.
- **Medical Inventory**: Track and manage medical supplies and equipment.
- **Billing**: manage patient bills and payments.
- **Authentication and Authorization**: Secure the application with JWT-based authentication and role-based access control.

## Technologies Used

- **Spring Boot**: For building the backend application.
- **Angular**: For building the frontend application.
- **Spring Security**: For securing the application with authentication and authorization.
- **JWT (JSON Web Token)**: For stateless authentication and secure token-based sessions.
- **Spring Data JPA**: For data access and repository management.
- **Thymeleaf**: For server-side rendering of web pages.
- **MY-SQL Database**: database for development and testing.
- **Bootstrap**: For styling the web interface.

## Prerequisites

- JDK 11 or higher
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse)

## Installation

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/pratikkantode88/Hospital-Management.git
    ```

2. **Navigate to the Project Directory**:

    ```bash
    cd Hospital-Management
    ```

3. **Build the Project**:

    ```bash
    mvn clean install
    ```

4. **Run the Application**:

    ```bash
    mvn spring-boot:run
    ```

    The application will start and be available at `http://localhost:8080`.
