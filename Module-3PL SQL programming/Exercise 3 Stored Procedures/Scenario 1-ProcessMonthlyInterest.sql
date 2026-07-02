CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Monthly Interest Applied Successfully'
    );

END;
/
SELECT AccountID,
       AccountType,
       Balance
FROM Accounts;
SET SERVEROUTPUT ON;

EXEC ProcessMonthlyInterest;
BEGIN
    ProcessMonthlyInterest;
END;
/
SELECT AccountID,
       AccountType,
       Balance
FROM Accounts;