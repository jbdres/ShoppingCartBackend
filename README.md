# 🛒 Spring Boot - Shopping Cart API

This is a backend project built with **Spring Boot**, based on an entity-relationship diagram of a shopping cart system. Its goal is to serve as a professional starting point for RESTful APIs, applying best practices in architecture and version control using Git.

---

## 🚀 Technologies Used

- Java 23+
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven
- Git / Git Flow
- DTO + Service Layer Architecture

---

## 📁 Package Structure


---

## 📦 Modeled Entities

Based on the E-R diagram, this project includes:

- `User`, `Role`, `UserRoles`
- `Product`, `Category`, `Image`
- `Cart`, `CartItem`
- `Order`, `OrderItem`

---

## ✅ Commit Message Convention

This project uses the **Conventional Commits** standard to ensure clarity and automate tasks:

| Type      | Purpose                                                |
|-----------|--------------------------------------------------------|
| `feat`    | New feature or endpoint                                |
| `fix`     | Bug fixes                                              |
| `docs`    | Documentation changes (README, JavaDocs, etc.)         |
| `style`   | Code formatting only, no logic changes                 |
| `refactor`| Code refactoring without feature or bug impact        |
| `test`    | Adding or updating tests                               |
| `chore`   | Maintenance tasks or configuration changes             |

**Examples:**
```bash
feat(user): add endpoint to register users
fix(cart): fix total calculation in CartItemService
docs: add installation instructions to README
```
---
