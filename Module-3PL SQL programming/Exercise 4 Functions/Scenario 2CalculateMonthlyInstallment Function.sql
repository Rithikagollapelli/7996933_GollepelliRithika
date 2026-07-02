CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount   NUMBER,
    p_interest_rate NUMBER,
    p_years         NUMBER
)
RETURN NUMBER
IS
    v_monthly_installment NUMBER;
BEGIN

    v_monthly_installment :=
        (p_loan_amount +
        (p_loan_amount * p_interest_rate * p_years / 100))
        / (p_years * 12);

    RETURN ROUND(v_monthly_installment,2);

END;
/
SELECT CalculateMonthlyInstallment(
       120000,
       10,
       5
       ) AS EMI
FROM DUAL;

SELECT LoanID,
       LoanAmount,
       InterestRate,
       CalculateMonthlyInstallment(
           LoanAmount,
           InterestRate,
           5
       ) EMI
FROM Loans;