﻿facebook
====

#### 1. Requirements
Goal

Create blog type applications, which has three types of users: Admin, User, Anonymous.

Buisness reuirements

    Admin can make all CRUD operations on all users.
    User is only able to make changes to his own posts, comments and create a new post.
    
Technical requirements

    Backend Java 11, Spring boot, Spring Data JPA, MySQL.
    Website Thymeleaf, SCSS and JavaScript.
    
What gets evaluated
- Requirements
- Code quality

#### 2. Build and run

> git clone https://github.com/rokaskvasas/facebook.git

> cd facebook

> mvn clean install

> connect MySQL database to project

> use create and insert statements from SQL Statements folder

> in application-demo.properties set your MySQL credentials and port

> choose Spring boot active profile demo

Check in browser
http://localhost:8080/login

