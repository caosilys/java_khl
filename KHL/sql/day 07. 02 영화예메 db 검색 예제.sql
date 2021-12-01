-- cgv 강남지점 12월 1일 상영시간표를 확인 

select 
th_name as '영화관명', 	mo_title as '영화제목',
mg_ge_name as '장르',		sc_date as '상영일자',	
sc_time as '상영시간',		sc_seat as '잔여좌석',
mo_detail as '상세' 
from schedule
join theater on theater.th_num = schedule.th_num
join movie on schedule.mo_num = movie.mo_num
join movie_genre on movie.mo_num = mg_mo_num
where sc_date = '2021-12-01' and th_name = 'CGV강남';


-- 12월 1일 21:20분 강남CGV 1관에서하는 영화에서 예매가능한 좌석을 확인 

-- ()안의 내용 -> cgv강남, 1관의 좌석정보
select st_room_num, th_name, st_name from seat
	join theater on seat.th_num = theater.th_num
	where th_name = 'CGV강남' and st_room_num = '1';

select st_name from seat
	left join 
    (select * from ticketing_list
	join ticketing on ti_num = tl_ti_numticketing_list
    where ticketing.sc_num = 2) as tl
    on seat.st_num = ti_st_num
    where seat.th_num = 1 and seat.st_room_num = 1 
    and tl_ti_num is null;