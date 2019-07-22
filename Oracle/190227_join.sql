-- non equi join
-- 모든 사원의 사번, 이름, 급여, 급여등급
select e.employee_id, e.first_name, e.salary, g.grade_level
from employees e, job_grades g
where e.salary between g.lowest_sal and g.highest_sal 
order by e.salary desc;


-- outter join
-- 모든 사원의 사번, 이름, 부서번호, 부서이름
-- 단, 부서가 미지정일 경우 부서이름을 '대기발령중'으로 출력
select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '대기발령중')
from employees e, departments d
where e.department_id = d.department_id(+);


select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '대기발령중')
from employees e, departments d
where e.department_id(+) = d.department_id; --- 위 코드와 결과값 다름!


-- 모든 사원의 사번, 이름, 상관사번, 상관이름
-- 단, 상관이 없을 경우 상관이름에 '사장'으로 출력
select e.employee_id, e.first_name, e.manager_ID, nvl(m.first_name, '사장')
from employees e, employees m
where e.manager_id = m.employee_id(+);


-- 모든 사원의 사번, 이름, 상관사번, 상관이름, 부서이름
-- 단, 상관이 없을 경우 상관이름에 '사장'으로 출력
-- 단, 부서가 미지정일 경우 부서이름을 '대기발령중'으로 출력 
select e.employee_id 사번, e.first_name 이름, e.manager_id 상관사번,
        nvl(m.first_name, '사장') 상관이름,
        nvl(d.department_name, '대기발령중') 부서이름
from employees e, employees m, departments d
where e.manager_id = m.employee_id(+)
        and e.department_id = d.department_id(+);

-- 오답체크
select e.employee_id 사번, e.first_name 이름, e.manager_id 상관사번,
        nvl(m.first_name, '사장') 상관이름,
        nvl(d.department_name, '대기발령중') 부서이름
from employees e, employees m, departments d
where e.manager_id = m.employee_id(+)
        and m.department_id = d.department_id(+); -- m의 department_id를 가져오면 manager의 부서명이 나와버림


-- ANSI Join
-- Cross Join
select *
from employees, departments;  -- oracle join (katesian join)

select *
from employees cross join departments; --- ansi join (cross join)


-- Inner Join
-- 50번 부서의 사번, 이름, 부서이름
select e.employee_id, e.first_name, d.department_name
from employees e, departments d     -- oracle join (equi joini)
where e.department_id = d.department_id
        and e.department_id = 50;


select e.employee_id, e.first_name, d.department_name
from employees e join departments d       -- ansi join (inner join)
on e.department_id = d.department_id
where e.department_id = 50;     -- on절 안에서 and를 붙여도 되긴 하나 권장X (cross 조인 결과값 안에서 추가로 조건 검색을 하므로 비효율적임)


-- using 절 이용
select e.employee_id, e.first_name, d.department_name
from employees e join departments d      -- inner 생략 가능
using (department_id)
where e.department_id = 50; -- using절에 이용하는 컬럼은 테이블 지정하면 에러 발생함


select e.employee_id, e.first_name, d.department_name
from employees e join departments d      -- inner 생략 가능
using (department_id)       -- using절 이용
where department_id = 50;


-- natural join
select e.employee_id, e.first_name, d.department_name
from employees e natural join departments d 
where department_id = 50;


-- join할 table 추가
-- 'seattle'에 근무하는 사번, 이름, 부서이름, 도시
select e.employee_id, e.first_name, d.department_name, l.city
from employees e, departments d, locations l    -- oracle join
where e.department_id = d.department_id
            and d.location_id = l.location_id
        and lower(l.city) = lower('seattle');


select e.employee_id, e.first_name, d.department_name, l.city
from employees e join departments d     -- ansi join
                    on e.department_id = d.department_id
                        join locations l
                            on d.location_id = l.location_id
where lower(l.city) = lower('seattle');

-- outter join 확인
-- 모든 사원의 사번, 이름, 부서번호, 부서이름
-- 부서가 미지정인 경우 부서이름은 '대기발령중'
select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '대기발령중')
from employees e, departments d
where e.department_id = d.department_id(+);


select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '대기발령중') -- nvl은 oracle 함수임
from employees e left outer join departments d
on e.department_id = d.department_id;



-- 모든 부서에 근무하는 사원의 사번, 이름(사원없음), 부서번호, 부서이름
select e.employee_id, nvl(e.first_name, '사원없음'), d.department_id, d.department_name 
from departments d, employees e     -- oracle join
where d.department_id = e.department_id(+);



select e.employee_id, nvl(e.first_name, '사원없음'), d.department_id, d.department_name 
from employees e right outer join departments d 
on d.department_id = e.department_id(+);



-- 모든 부서에 근무하는 모든 사원의 사번, 이름(사원없음), 부서번호, 부서이름
select e.employee_id, nvl(e.first_name, '사원없음'),
        d.department_id, nvl(d.department_name ,'대기발령')
from departments d, employees e     -- oracle join
where d.department_id(+) = e.department_id(+); -- 에러 발생


select e.employee_id, nvl(e.first_name, '사원없음'),
        d.department_id, nvl(d.department_name ,'대기발령')
from departments d full outer join employees e
on d.department_id = e.department_id;
