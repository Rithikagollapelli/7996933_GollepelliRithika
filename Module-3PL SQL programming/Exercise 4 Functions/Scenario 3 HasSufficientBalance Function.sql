CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_accountid NUMBER,
    p_amount    NUMBER
)
RETURN VARCHAR2
IS
    v_balance NUMBER;
BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_accountid;

    IF v_balance >= p_amount THEN
        RETURN 'TRUE';
    ELSE
        RETURN 'FALSE';
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'ACCOUNT NOT FOUND';
END;
/
SELECT HasSufficientBalance(
       101,
       5000
       ) AS RESULT
FROM DUAL;
SELECT HasSufficientBalance(
       999,
       1000
       ) AS RESULT
FROM DUAL;
SELECT AccountID,
       Balance
FROM Accounts;