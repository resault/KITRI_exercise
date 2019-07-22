-- 급여를 5000이상 받는 사원의 사번, 이름, 급여, 부서번호
select employee_id, first_name, salary, department_id
from employees
where salary >= 5000;

-- 사번이 100번인 사원의 사번, 이름, 부서번호
select employee_id, first_name, department_id
from employees
where employee_id = 100;

-- 근무도시가 seattle인 지역의 지역번호, 우편번호, 도시
select location_id, postal_code, city
from locations
where city = 'Seattle';

-- 급여를 5000이상 12000미만 받는 사원의 사번, 이름, 급여, 부서번호
select employee_id, first_name, salary, department_id
from employees
where salary >= 5000 and salary < 12000;

-- 부서번호가 50인 사원 중 급여를 5000이상 받는 사원의 사번, 이름, 급여, 부서번호
select employee_id, first_name, salary, department_id
from employees
where department_id = 50 and salary >= 5000;

-- 급여를 5000이상 12000이하 받는 사원의 사번, 이름, 급여, 부서번호
select employee_id, first_name, salary, department_id
from employees
where salary >= 5000 and salary <= 12000;

select employee_id, first_name, salary, department_id
from employees
where salary between 5000 and 12000;

-- 커미션을 받는 사원의 사번, 이름, 급여, 커미션포함급여
select employee_id, first_name, salary, commission_pct, salary*(1+commission_pct)
from employees
where commission_pct > 0;

select employee_id, first_name, salary, salary*(1+commission_pct), commission_pct
from employees
where commission_pct is not null;

-- 근무부서가 50, 60, 80인 사원의 사번, 이름, 부서번호
select employee_id, first_name, department_id
from employees
where department_id = 50 or department_id = 60 or department_id = 80;

-- 근무부서가 50, 60, 80가 아닌 사원의 사번, 이름, 부서번호
select employee_id, first_name, department_id 
from employees
where department_id != 50 and department_id != 60 and department_id != 80 or department_id is null ;

-- 근무부서가 50, 60, 80인 사원의 사번, 이름, 부서번호
select employee_id, first_name, department_id
from employees
where department_id in (50, 60, 80);

-- 근무부서가 50, 60, 80가 아닌 사원의 사번, 이름, 부서번호
select employee_id, first_name, department_id 
from employees
where department_id not in (50, 60, 80);

-- 급여가 3000 이상이거나, 8000 이상이거나, 5000 이상인 사원의 사번, 이름, 급여
select employee_id, first_name, salary
from employees
where salary >= 3000 or salary >= 8000 or salary >= 5000;

-- 급여가 3000 이상이거나, 8000 이상이거나, 5000 이상인 사원의 사번, 이름, 급여
select employee_id, first_name, salary
from employees
where salary >= any (3000, 8000, 5000);

-- 급여가 3000 이상이고 8000 이상이고, 5000 이상인 사원의 사번, 이름, 급여
select employee_id, first_name, salary
from employees
where salary >= 3000 and salary >= 8000 and salary >= 5000;

-- 급여가 3000 이상이고 8000 이상이고, 5000 이상인 사원의 사번, 이름, 급여
select employee_id, first_name, salary
from employees
where salary >= all (3000, 8000, 5000);

-- 현재 시간, 3일 후, 3시간 후
select sysdate, to_char(sysdate, 'yy.mm.dd hh24:mi:ss') "현재 시간",
        to_char(sysdate + 3, 'yy.mm.dd hh24:mi:ss') "3일후", 
        to_char(sysdate + 3/24, 'yy.mm.dd hh24:mi:ss') "3시간 후",
        to_char(sysdate - 3, 'yy.mm.dd hh24:mi:ss') "3일전",
        to_char(sysdate - 3/1440, 'yy.mm.dd hh24:mi:ss') "3분 전"
from dual;

-- 이름이 Steven인 사원의 사번, 이름
select employee_id, first_name
from employees
where first_name = 'Steven';

-- 이름이 'S'로 시작하는 사원의 사번, 이름
select employee_id, first_name
from employees
where first_name like 'S%';

-- 이름에 'e'를 포함하고 있는 사원의 사번, 이름
select employee_id, first_name
from employees
where first_name like '%e%';

-- 이름이 'y'로 끝나는 사원의 사번, 이름
select employee_id, first_name
from employees
where first_name like '%y';

-- 이름의 끝에서 세번째가 'e'인 사원의 사번, 이름
select employee_id, first_name
from employees
where first_name like '%e__';

-- 부서번호가 50이 아닌 사원의 사번, 이름, 부서번호
select employee_id, first_name, department_id
from employees
where department_id != 50;

select employee_id, first_name, department_id
from employees
where department_id ^= 50;

select employee_id, first_name, department_id
from employees
where department_id <> 50;

-- 모든 사원의 사번, 이름, 급여
-- 단, 급여순 정렬
select employee_id, first_name, salary
from employees
order by salary desc;

-- 부서번호, 사번, 이름, 급여
-- 부서별 급여순으로 정렬
select department_id, employee_id, first_name, salary
from employees
order by department_id, salary desc;

select department_id did, employee_id, first_name, salary sal
from employees
order by did, sal desc;

-- 근무도시가 'Seattle'인 사원의 사번, 이름, 부서번호
select city, location_id
from locations
where city = 'Seattle';

select location_id, department_id
from departments
where location_id = 1700;

select employee_id, first_name, department_id
from employees
where department_id in (10, 90, 110, 190);

