-- 모든 사원의 모든 정보
select *
from employees;

-- 사원의 사번, 이름, 급여
select employee_id, first_name, salary
from employees;

-- 부서의 부서번호, 부서이름
select department_id, department_name
from departments;

-- 부서번호 (employees 기준)
select distinct department_id, employee_id
from employees;




select 1+1, 10-5, 2*10, 10/3
from dual;

-- 사번, 이름, 급여, 200인상 급여(급여200)
select employee_id as "사번", first_name "이름", salary 급여, salary+200 "급여 200"
from employees;

-- 사번, 이름, 급여, 커미션 포함 급여
select employee_id as "사번", first_name as 이름, salary 급여,
        nvl(commission_pct,0) 커미션, salary*(1+nvl(commission_pct,0)) "커미션 포함"
from employees;


-- 사번, 이름(풀네임)
select employee_Id, first_name || ' ' || last_name name
from employees;

-- 사번이 100번인 사원의 이름은 Steven King입니다.(info)
select '사번이 ' || employee_id || '인 사원의 이름은 ' || first_name || ' ' || last_name || '입니다.' info
from employees;

select *
from employees;

-- 출제1 : 사번(사번), 입사일(입사일), 커미션 포함 급여(급여_커미션 포함)
select employee_id 사번, hire_date 입사일, salary*(1+nvl(commission_pct,0)) "급여_커미션 포함"
from employees;

-- 출제2 : "President"의 최대 급여는 40000입니다.    형태로 출력. 컬럼이름은 비고
select '"' || job_title || '"의 최대 급여는 ' || max_salary || '입니다.'
from jobs;