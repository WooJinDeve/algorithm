SELECT MONTH, CAR_ID, RECORDS
FROM (
        SELECT 
            MONTH(START_DATE) AS MONTH
            , CAR_ID 
            , COUNT(START_DATE) AS RECORDS
            , SUM(COUNT(START_DATE)) OVER(PARTITION BY CAR_ID) AS records_sum
        FROM 
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE 
            START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01'
        GROUP BY 
            1,2 
    ) AS TA
WHERE records_sum >= 5
ORDER BY 1 ASC, 2 DESC