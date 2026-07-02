SELECT AccountID, CustomerID, Balance
FROM Accounts;
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF UPPER(:NEW.TransactionType) = 'DEPOSIT' THEN

        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(
                -20001,
                'Deposit amount must be positive'
            );
        END IF;

    ELSIF UPPER(:NEW.TransactionType) = 'WITHDRAWAL' THEN

        SELECT Balance
        INTO v_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID;

        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(
                -20002,
                'Insufficient Balance'
            );
        END IF;

    END IF;
END;
/
SELECT * FROM Accounts;
SELECT *
FROM Transactions;