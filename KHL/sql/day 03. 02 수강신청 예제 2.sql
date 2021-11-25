select st_num, st_name from course
	join subject
		on co_su_num = su_num
    join student
		on co_st_num = st_num
	where su_title = '컴퓨터 개론' and su_class_num = 3;

-- 2021160123 학번인 학생이 수강한 과목명을 확인하는 쿼리
select su_title from course
	join subject
		on co_su_num = su_num
	where co_st_num = 2021160123;
    
-- 이순신 교수님의 강의를 듣는 학생들 명단을 확인
select st_name from lecture
	join professor on pr_num = le_pr_num
    join course on co_su_num = le_su_num
    join student on co_st_num = st_num
    where pr_name = '이순신';

-- 홍길동학생이 수강한 수강 과목의 수
select count(*) from course
	join student
    on st_num = co_st_num
	where st_name = '홍길동';

-- 컴퓨터 개록 3분반 현재 수강 신청 학생수를 확인하는 쿼리
select count(*) from course
join subject
on co_su_num = su_num
where su_title = '컴퓨터 개론' and su_class_num = 3;

-- 이순신 교수님이 강의하는 강의 수
select count(*) from lecture
	join professor
    on le_pr_num = pr_num where pr_name = '이순신';
    
select count(*) from lecture 
join (select * from professor where pr_name='이순신') as t on pr_num = le_pr_num;
