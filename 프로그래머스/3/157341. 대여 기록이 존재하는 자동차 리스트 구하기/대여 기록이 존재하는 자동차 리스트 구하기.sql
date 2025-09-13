-- 코드를 입력하세요
SELECT distinct h.car_id
FROM CAR_RENTAL_COMPANY_CAR c right join (select substring(start_date, 6, 7) as sd, car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY) h on c.car_id = h.car_id
where c.car_type = '세단' and h.sd = 10
order by 1 desc;