SET SERVEROUTPUT ON;

BEGIN

    FOR rec IN (
        SELECT CustomerID,
               Name,
               Balance
        FROM Customers
    )
    LOOP

        IF rec.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                rec.Name || ' promoted to VIP'
            );

        END IF;

    END LOOP;

    COMMIT;

END;
/
SELECT CustomerID,
       Name,
       Balance,
       IsVIP
FROM Customers;
SELECT CustomerID,
       Name,
       Balance,
       IsVIP
FROM Customers;