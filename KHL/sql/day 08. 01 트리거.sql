/* 
트리거 : 테이블에 데이터가 추가, 수정, 삭제 될 떄 발생하는 이벤트
	데이터 무결성을 지킬 수 있다 => 연관된 테이블간의 데이터 일관성을 유지

형식
delimiter //
create trigger 트리거명 after|before 이벤트명(insert|update|delete) on 테이블명
for each row
begin
-- 실행코드
end //
delimiter;

 - old : update 이벤트 발생 할 때 사용가능한 코드. 값이 바뀌기 전의 행
 - new : insert, update 이벤트 발생할 때 사용하는 코드. 값이 바뀐후의 행 또는 새로추가된 헹
 
 declare 변수명 자료형 default 기본값
 - 변수값 변경 방법 
 set 변수명 = 값;
 set 변수명 = (select를 이용한 검색결과)

insert 트리거에서 새로 추가된 행에 update를 못함. 이럴 땐 프로시저를 이용해야 함.
트리거는 이벤트마다 동일하게 처리하는 경우 사용. 아니면 프로시저를 이용 

통신사에서 작년 사용금액을 기준으로 올해 등급을 결정하는 과정을 하려 한다.
이때는 프로시져를 사용. 

제품을 구매할 떄마다 구매 금액의 10프로를 포인트로 지급하려 한다.
이때는 트리거를 사용
*/

use fruit_khl;

drop trigger if exists insert_buy;

-- delimiter //
-- create trigger insert_buy after insert on buy
-- for each row
-- begin
-- 		update fruit set fr_amount = fr_amount + new.bu_amount
--         where fr_name = new.bu_fr_name;
-- end // 
-- delimiter ;

-- 트리거 확인을 위해 buy 테이블에 행을 추가 / 확인
-- insert into buy value(2, '바나나', 50, now(), '송이', '과일상회');
select * from buy;
select * from fruit;

show triggers;

-- 과일을 판매했을 떄 과일 수량을 맞춰주는 트리거를 만들어보세요. 
-- SELECT * FROM fruit_khl.sell;

-- delimiter //
-- 	create trigger insert_sell after insert on sell
--     for each row
--     begin
-- 		declare _amount int default 0;
--         set _amount = new.se_amunt;
-- 		update fruit set fr_amount = fr_amount - _amount
--         where fr_name = new.se_fr_name;
--     end
-- // delimiter ;

-- insert into sell value(2, '바나나', 10, '송이', 40000, now(), '현금');

select * from fruit;



