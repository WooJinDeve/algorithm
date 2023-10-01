SELECT DATE_FORMAT(o.sales_date, '%Y') AS year
     , DATE_FORMAT(o.sales_date, '%m') AS month
     , u.gender
     , COUNT(DISTINCT u.user_id) AS users
FROM online_sale AS o 
    INNER JOIN user_info AS u ON o.user_id = u.user_id
WHERE u.gender IS NOT NULL
GROUP BY year, month, u.gender