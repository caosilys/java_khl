-- cgv 홈페이지에서 영화 듄 정보를 이용하여 영화정보 / 인물 등 필요한정보를 추가 
use cgv;

-- insert into genre values
-- ('가족'),('공포/호러'),('드라마'),('SF'),('멜로/로맨스'),
-- ('코미디'),('애니메이션'),('느와르'),('단편'),('다큐멘터리'),
-- ('로드무비'),('무협'),('뮤지컬'),('뮤직'),('미스터리'),
-- ('범죄'),('옴니버스'),('서부'),('스릴러'),('스포츠'),
-- ('시대극/사극'),('아동'),('액셕'),('어드벤처'),('역사'),
-- ('전기'),('전쟁'),('종교'),('재난'),('청춘영화'),
-- ('퀴어'),('환타지'),('학원물'),('에로');

-- insert into movie
-- (mo_num, mo_title, mo_age, mo_runtime, mo_date, mo_detail)
-- values (1, '듄', '12세이상', 155, '2021-10-20', '"듄을 지배하는자가 우주를 지배한다!"');

-- insert into movie_genre 
-- (mg_num, mg_ge_name, mg_mo_num)
-- values (1, 'SF', 1);

--  insert into `character`
--  (ch_num, ch_name, ch_birthday, ch_country, ch_job)
--  values 
--  (1, '티모시 살라메', '1995.12.27', null ,'배우'),
--  (2, '레베카 퍼커슨', '1986.10.19', '스웨덴', '배우'),
--  (3, '드니 뵐뇌브','1967.10.03', '캐나다', '영화감독, 시나리오작가');

-- select * from participation;
-- insert into participation
-- (pt_num, pt_mo_num, pt_ch_num, pt_role)
-- values (1, 1, 1, '주연'), (2, 1, 2, '주연'), (3, 1, 3, '감독');

-- cgv 홈페이지에서 강남점 정보를 이용하여 db에 추가
-- 상영시간표 x, 좌석은 A1~5, B1~5. 상영관은 총 3개

-- insert into theater 
--  (th_num, th_area, th_name, th_address, th_traffic, th_parking, th_room_count, th_seat_count)
--  values (1, '서울', 'CGV강남',
-- "서울특별시 강남구 역삼동 814-6 스타플렉스
-- 서울특별시 강남구 강남대로 438 (역삼동)",

-- "# 지하철
-- 2호선 | 강남역 11번 출구
-- 9호선 | 신논현역 5번출구

-- # 버스
-- - 분당지역
--    좌석버스: 1005-1, 1005-2, 6800, 5500-2
--    간선버스: 408, 462
--    광역버스: 9404, 9408
-- - 강북지역
--    간선버스: 140, 144, 145, 471
-- - 강서지역
--    좌석버스: 1500
--    간선버스: 360
-- - 강동지역
--    간선버스: 402, 420, 470, 407
-- - 인근경기지역
--    좌석버스: 3030, 2002, 2002-1
--    광역버스: 9409, 9500, 9501, 9503, 9700, 9711'
--    ,'# 주차정보
-- - 위치: 건물 지하2F ~ 지하4F",

-- "# 주차요금
-- - CGV 영화 관람 시 주차 3시간 6,000원
-- - 주차시간 (3시간) 초과 시 10분 당 1,000원
-- ※ 발렛서비스 운영시간 : 오전 8시 이후 ~ 오후 20시

-- ※ 발렛 무료 서비스는 영화 관람 고객 한 함.  (영화 미관람 시 건물 주차장에서 별도 정산)
-- ※ 20시 이후 입차 차량은 발렛서비스 이용이 제한될 수 있으며, 별도 운영되는 주차팀의 사정에 따라 변경될 수 있습니다.",
-- 3, 30);

-- insert into seat
-- (st_name, st_th_num, st_room_num)
-- values 
-- ('A1', 1, 1),('A2', 1, 1),('A3', 1, 1),('A4', 1, 1),('A5', 1, 1),
-- ('B1', 1, 1),('B2', 1, 1),('B3', 1, 1),('B4', 1, 1),('B5', 1, 1),
-- ('A1', 1, 2),('A2', 1, 2),('A3', 1, 2),('A4', 1, 2),('A5', 1, 2),
-- ('B1', 1, 2),('B2', 1, 2),('B3', 1, 2),('B4', 1, 2),('B5', 1, 2),
-- ('A1', 1, 3),('A2', 1, 3),('A3', 1, 3),('A4', 1, 3),('A5', 1, 3),
-- ('B1', 1, 3),('B2', 1, 3),('B3', 1, 3),('B4', 1, 3),('B5', 1, 3);

-- cgv 영화 듄, 강남지정, 12월 1~3일 상영시간표를보고 db에 추가

-- insert into schedule
-- (sc_num, sc_mo_num, sc_th_num, sc_date, sc_time,
--  sc_room_num, sc_option, sc_total_seat, sc_seat)
-- values
-- (1, 1, 1, '2021-12-01', '15:45', 1, '2D', 10, 10),
-- (2, 1, 1, '2021-12-01', '21:20', 1, '2D', 10, 10),
-- (3, 1, 1, '2021-12-02', '10:20', 1, '2D', 10, 10),
-- (4, 1, 1, '2021-12-02', '16:20', 1, '2D', 10, 10),
-- (5, 1, 1, '2021-12-02', '19:30', 1, '2D', 10, 10),
-- (6, 1, 1, '2021-12-03', '10:30', 1, '2D', 10, 10),
-- (7, 1, 1, '2021-12-03', '16:30', 1, '2D', 10, 10),
-- (8, 1, 1, '2021-12-03', '19:45', 1, '2D', 10, 10);


-- 아이디 abc123, 비번 abc 123인 회원이 가입
-- insert into member values ('abc123','abc123'); 

-- abc123 회원이 12월 1일 21:20분 영화 듄을 A1, A2 2자리를 예매 

-- 1. 티케팅 정보입력 2개, 스케쥴표 2번(12.01 21:20)
-- insert into ticketing(ti_num, ti_me_id, ti_sc_num)
-- values(1, 'abc123', 2), (2, 'abc123', 2);

-- 2. 잔여좌석수 변경
-- update schedule set sc_seat = sc_seat-2
-- where sc_date = '2021-12-01' and sc_time = '21:20' and sc_room_num=1;

-- 3. 티케팅리스트 추가
-- insert into ticketing_list (tl_num, tl_ti_num, tl_st_num)
-- values(1, 1, 1), (2, 2, 2); <-- 틀림

select * from ticketing;
select * from ticketing_list;

-- 1. 예매에 데이터 추가 (select 사용)
/*
insert into ticketing select 1, 'abc123', sc_num from schedule 
	where sc_date = '2021-12-01' and sc_time = '21:20' and sc_room_num = 1;
*/
-- 2. 예매 리스트에 데이터 추가
/*
insert into ticketing_list select 1, 1, st_num from seat 
	where st_room_num = 1 and st_name = 'A1';
insert into ticketing_list select 2, 1, st_num from seat 
	where st_room_num = 1 and st_name = 'A2';
/*
-- 3. 상영시간 정보를 수정
/*
update schedule set sc_seat = sc_seat - 2 
	where sc_date = '2021-12-01' and sc_time = '21:20' and sc_room_num = 1;



