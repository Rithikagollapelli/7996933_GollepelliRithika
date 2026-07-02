CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_empid      NUMBER,
        p_name       VARCHAR2,
        p_position   VARCHAR2,
        p_salary     NUMBER,
        p_department VARCHAR2,
        p_hiredate   DATE
    );

    PROCEDURE UpdateEmployeeSalary(
        p_empid  NUMBER,
        p_salary NUMBER
    );

    FUNCTION GetAnnualSalary(
        p_empid NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_empid      NUMBER,
        p_name       VARCHAR2,
        p_position   VARCHAR2,
        p_salary     NUMBER,
        p_department VARCHAR2,
        p_hiredate   DATE
    )
    IS
    BEGIN

        INSERT INTO Employees
        VALUES (
            p_empid,
            p_name,
            p_position,
            p_salary,
            p_department,
            p_hiredate
        );

        DBMS_OUTPUT.PUT_LINE(
            'Employee Hired Successfully'
        );

    END HireEmployee;

    PROCEDURE UpdateEmployeeSalary(
        p_empid  NUMBER,
        p_salary NUMBER
    )
    IS
    BEGIN

        UPDATE Employees
        SET Salary = p_salary
        WHERE EmployeeID = p_empid;

        DBMS_OUTPUT.PUT_LINE(
            'Employee Salary Updated'
        );

    END UpdateEmployeeSalary;

    FUNCTION GetAnnualSalary(
        p_empid NUMBER
    ) RETURN NUMBER
    IS
        v_salary NUMBER;
    BEGIN

        SELECT Salary
        INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_empid;

        RETURN v_salary * 12;

    END GetAnnualSalary;

END EmployeeManagement;
/
SET SERVEROUTPUT ON;

BEGIN
    EmployeeManagement.HireEmployee(
        20,
        'Rithika Gollapelli',
        'Developer',
        50000,
        'IT',
        TO_DATE('2024-01-15','YYYY-MM-DD')
    );
END;
/
SELECT *
FROM Employees
WHERE EmployeeID = 20;
BEGIN
    EmployeeManagement.UpdateEmployeeSalary(
        20,
        60000
    );
END;
/
SELECT EmployeeID,
       Name,
       Salary
FROM Employees
WHERE EmployeeID = 20;
SELECT EmployeeManagement.GetAnnualSalary(20)
AS ANNUAL_SALARY
FROM DUAL;