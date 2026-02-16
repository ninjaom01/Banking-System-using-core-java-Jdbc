BankApp/
├── DBConnection.java
├── Account.java
├── BankException.java
├── Service.java
└── BankApp.java

# 🏦 Banking System - Core Java + JDBC

A console-based Banking System application developed using Core Java and JDBC with MySQL database integration.  
This project demonstrates CRUD operations, business rule validation, and custom exception handling.

---

## 🚀 Features

- Create Account
- Delete Account
- Deposit Money
- Withdraw Money
- Show Balance
- Show Account Details
- Custom Exception Handling
- MySQL Database Integration

---

## 🛠️ Technologies Used

- Core Java
- JDBC (Java Database Connectivity)
- MySQL
- IntelliJ IDEA
- Git & GitHub

---

---

## 🗄️ Database Setup

Run the following SQL commands in MySQL:

```sql
CREATE DATABASE bankdb;
USE bankdb;

CREATE TABLE account (
    acc_no INT PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(200),
    acc_type VARCHAR(20),
    balance DOUBLE,
    min_balance DOUBLE
);


## 📂 Project Structure

