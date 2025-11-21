-- 코드를 작성해주세요
select e.id, count(c.id) as child_count
from ecoli_data e left join ecoli_data c on e.id = c.parent_id
group by e.id
order by e.id asc;