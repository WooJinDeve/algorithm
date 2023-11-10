WITH c1 AS(
    SELECT member_id, DENSE_RANK() OVER(ORDER BY COUNT(member_id) DESC) ranking
    FROM REST_REVIEW 
    GROUP BY member_id
)
SELECT member_name, review_text, DATE_FORMAT(review_date, '%Y-%m-%d') review_date # SUBSTR(review_date, 1, 10)
FROM MEMBER_PROFILE m 
JOIN c1 ON m.member_id = c1.member_id
JOIN REST_REVIEW r ON m.member_id = r.member_id
WHERE ranking = 1
ORDER BY review_date, review_text;