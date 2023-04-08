SELECT category, SUM(sales) AS ToTal_SALES
FROM book AS b
JOIN book_sales AS bs ON b.book_id = bs.book_id
WHERE YEAR(sales_date) = '2022' AND MONTH(sales_date)="01"
GROUP BY category
ORDER BY category