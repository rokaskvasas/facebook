facebook
====

## 1. Requirements
Goal

Create blog type applications, which has three types of users: Admin, User, Anonymous.

Business requirements

    Admin can make all CRUD operations on all users.
    User is only able to make changes to his own posts, comments and create a new post.
    
Technical requirements

    Backend Java 11, Spring boot, Spring Data JPA, MySQL.
    Website Thymeleaf,HTML, SCSS and JavaScript.
    
What gets evaluated
- Requirements
- Code quality

## 2. Build and run

> git clone https://github.com/rokaskvasas/facebook.git

> cd facebook

> mvn clean install

> connect MySQL database to project

> use create and insert statements from SQL Statements folder

> in application-demo.properties set your MySQL credentials and port

> choose Spring boot active profile demo

Check in browser
http://localhost:8080/login

## 3. Architecture

1. DB + DB model (Entities)
2. Logic services (model)
3. Controllers
4.View (html+JS)
    
    
## 4. Technologies

- Spring 5.1
- Thymeleaf
- Maven


