/*
insert into fruit values('딸기', 5000, 0, '박스');
insert into fruit values('바나나', 4000, 0, '송이');
insert into fruit values('포도', 10000, 0, '상자');
insert into fruit values('수박', 12000, 0, 'EA');
insert into fruit values('귤', 10000, 0, '박스');
*/
-- insert into store values

-- ('행복과일가게', '청주시'), ('과일상', '청주시'), ('과일상회','청주시');
-- select * from store

-- 과잉상회에서 딸기를 100상자를 개당 4000원에 구매를 했다. 이때 필요한 쿼리를 작성하세요
-- 날짜는 '2021-11-24-15:10:10

-- insert into buy(bu_fr_name, bu_amount, bu_date, bu_unit, bu_st_name) 
-- 	values('딸기', 100, '2021-11-24 15:10:00', '상자', '과일상회'); 
-- update fruit set fr_amount = fr_amount + 100 where fr_name = '딸기'; 
    
-- 손님이 현금으로 딸기 2상자를 지금 사갔다.
-- select * from sell;

-- insert into sell(se_fr_name, se_amount, se_unit, se_price, se_date, se_type)
-- values ('딸기', 2, '상자', 10000, now(), '현금');
-- update fruit set fr_amount = fr_amount - 2 where fr_name = '딸기';

-- 과일 판매 내역을 확인하는 쿼리
select se_fr_name, se_amount From sell;

select now() > '2021-11-23';
select now() < '2021-11-25';
select now() > '2022-11-25';
-- 창이면 1, 거짓이면 0으로 결과가 나옴
select count(*) fr_name from fruit;

-- 오늘 과일 판매내역 확인
select * from sell
where se_date > '2021-11-23' and se_date < '2021-11-25';
select SE_DATE, se_fr_name, se_amount, se_price, se_type from sell
where se_date like '2021-11-24%';
-- 온오늘 과일 판매 총 금액을 확인
select sum(se_price) as '오늘 판매액' from sell
where se_date > '2021-11-23' and se_date < '2021-11-25';

-- 딸기 총 판매액 확인
select sum(se_price) as '딸기 총 판매액' from sell
	where se_fr_name = '딸기';

-- 딸기 판매액 중 현금으로 판매한 금엑
select sum(se_price) as '딸기 현금 판매액' from sell
	where se_fr_name = '딸기' and se_type = '현금';