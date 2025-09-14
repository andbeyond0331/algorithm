-- 코드를 입력하세요
# SELECT a.apnt_no, p.pt_name, p.pt_no, d.mcdp_cd, d.dr_name, a.apnt_ymd
# from patient p join (select apnt_no, date(apnt_ymd) as sub, apnt_ymd, apnt_cncl_yn, pt_no, mcdp_cd
#                     from appointment
#                     where apnt_cncl_yn = 'N' and date(apnt_ymd) = '2022-04-13' and mcdp_cd = 'CS') a on p.pt_no = a.pt_no, doctor d join (select apnt_no, date(apnt_ymd) as sub, apnt_ymd, apnt_cncl_yn, pt_no, mcdp_cd, mddr_id
#                     from appointment
#                     where apnt_cncl_yn = 'N' and date(apnt_ymd) = '2022-04-13' and mcdp_cd = 'CS') ap on d.dr_id = ap.mddr_id
# order by 6 asc;      

# select * from appointment where date(apnt_ymd) = '2022-04-13'

SELECT a.apnt_no,
       p.pt_name,
       p.pt_no,
       a.mcdp_cd,
       d.dr_name,
       a.apnt_ymd
FROM appointment a
JOIN patient p ON a.pt_no = p.pt_no
JOIN doctor d ON a.mddr_id = d.dr_id
WHERE a.apnt_cncl_yn = 'N'
  AND DATE(a.apnt_ymd) = '2022-04-13'
  AND a.mcdp_cd = 'CS'
ORDER BY a.apnt_ymd ASC;
