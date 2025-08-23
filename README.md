# Mini GameSpot

A lightweight full-stack web application for managing and commenting on gaming articles.  
Built with **Spring Boot (Backend)** and **React (Frontend)**.

---

## Features

- View a list of articles
- Add, edit, and delete comments on each article
- Confirmation modal for safe deletion
- Basic CSS styling (ready for future polish)

---

## Tech Stack

- **Backend:** Java 17, Spring Boot, Spring Web, Spring Data JPA, PostgreSQL
- **Frontend:** React, Axios, CSS
- **Build & Tools:** Maven, Docker (optional), IntelliJ IDEA

---

## Screenshots

### Home Page
![Home Page](docs/screenshots/home.png)

### Article with Comments
![Article with Comments](docs/screenshots/article-comments.png)

### Delete Confirmation Modal
![Delete Confirmation](docs/screenshots/delete-modal.png)

---

## Getting Started

### Prerequisites
- Java 17+
- Node.js & npm
- PostgreSQL (or adjust for in-memory database)

### Backend Setup
```bash
cd backend
./mvnw spring-boot:run
