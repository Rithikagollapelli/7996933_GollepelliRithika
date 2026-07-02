SET SERVEROUTPUT ON;

DECLARE

    CURSOR c_accounts IS
        SELECT AccountID
        FROM Accounts;

BEGIN

    FOR rec IN c_accounts LOOP

        UPDATE Accounts
        SET Balance = Balance - 500
        WHERE AccountID = rec.AccountID;

        DBMS_OUTPUT.PUT_LINE(
            'Annual Fee Deducted from Account: '
            || rec.AccountID
        );

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Annual Fee Applied Successfully'
    );

END;
/
SELECT AccountID,
       Balance
FROM Accounts;
