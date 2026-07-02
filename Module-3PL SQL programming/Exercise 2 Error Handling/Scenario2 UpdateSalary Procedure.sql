SELECT EmployeeID,
       Name,
       Salary
FROM Employees;
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_empid      IN NUMBER,
    p_percentage IN NUMBER
)
IS
    v_count NUMBER;
BEGIN

    SELECT COUNT(*)
    INTO v_count
    FROM Employees
    WHERE EmployeeID = p_empid;

    IF v_count = 0 THEN
        RAISE_APPLICATION_ERROR(
            -20002,
            'Employee ID does not exist'
        );
    END IF;

    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_empid;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Salary Updated Successfully'
    );

EXCEPTION

    WHEN OTHERS THEN

        DBMS_OUTPUT.PUT_LINE(
            'Error : ' || SQLERRM
        );

END;
/
SET SERVEROUTPUT ON;

EXEC UpdateSalary(12,10);
SELECT EmployeeID,
       Name,
       Salary
FROM Employees
WHERE EmployeeID = 12;
EXEC UpdateSalary(99,10);