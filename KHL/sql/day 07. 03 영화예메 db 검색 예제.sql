-- cgv 강남지점 12월 1일 상영시간표를 확인 

select 
th_name as '영화관명', 	mo_title as '영화제목',
mg_ge_name as '장르',		sc_date as '상영일자',	
sc_time as '상영시간',		sc_seat as '잔여좌석',
mo_detail as '상세' 
from schedule
join theater on th_num = sc_th_num
join movie on sc_mo_num = mo_num
join movie_genre on mo_num = mg_mo_num
where sc_date = '2021-12-01' and th_name = 'CGV강남';

-- CGV강남, 12월1일 21:20분 1관에서 하는 영화에서 예매 가능한 좌석을 확인

-- CGV강남점 1관의 전체 좌석 정보
select th_name, st_room_num, st_name from seat join theater on th_num = st_th_num 
	where th_name = 'CGV강남' and st_room_num = 1;
    
select st_room_num, st_name from seat where st_th_num = 1;

-- CGV강남, 12월1일 21:20분 1관에서 하는 영화 예매 내역
select * from ticketing_list 
	join ticketing on tl_ti_num = ti_num 
    join schedule on ti_sc_num = sc_num
    where sc_th_num = 1 and sc_room_num = 1 
		and sc_date = '2021-12-01' and sc_time = '21:20';
        
select * from ticketing_list 
	join ticketing on tl_ti_num = ti_num 
    where ti_sc_num = 2;

-- 예약 가능한 좌석 확인
select st_name from seat left 
	join (select * from ticketing_list 
			join ticketing on tl_ti_num = ti_num 
			where ti_sc_num = 2) 
		as tl 
	on st_num = tl_st_num
    where st_th_num = 1 and st_room_num = 1 and tl_num is null;