SET SERVEROUTPUT ON;

DECLARE

    CURSOR c_loans IS
        SELECT LoanID,
               InterestRate
        FROM Loans;

BEGIN

    FOR rec IN c_loans LOOP

        UPDATE Loans
        SET InterestRate = InterestRate + 1
        WHERE LoanID = rec.LoanID;

        DBMS_OUTPUT.PUT_LINE(
            'Interest Rate Updated for Loan ID: '
            || rec.LoanID
        );

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'All Loan Interest Rates Updated Successfully'
    );

END;
/
SELECT LoanID,
       LoanAmount,
       InterestRate
FROM Loans;
SELECT LoanID,
       LoanAmount,
       InterestRate
FROM Loans;
SET SERVEROUTPUT ON;

DECLARE

    CURSOR c1 IS
        SELECT LoanID
        FROM Loans;

    v_loanid Loans.LoanID%TYPE;

BEGIN

    OPEN c1;

    LOOP

        FETCH c1 INTO v_loanid;

        EXIT WHEN c1%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate + 1
        WHERE LoanID = v_loanid;

        DBMS_OUTPUT.PUT_LINE(
            'Updated Loan ID: ' || v_loanid
        );

    END LOOP;

    CLOSE c1;

    COMMIT;

END;
/