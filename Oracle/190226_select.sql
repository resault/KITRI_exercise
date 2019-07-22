-- decode

-- 사번, 이름, 부서번호, 직원유형
-- 직원유형
-- 부서번호 60 개발자
--          90 임원진
--          나머지 비개발자
select employee_id 사번, first_name 이름, department_id 부서번호,
        case
            when department_id = 60
            then '개발자'
            when department_id = 90
            then '임원진'
            else '비개발자'
        end 직원유형
from employees
order by 직원유형, 부서번호;

select employee_id 사번, first_name 이름, department_id 부서번호,
        decode(department_id,
                60, '개발자',
                90, '임원진',
                '비개발자') 직원유형
from employees
order by 직원유형, 부서번호;



-- 그룹함수
-- 회사의 총사원수, 급여총합, 급여평균, 최고급여, 최저급여
select count(employee_id), sum(salary), avg(salary), max(salary), min(salary)
from employees;

-- 평균급여보다 많이 받는 사원의 사번, 이름, 급여
select employee_id, first_name, salary
from employees
where salary > avg(salary);


-- [Join]

-- 사번, 이름, 부서번호, 부서이름
select employee_id, first_name, department_id, department_name -- 부서이름은 직원 테이블에 없는 컬럼임
from employees;

select department_id, department_name
from departments;

-- cartesian join (cross join)
--  >> 테이블 두개를 반환하게 하려면 from 절에 테이블 두개 입력??
select *
from employees, departments -- >> 직원 테이블과 부서 테이블이 1:1 매핑되어버림. (카타시안 프로덕트)
order by employee_id; 

-- equi join (natural join)
-- >> Join 사용
select employees.employee_id, employees.first_name, employees.department_id, departments.department_name
-- 부서테이블의 부서번호를 가져와도 됨. 나머지는 테이블표시를 안해도 되지만, 가독성을 위해 보통 표기함
from employees, departments
where employees.department_id = departments.department_id -- 부서번호가 없는 킴벌리는 누락됨. null값은 equal 비교도 불가
order by employee_id;

select a.employee_id, a.first_name, a.department_id, b.department_name
from employees a, departments b -- 테이블에 alias 적용
where a.department_id = b.department_id
order by employee_id;

-- 'seattle'에 근무하는 사원의 사번, 이름, 부서이름, 도시이름
select a.employee_id, a.first_name, b. department_name, c.city
from employees a, departments b, locations c
where a.department_id = b.department_id and b.location_id = c.location_id and
        lower(c.city) = lower('seattle');
        
        
-- 'asia'에 근무하는 사번, 이름, 부서이름, 도시이름
select e.employee_id, e.first_name, d.department_id, l.city
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id
            and d.location_id = l.location_id
            and l.country_id = c.country_id
            and c.region_id = r.region_id
        and lower(r.region_name) = lower('europe');


-- 10, 80, 90번 부서에 근무중인 사원의
-- 사번, 이름, 직책이름, 부서이름
select e.employee_id, e.first_name, j.job_title, d.department_name
from employees e, jobs j, departments d
where e.job_id = j.job_id
            and e.department_id = d.department_id
        and e.department_id in (10, 80, 90);



-- 사번이 200인 사원의 근무 이력
-- 사번, 이름, 직책이름, 부서이름, 근무개월수(소수점 둘째자리까지)
select e.employee_id 사번, e.first_name 이름, j.job_title 직책이름, d.department_name 부서이름,
        round(months_between(h.end_date, h.start_date), 2) 근무개월수 -- round보다는 to_char를 많이 사용함
from employees e, job_history h, jobs j, departments d
where e.employee_id = h.employee_id
            and h.job_id = j.job_id
            and h.department_id = d.department_id
        and h.employee_id = 200;

select e.employee_id 사번, e.first_name 이름, j.job_title 직책이름, d.department_name 부서이름,
        to_char(months_between(h.end_date, h.start_date), '999.99') 근무개월수 -- to_char 사용하면 소수점 뒷 자리가 0으로 표현됨
from employees e, job_history h, jobs j, departments d
where e.employee_id = h.employee_id
            and h.job_id = j.job_id
            and h.department_id = d.department_id
        and h.employee_id = 200;

-- @@ 위 문제에다가 현재 직책이름과 부서이름도 row로 추가할 수 있나?
select e.employee_id 사번, e.first_name 이름, j.job_title 직책이름, d.department_name 부서이름,
        to_char(months_between(h.end_date, h.start_date), '999.99') 근무개월수,
        ej.job_title 현직책, ed.department_name 현부서 -- 이렇게 하면 컬럼이 추가되어 버림. 다중행?? 그걸 배워야 할 수 있는듯
from employees e, job_history h, jobs j, departments d, jobs ej, departments ed
where e.employee_id = h.employee_id
            and h.job_id = j.job_id
            and h.department_id = d.department_id
            and e.job_id = ej.job_id
            and e.department_id = ed.department_id
        and h.employee_id = 200;


-- self join
-- 모든 사원의 부서이름, 사번, 이름, 매니저사번(직속상관), 매니저이름
select d.department_name 부서이름, e.employee_id 사번, e.first_name 이름,
        e.manager_id "직속상관 사번", em.first_name "직속상관 이름"
from employees e, departments d, employees em
where e.department_id = d.department_id
        and e.manager_id = em.employee_id;



---- 이건 2/27 참고
-- 직책 아이디가 'SA_REP'인 사원의
-- 사번, 이름, 직책이름, 부서이름
-- 단, 부서가 없는 경우 '대기발령'으로 출력
select e.employee_id, e.first_name, j.job_title,
        case 
            when e.department_id is not null
            then d.department_name
            else '대기발령'
        end 부서이름
from employees e, jobs j, departments d
where e.job_id = j.job_id
            and e.department_id = d.department_id -- 여기서 킴벌리 누락됨
        and lower(e.job_id) = lower('SA_REP');
