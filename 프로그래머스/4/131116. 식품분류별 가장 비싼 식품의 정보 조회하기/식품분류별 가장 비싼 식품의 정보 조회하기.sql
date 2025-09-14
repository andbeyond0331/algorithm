-- 코드를 입력하세요
# SELECT category, max(price) as max_price, product_name
# from food_product
# # where category = '식용유' or category = '과자' or category = '국' or category = '김치'
# group by category
# having category = '식용유' or category = '과자' or category = '국' or category = '김치'
# order by 2 desc;
# select * from food_product;

# select category, price as max_price, product_name
# from (select category, max(price) as price, product_name
#       from food_product
#       where category in('과자', '국', '김치', '식용유')
#       group by category) f
# order by 2 desc;

SELECT category, price AS max_price, product_name
FROM (
    SELECT category, price, product_name,
           RANK() OVER (PARTITION BY category ORDER BY price DESC) AS rk
    FROM food_product
    WHERE category IN ('식용유', '과자', '국', '김치')
) t
WHERE rk = 1
ORDER BY price DESC;
