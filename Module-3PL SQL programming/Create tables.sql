CREATE DATABASE BankDB;
USE BankDB;
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100),
    DOB DATE,
    Balance DECIMAL(10,2),
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR(20),
    Balance DECIMAL(10,2),
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT,
    LoanAmount DECIMAL(10,2),
    InterestRate DECIMAL(5,2),
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(100),
    Position VARCHAR(50),
    Salary DECIMAL(10,2),
    Department VARCHAR(50),
    HireDate DATE
);
CREATE TABLE BankTransactions (
    TransactionID INT PRIMARY KEY,
    AccountID INT,
    TransactionDate DATE,
    Amount DECIMAL(10,2),
    TransactionType VARCHAR(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
SHOW DATABASES;
INSERT INTO Customers
VALUES (1,'John Doe','1985-05-15',1000,CURDATE());

INSERT INTO Customers
VALUES (2,'Jane Smith','1990-07-20',1500,CURDATE());

INSERT INTO Accounts
VALUES (1,1,'Savings',1000,CURDATE());

INSERT INTO Accounts
VALUES (2,2,'Checking',1500,CURDATE());

INSERT INTO Loans
VALUES (1,1,5000,5,CURDATE(),DATE_ADD(CURDATE(), INTERVAL 60 MONTH));

INSERT INTO Employees
VALUES (1,'Alice Johnson','Manager',70000,'HR','2015-06-15');

INSERT INTO Employees
VALUES (2,'Bob Brown','Developer',60000,'IT','2017-03-20');
SELECT * FROM Customers;
DELETE FROM Accounts;
DELETE FROM Loans;
DELETE FROM Employees;
DELETE FROM Customers;
SELECT * FROM Accounts;
SELECT * FROM Loans;
SELECT * FROM Employees;