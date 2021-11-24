-- 고객 명단 확인
select * from 고객;

-- 고객 등급 확인
select distinct 등급 from 고객; -- distinct : 중복제거alter

-- id가 apple인 고객의 주문 내역확인
select * from 주문 where 주문고객 = 'apple';
    
-- id가 apple인 고객의 주문 제품을 확인
select distinct 제품명 from 주문
	join 제품
    on 주문제품 = 제품번호
    where 주문고객 = 'apple';
    
-- 콩떡파이를 주문한 고객명단 확인
select distinct 주문고객 from 주문
	join 제품
    on 주문제품 = 제품번호
    where 제품명 = '쿵떡파이';