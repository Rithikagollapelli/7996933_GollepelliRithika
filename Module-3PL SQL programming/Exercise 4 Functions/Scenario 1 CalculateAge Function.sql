CREATE OR REPLACE FUNCTION CalculateAge(
    p_dob DATE
)
RETURN NUMBER
IS
    v_age NUMBER;
BEGIN

    v_age := FLOOR(
                MONTHS_BETWEEN(
                    SYSDATE,
                    p_dob
                ) / 12
             );

    RETURN v_age;

END;
/
SELECT CalculateAge(
       TO_DATE('1990-07-20','YYYY-MM-DD')
       ) AS AGE
FROM DUAL;
SELECT CustomerID,
       Name,
       DOB,
       CalculateAge(DOB) AS Age
FROM Customers;

