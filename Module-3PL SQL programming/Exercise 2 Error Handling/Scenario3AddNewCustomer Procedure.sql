CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customerid IN NUMBER,
    p_name       IN VARCHAR2,
    p_dob        IN DATE,
    p_balance    IN NUMBER
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

EXCEPTION

    WHEN DUP_VAL_ON_INDEX THEN

        DBMS_OUTPUT.PUT_LINE(
            'Customer ID Already Exists'
        );

    WHEN OTHERS THEN

        DBMS_OUTPUT.PUT_LINE(
            'Error : ' || SQLERRM
        );

END;
/
SELECT OBJECT_NAME, STATUS
FROM USER_OBJECTS
WHERE OBJECT_TYPE='PROCEDURE'
AND OBJECT_NAME='ADDNEWCUSTOMER';
SET SERVEROUTPUT ON;

BEGIN
    AddNewCustomer(
        6,
        'Rahul Sharma',
        TO_DATE('2000-08-15','YYYY-MM-DD'),
        12000
    );
END;
/
SELECT *
FROM Customers
WHERE CustomerID = 6;