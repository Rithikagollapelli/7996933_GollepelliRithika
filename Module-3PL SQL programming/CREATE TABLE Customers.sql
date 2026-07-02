CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE,
    IsVIP VARCHAR2(5)
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
INSERT INTO Customers VALUES
(1,'John Doe',TO_DATE('1955-05-10','YYYY-MM-DD'),12000,SYSDATE,NULL);

INSERT INTO Customers VALUES
(2,'Jane Smith',TO_DATE('1995-07-20','YYYY-MM-DD'),8000,SYSDATE,NULL);

INSERT INTO Customers VALUES
(3,'Robert King',TO_DATE('1958-02-15','YYYY-MM-DD'),15000,SYSDATE,NULL);

INSERT INTO Customers VALUES
(4,'Mary Thomas',TO_DATE('1988-09-25','YYYY-MM-DD'),5000,SYSDATE,NULL);

COMMIT;