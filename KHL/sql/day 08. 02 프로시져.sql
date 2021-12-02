/*
프로시져 : 쿼리의 집합으로 함수라고 생각하면 됨

- 장점 
	1. 하나의 요청으로 여러 sql 쿼리문을 실행할 수 있다 => 네트워크 부하를 줄일 수 있다.
    2. 처리시간이 줄어든다
    3. 응용 프로그램 속 로직을 가지지 않고도 데이터의 앞뒤가 맞게 할 수 있다.
    4. 보수성이 뛰어나다..?
- 단점 
	1. 재사용성이 나쁘다
    2. 업무의 사양 변경시 프로시져의 정으를 변경할 필요가 있다
    
  - 프로지저 정의 
  delimiter //
  create procedure 프로시저명 
  (
	[in|out] 변수명 타입, 
    ...
	[in|out] 변수명 타입
  )
  begin
  -- 실행코드 
  end // delimiter ;
  
  -프로시저 호출
  call 프로시저명 (변수나 값들)
  
*/

use fruit_khl;
-- 과일 판매시 판매 금액을 자동으로 입력하여 판매 정보를 sell 테이블에 추가하는 프로시져
	
drop procedure if exists insert_sell;

  delimiter //
  create procedure insert_sell 
  (
	in in_fr_name varchar(50),
    in in_amount int,
    in in_unit varchar(50),
    in in_type varchar(50)
  )
  begin
  declare _total_price int default 0; 	-- 총 가격
  declare _price int default 0;			-- 개당 가격
  set _price = (select fr_price from fruit where fr_name = in_fr_name);
  set _total_price = in_amount * _price;
  insert into sell 
	select max(se_num)+1, in_fr_name, in_amount, in_unit, _total_price, now(), in_type
    from sell ;
  end // delimiter ;

select * from sell;


call insert_sell('딸기', 3, '상자', '카드');

drop procedure if exists insert_sell2;

  delimiter //
  create procedure insert_sell2 
  (
	in in_fr_name varchar(50),
    in in_amount int,
	in in_type varchar(50)
  ) 
  begin
  declare _total_price int default 0; 	-- 총 가격
  declare _price int default 0;			-- 개당 가격
  declare _unit varchar(50);
  set _price = (select fr_price from fruit where fr_name = in_fr_name);
  set _total_price = in_amount * _price;
  set _unit = (select fr_unit from fruit where fr_name = in_fr_name);
  
  insert into sell 
	select max(se_num)+1, in_fr_name, in_amount, _unit, _total_price, now(), in_type
    from sell;
    
  end // delimiter ;
  
  call insert_sell2('딸기', 10, '현금');
  
  
  