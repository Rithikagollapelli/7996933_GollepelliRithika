CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (LogID, TableName, Operation, RecordID, NewValue, LogDate, LogUser)
    VALUES (
        AuditLog_Seq.NEXTVAL,
        'TRANSACTIONS',
        'INSERT',
        :NEW.TransactionID,
        'AccountID: ' || :NEW.AccountID || 
        ', Amount: ' || :NEW.Amount || 
        ', Type: ' || :NEW.TransactionType,
        SYSDATE,
        USER
    );
    
    DBMS_OUTPUT.PUT_LINE('Audit Log: Transaction ' || :NEW.TransactionID || ' recorded.');
END;
/
INSERT INTO Transactions VALUES (8, 1, SYSDATE, 250, 'Deposit');

SELECT * FROM AuditLog WHERE TableName = 'TRANSACTIONS';
