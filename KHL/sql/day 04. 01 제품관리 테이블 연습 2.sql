-- 단가가 3000원 이상 6000원 이하인 제품들을 확인
use example;
select * from 제품
where 단가 >= 3000 and 단가 <= 6000;

-- between
select * from 제품
where 단가 between 3000 and 6000;

-- IN 여러 값 중 하나를 만족하는 경우 사용
-- 제조업체가 대한식품 또는 민국푸드인 제품들을 확인
select * from 제품 
where 제조업체 in ('대한식품', '민국푸드')
order by 제조업체;

-- 등급이 silver 또는 gold 인 회원의 아이디를 확인
select 고객아이디, 등급 from 고객
where 등급 in ('gold','silver');

-- 등급이 silver 또는 gold 인 회원이 주문한 제품명을 확인
select distinct 제품명 FROM 주문
JOIN 제품 on 주문.주문제품 = 제품.제품번호
join 고객 on 고객.고객아이디 = 주문.주문고객
where 등급 in ('gold', 'silver');

-- 가격이 2600원 이상인 제품의 제품명과 단가를 확인
select 제품명, 단가 from 제품
where 단가 >= 2600;

-- 서브쿼리 : 쿼리문 안에 쿼리가 들어가있는 쿼리
-- select () from () where (); ()안에 select문이 들어갈 수 있음(서브쿼리)
-- 콩떡파이의 가격보다 크거나 같은 제품의 제품명과 단가를 확인
select 제품명, 단가 from 제품
where 단가 >= (
select 단가 from 제품
where 제품명 = '쿵떡파이'
);

-- 그냥만두 가격보다 크거나 같고 / 얼큰라면의 가격보다 크거나 같은 제품의 제품명과 단가를 확인 
select 제품명, 단가 from 제품
where 단가 >= (select max(단가) from 제품 where 제품명 in ('그냥만두', '얼큰라면'));
-- all() : 전부를 만족하는 경우들만 확인. and 개념
-- any() : 하나 이상을 만족하는 경우들을 확인. or 개념
select 제품명, 단가 from 제품
where 단가 >= all(select 단가 from 제품 where 제품명 in ('그냥만두', '얼큰라면'));

-- 그냥만두 가격보다 크거나 같거나 / 얼큰라면의 가격보다 크거나 같은 제품의 제품명과 단가를 확인
select 제품명, 단가 from 제품
where 단가 >= any(select 단가 from 제품 where 제품명 in ('그냥만두', '얼큰라면'));

-- group by : where절 다음에 나와야 함.
-- select () from () where () group by () order by () 순
-- group by 는 distinct 와 유사
select * from 제품 group by 제조업체;
select distinct 제조업체 from 제품;

-- 대한식품에서 만든 제품의 개수를 확인
select count(*) as '대한식품 제품수' from 제품 
where 제조업체 = '대한식품';

-- 각 회사별 제품의 개수
select 제조업체, count(*) as '대한식품 제품수' from 제품 
group by 제조업체;

-- 한번 이상 주문한 고객별 주문한 제품 횟수
select 고객.고객이름, count(*) as '주문횟수' from 주문
join 고객 on 주문.주문고객 = 고객.고객아이디
group by 주문고객;

-- 한번이상 주문한 고객별 고객의 총 주문 개수
select 주문고객, count(*) as '총 주문횟수' from 주문
group by 주문고객;

-- 한번이상 주문한 고객별 고객의 총 주문 갯수
select 주문고객, sum(수량) as '총 주문 갯수' from 주문
group by 주문고객;

select 고객이름, sum(수량) as '총 주문수량' from 주문
join 고객 on 주문.주문고객 = 고객.고객아이디
group by 주문고객;

-- 한번이상 주문한 고객별 고객의 총 주문 금액을 확인, 총 주문 금액 순으로 정렬
select 주문고객, sum(수량*단가) as '총 주문 금액' from 주문 
join 제품 on 주문.주문제품 = 제품.제품번호
group by 주문고객
order by `총 주문 금액` desc;

-- 1번이상 주문한 고객중 총 금액이 100000원 이상인 고객 확인

-- where 절에는 group by로 작업한 sum/count 등 집약 함수를 이용한 조건을 걸 수 없다

-- select 주문고객, sum(수량*단가) as '총 주문 금액' from 주문 
-- join 제품 on 주문.주문제품 = 제품.제품번호
-- where sum(수량*단가) >= 100000
-- group by 주문고객;

-- 이럴 결우 where 대신 group 다음에 having 을 사용
select 주문고객, sum(수량*단가) as '총 주문 금액' from 주문 
join 제품 on 주문.주문제품 = 제품.제품번호
group by 주문고객
having `총 주문 금액` >= 100000;

-- 제품별 주문한 제품번호와 주문수량(제품의 누적 주문량), 제조업체를 확인
select 제조업체, 제품번호, sum(수량) as '누적 주문수량' from 주문 
join 제품 on 제품.제품번호 = 주문.주문제품
group by 제품명;

-- 제조업체별 가장 많이 팔린 제품의 제조업체, 제품번호, 주문수량을 확인
select 제조업체, 주문제품, max(누적주문량) as '주문수량' from
	(select 제조업체, 주문제품, sum(수량) as '누적주문량' from 주문
    join 제품 on 주문제품 = 제품번호
    group by 주문제품
    order by 제조업체
    ) as `제품별판매량`
group by 제조업체;

-- with rollup : 부분총합을 구해줌
select 주문고객, 주문제품, sum(수량) from 주문
	group by 주문제품, 주문고객
    with rollup;
    
-- LIMIT : 검색결과의 개수를 제한할 때 사용 
-- LIMIT 정수1 : 정수 1개만큼 결과를 보여줌 
-- LIMIT 번지, 정수1 : 번지부터 정수 1개만큼의 결과를 보여줌 
select * from 주문 LIMIT 5;
select * from 주문 LIMIT 1, 5;

-- 가장 많은 금액을 사용한 고객 아이디를 확인 
select 주문고객, sum(수량*단가) as '사용금액' from 주문
	join 제품 on 주문제품 = 제품번호
    group by 주문고객
    order by `사용금액` desc
    limit 1;

-- 가장 많은 제품 갯수를 구매한 고객 아이디를 확인
select 주문고객, sum(수량) as '주문수량합계' from 주문
	group by 주문고객
    order by `주문수량합계` desc
    limit 1;
    
-- 20대가 구매한 제품 목록을 확인
select distinct 제품명 from ( -- 작성한 쿼리
select 주문고객, 주문제품 from 주문 
	join 고객 on 주문고객 = 고객아이디
    where 나이 < 30 and 나이 >= 20) as `20대 고객` -- between 20 and 29
    join 제품 on 주문제품 = 제품.제품번호;
    
select 제품명 as '20대구매제품' from 고객 
	join 주문 on 고객아이디 = 주문고객 
    join 제품 on 주문제품 = 제품번호
    where 나이 between 20 and 29
    group by 제품명;

-- 20대가 가장 많이 구매한 제품을 확인
select 주문제품, sum(수량) as '구매수량' from 
(select * from 주문 
	join 고객 on 주문고객 = 고객아이디
    where 나이 < 30 and 나이 >= 20) as `20대 고객`
    group by 주문제품
    order by `구매수량` desc
    limit 1;
    
select 제품명, sum(수량) as '수량' from 고객 
	join 주문 on 고객아이디 = 주문고객 
    join 제품 on 주문제품 = 제품번호
    where 나이 between 20 and 29
    group by 제품명
    order by `수량` desc
    limit 1;


