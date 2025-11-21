-- 코드를 작성해주세요
select id, case ntile_val
            when 1 then 'CRITICAL'
            when 2 then 'HIGH'
            when 3 then 'MEDIUM'
            when 4 then 'LOW'
        end as colony_name
from (select ID as id, ntile(4) over (order by size_of_colony desc) as ntile_val from ECOLI_DATA) as t
order by id asc;