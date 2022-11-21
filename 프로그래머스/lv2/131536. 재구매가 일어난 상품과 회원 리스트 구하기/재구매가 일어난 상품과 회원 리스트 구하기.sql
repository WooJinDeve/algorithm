SELECT USER_ID, PRODUCT_ID
FROM online_sale
GROUP BY user_id, product_id
HAVING count(*) > 1
ORDER BY user_id ASC, product_id DESC