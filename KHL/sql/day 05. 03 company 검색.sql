-- 홍길동 사원의 급여를 확인하는 쿼리문
select (sa_base_salary+sa_add_salary*em_year) as '홍길동 월급' 
from employee
join salary on em_sa_level = sa_level
where em_num = 2019001;

-- 각 부서별 평균 급여를 출력하는 쿼리를 작성.
-- 단 직원이 등록된 부서만.

select em_de_department, (sa_base_salary+sa_add_salary*em_year) as '부서별급여' 
from employee
join salary on em_sa_level = sa_level
group by em_de_department;