SELECT C.CAR_ID, CAR_TYPE, FLOOR((DAILY_FEE*30) * ((100-DISCOUNT_RATE)/100)) AS FEE  
FROM CAR_RENTAL_COMPANY_CAR C LEFT JOIN 
(SELECT * FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE END_DATE > '2022-11-01'
GROUP BY CAR_ID) AS H USING(CAR_ID)
JOIN
(SELECT * FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE DURATION_TYPE = '30일 이상') AS P
USING (CAR_TYPE)
WHERE 
    CAR_TYPE IN ('SUV','세단') 
    AND HISTORY_ID IS NULL
    AND (DAILY_FEE*30) * ((100-DISCOUNT_RATE)/100) BETWEEN 500000 AND 1999999
ORDER BY 3 DESC, 2, 1 DESC