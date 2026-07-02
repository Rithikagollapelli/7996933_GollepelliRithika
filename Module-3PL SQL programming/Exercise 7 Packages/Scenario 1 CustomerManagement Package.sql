CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer(
        p_customerid NUMBER,
        p_name       VARCHAR2,
        p_dob        DATE,
        p_balance    NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_customerid NUMBER,
        p_balance    NUMBER
    );

    FUNCTION GetBalance(
        p_customerid NUMBER
    ) RETURN NUMBER;

END CustomerManagement;
/
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_customerid NUMBER,
        p_name       VARCHAR2,
        p_dob        DATE,
        p_balance    NUMBER
    )
    IS
    BEGIN

        INSERT INTO Customers
        (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
        VALUES
        (p_customerid,
         p_name,
         p_dob,
         p_balance,
         SYSDATE,
         'N');

        COMMIT;

        DBMS_OUTPUT.PUT_LINE(
            'Customer Added Successfully'
        );

    END AddCustomer;

    PROCEDURE UpdateCustomer(
        p_customerid NUMBER,
        p_balance    NUMBER
    )
    IS
    BEGIN

        UPDATE Customers
        SET Balance = p_balance
        WHERE CustomerID = p_customerid;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE(
            'Customer Updated Successfully'
        );

    END UpdateCustomer;

    FUNCTION GetBalance(
        p_customerid NUMBER
    )
    RETURN NUMBER
    IS
        v_balance NUMBER;
    BEGIN

        SELECT Balance
        INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customerid;

        RETURN v_balance;

    END GetBalance;

END CustomerManagement;
/
SET SERVEROUTPUT ON;

BEGIN
    CustomerManagement.AddCustomer(
        7,
        'Priya Sharma',
        TO_DATE('1998-04-10','YYYY-MM-DD'),
        18000
    );
END;
/
SELECT *
FROM Customers
WHERE CustomerID = 7;
BEGIN
    CustomerManagement.UpdateCustomer(
        7,
        25000
    );
END;
/
SELECT CustomerManagement.GetBalance(7)
AS BALANCE
FROM DUAL;