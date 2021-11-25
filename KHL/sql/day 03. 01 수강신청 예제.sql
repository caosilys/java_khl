

-- 2021160001 학번 학생이 1번 강의인 컴퓨터 개론 3분반 강의를 신청했다
--  insert into course(co_st_num, co_su_num) values(2021160001,1);  

-- 2021160123학번 홍길동 학생이 수강중인 컴퓨터 개론 3분반 성적이 A+이 나왔다
-- 문제 / 답에 문제가 있음...
-- update course set co_score = 'A+' 
-- where co_st_num = '2021160123' and co_su_num = 1;

-- 2021160015 학생이 컴퓨터 개론 3분반 강의를 신청했다
-- insert into course (co_st_num, co_su_num) 
-- select 2021160015, su_num from subject where su_class_num = 3 and su_title = '컴퓨터 개론';
