-- 카테고리 추가

-- use shoppingmall;
-- 카테고리 추가
-- insert into category (ca_main, ca_sub)
-- 	values ('아우터','점퍼'), ('아우터','코트'), ('상의','티셔츠'), 
--     ('상의','블라우스/셔츠'), ('하의','데님'), ('하의','팬츠'),
--     ('하의','스커트');

-- insert into goods values 
-- (1, '아크 콕스터 패딩', 159000, '패딩입니다', 1),
-- (2, '엘비아 앙모코트', 229000, '앙모코트입니다', 2),
-- (3, '클로 다운후드', 99000, '다운 후드입니다', 3),
-- (4, '파코 레이어드탑', 43000, '탑', 4),
-- (5, '기모 와이드 데님 팬츠', 43000, '팬츠입니다', 5),
-- (6, '롤스 버튼 팬츠', 36000, '팬츠입니다', 6);

/*
아이디가 abc123 비밀번호 abc123, 이름 홍길동 폰 010-1234-5678
성별 남, 주소 청주시, 우편본호 1234, 주소 상세 그린컴퓨터학원
화원가입 순서 1 member에 insert -> address에 insert -> member에 update
순서 2 address에 insert -> member에 insert
*/
-- insert into address
-- values (1, null, '청주시', '1234', '그린컴퓨터학원');

-- insert into member 
-- values ('abc123', 'abc123', '홍길동','010-1234-5678', '남자','1');

-- 아크 콕스터 패딩이 크기가 s, 색상은 화이트인 제품 10개가 최초입고
-- insert into `option` 
-- (op_num, op_color, op_size, op_stock, op_gd_num)
-- values (1, '화이트', 's', 10, 1);

-- abc123 회원이 주문한 아크 콕스터 패딩에 리뷰를 작성 
-- select * from review;
-- insert into review values(1, '패딩 좋아요', '따뜻하고 좋아요', now(), 5, 1, 'abc123');

select * from shoppingmall.option;

-- abc123 회원이 아크 폭스터 패딩을 화이트 s사이즈 1개 구매
select * from shoppingmall.order;
insert into `order` 
(or_num, or_me_id, or_op_num, or_date, or_amount, or_total_price, or_state)
values ('2021HNT001', 'abc123', 1, now(), 1, 159000, '결재완료');
update `option` set op_stock = op_stock-1 where op_num = 1;

-- 아우터인 모든 제품을 확인하는 쿼리
select gd_name as '아우터인 제품' from `goods`
join `category` on ca_num = gd_ca_num
where ca_main = '아우터';

-- 구매가능한 아우터 제품 확인
select gd_name as '구매가능한 아우터' from `goods`
join `category` on ca_num = gd_ca_num
join `option` on gd_num = op_gd_num
where ca_main = '아우터' and op_stock !=0;

-- 분류가 아우터이고, 가장 많이 팔린 제품 4가지 확인

select gd_name as '판매량 top4', sum(or_amount) as '판매량' from `order`
join `option` on or_op_num = op_num
join `goods` on op_gd_num = gd_num
join `category` on gd_ca_num = ca_num
where ca_main ='아우터' and or_state != '주문취소' 
group by gd_num
order by sum(or_amount) desc
limit 4;

-- 등록된 아우터 제품의 전체 등록된 제품의 갯수 확인하는 쿼리 작성 
select count(*) as '등록된 제품 수' from `goods`
join `category` on gd_ca_num = ca_num
where ca_main = '아우터';

-- 등록된 아우터 제품을 10개씩 화면에 출력할 때 2페이지에 해당하는 제품을 확인하는 쿼리
select * from goods
join category on gd_ca_num = ca_num
where ca_main = '아우터'
limit 10, 10;

-- abc123 회원이 주문한 횟수
select count(*) as 'abc123 회원의 주문수' from `order`
where or_me_id = 'abc123';


-- abc123 회원이 상반기 사용금액
select sum(or_total_price) as 'abc123의 상반기 사용금액' from `order`
where or_me_id = 'abc123' and 
	  date(or_date) between 2021-01-01 and 2021-06-30;
      -- or_date like '2021%' and or_date < '2021-07-01'

-- 아크콕스터 패딩에 달린 리뷰들을 확인
select re_me_id, re_title, re_contents, re_date from review
join goods on re_gd_num = gd_num
where gd_name = '아크 콕스터 패딩';
