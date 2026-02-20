-- 코드를 작성해주세요
select count(fi.ID) as FISH_COUNT
from FISH_INFO fi join (select *
                    from FISH_NAME_INFO
                    where FISH_NAME='BASS' or FISH_NAME='SNAPPER') f on fi.FISH_TYPE = f.FISH_TYPE;
