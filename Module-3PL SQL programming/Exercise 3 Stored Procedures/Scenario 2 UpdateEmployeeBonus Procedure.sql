CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus      IN NUMBER
)
IS
BEGIN

    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus / 100)
    WHERE Department = p_department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Bonus Applied Successfully'
    );

END;
/
SELECT EmployeeID,
       Name,
       Department,
       Salary
FROM Employees;
SET SERVEROUTPUT ON;

EXEC UpdateEmployeeBonus('IT',10);
BEGIN
    UpdateEmployeeBonus('IT',10);
END;
/
SELECT EmployeeID,
       Name,
       Department,
       Salary
FROM Employees
WHERE Department='IT';
BEGIN
    UpdateEmployeeBonus('HR',5);
END;
/