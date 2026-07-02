CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_accountid   NUMBER,
        p_customerid  NUMBER,
        p_accounttype VARCHAR2,
        p_balance     NUMBER
    );

    PROCEDURE CloseAccount(
        p_accountid NUMBER
    );

    FUNCTION GetAccountBalance(
        p_accountid NUMBER
    ) RETURN NUMBER;

END AccountOperations;
/
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_accountid   NUMBER,
        p_customerid  NUMBER,
        p_accounttype VARCHAR2,
        p_balance     NUMBER
    )
    IS
    BEGIN

        INSERT INTO Accounts
        VALUES (
            p_accountid,
            p_customerid,
            p_accounttype,
            p_balance,
            SYSDATE
        );

        DBMS_OUTPUT.PUT_LINE(
            'Account Opened Successfully'
        );

    END OpenAccount;

    PROCEDURE CloseAccount(
        p_accountid NUMBER
    )
    IS
    BEGIN

        DELETE FROM Accounts
        WHERE AccountID = p_accountid;

        DBMS_OUTPUT.PUT_LINE(
            'Account Closed Successfully'
        );

    END CloseAccount;

    FUNCTION GetAccountBalance(
        p_accountid NUMBER
    ) RETURN NUMBER
    IS
        v_balance NUMBER;
    BEGIN

        SELECT Balance
        INTO v_balance
        FROM Accounts
        WHERE AccountID = p_accountid;

        RETURN v_balance;

    END GetAccountBalance;

END AccountOperations;
/
SET SERVEROUTPUT ON;

BEGIN
    AccountOperations.OpenAccount(
        201,
        1,
        'Savings',
        10000
    );
END;
/
SELECT *
FROM Accounts
WHERE AccountID = 201;
SELECT AccountOperations.GetAccountBalance(201)
AS ACCOUNT_BALANCE
FROM DUAL;
BEGIN
    AccountOperations.CloseAccount(201);
END;
/
SELECT *
FROM Accounts
WHERE AccountID = 201;