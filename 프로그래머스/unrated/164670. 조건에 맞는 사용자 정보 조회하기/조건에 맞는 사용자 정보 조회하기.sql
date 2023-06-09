SELECT U.USER_ID, U.NICKNAME, CONCAT_WS(" ", U.CITY, U.STREET_ADDRESS1, U.STREET_ADDRESS2) AS "전체주소", CONCAT_WS("-", SUBSTRING(U.TLNO, 1, 3), SUBSTR(U.TLNO, 4, 4), RIGHT(U.TLNO, 4)) AS "전화번호"
FROM USED_GOODS_BOARD B JOIN USED_GOODS_USER U ON B.WRITER_ID = U.USER_ID
GROUP BY B.WRITER_ID
HAVING COUNT(B.WRITER_ID) >= 3
ORDER BY B.WRITER_ID DESC