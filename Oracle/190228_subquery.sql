
-- [JOIN 과 SUBQUERY]

-- 2. SubQuery

-- 부서이름이 'IT'에 근무하는 사원의 사번, 이름, 급여
select e.employee_id, e.first_name, e.salary
from departments d, employees e
where d.department_id = e.department_id -- catesian product에서 조건을 검색하므로, 효율이 떨어짐
        and lower(d.department_name) like lower('it');


-- >> employees 테이블에서만 검색하려면?
select department_id
from departments
where department_name = 'IT';

select employee_id, first_name, salary
from employees
where department_id = 60; -- IT 부서의 부서번호


-- >> 위의 쿼리를 하나로 합치려면?
select employee_id, first_name, salary
from employees
where department_id = select department_id
                        from departments
                        where department_name = 'IT'; -- 값이 나와야 할 자리에 select절이 나와서 오류 발생

-- >> 괄호를 입혀서 먼저 실행시키기 >> subquery 완성!
select employee_id, first_name, salary
from employees
where department_id = (select department_id
                        from departments
                        where department_name = 'IT');


-- 1) subquery 와  subquery/join 중첩사용

-- 'Seattle'에 근무하는 사원의 사번, 이름, 급여

-- 일단 순차적으로 풀어보기
select employee_id, first_name, salary
from employees
where department_id in();

select department_id
from departments
where location_id = 1700;
                                                
select location_id
from locations
where lower(city) = lower('Seattle');

-- >> subquery로 합치면!! ----------------------------------------------------------------- ?? 근데 이 문제, join으로도 가능?
select employee_id, first_name, salary
from employees
where department_id in (select department_id
                        from departments
                        where location_id = (select location_id
                                                from locations
                                                where lower(city) = lower('Seattle')));


-------- ?? 확인해보기 select에 subquery 가능?? ----------- 가능! 단, where절에 다른 테이블을 조회할 필요가 없을 경우에ㅋㅋ
                                                ----------- 이유는 아래 참고

select employee_id, department_id, (select department_name
                                     from departments d
                                     where e.department_id = d.department_id )
from employees e
order by department_id;

-----------------------------------------------------------------------



-- inline view : 가상의 테이블. from절에서 subquery 사용           * create view (임시로 만드는 테이블) 과는 다름
-- 지역번호가 1700인 부서에서 일하는 사원의
-- 사번, 이름, 부서번호, 부서이름
-- >> join으로 풀어보기
select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id
        and d.location_id = 1700;   --- 위에 시도해본 것처럼 select절에 subquery 넣어서 해결하려고 하면, 
                                     --- 실행순서가 from > where > select 순이기에, where 절에서도 subquery를 써야해서 더 불편.

-------------이 쿼리의 실행순서 확인 : catesian product 160건에서 join 조건 19건 도출 거기서 일반조건 6건 도출


-- >>> 효율성 높여보기
select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e, (select department_id, department_name
                    from departments
                    where location_id = 1700) d
where e.department_id = d.department_id;

------------->> 실행순서 : 가상의 테이블 (location_id 1700인 테이블)과 employees 테이블의 catessian product 80건에서, join 조건을 충족하는 6건 도출

-------------- * 근데, 지금 얘기하는 효율성이 속도를 보장하는 건 아님. 이론적으로 생각했을때 효율적이라는 거지, 속도를 보려면 실행계획(?)을 돌려봐야함








---- 응용 문제


-- 'Kevin'보다 급여를 많이 받는 사원의 사번, 이름, 급여

-- 풀어서
select employee_id, first_name, salary
from employees
where salary > ();

select salary
from employees
where lower(first_name) = lower('Kevin');

-- 합치기
select employee_id, first_name, salary
from employees
where salary > (select salary
                 from employees
                 where lower(first_name) = lower('Kevin'));



-- 50번 부서에 있는 사원들보다 급여를 많이 받는 사원의 사번, 이름, 급여

-- 풀어서
select employee_id, first_name, salary
from employees
where salary > ();

select max(salary)
from employees
where department_id = 50
order by salary desc;

-- 합치기
select employee_id, first_name, salary
from employees
where salary > (select max(salary)
                 from employees
                 where department_id = 50);


------ 원칙적인 정답! max 함수가 아니라, 논리연산자 all 사용!!  (50번 부서의 급여가 여러개이므로)-------???? 여기 확인!!!!
select employee_id, first_name, salary
from employees
where salary > all ();

select salary
from employees
where department_id = 50
order by salary desc;

-- >>>> 합치기
select employee_id, first_name, salary
from employees
where salary > all (select salary
                     from employees
                     where department_id = 50);



-- 부서에 근무하는 모든 사원들의 평균 급여보다 많이 받는 사원의 사번, 이름, 급여

-- 풀어서
select employee_id, first_name, salary
from employees
where salary > (); 

select salary
from employees
where department_id is not null -- 킴벌리를 제외한 19명!
order by salary;


select round(avg(salary))
from employees
where department_id is not null
order by salary;


-- 합치기
select employee_id, first_name, salary
from employees
where salary > (select round(avg(salary))
                 from employees
                 where department_id is not null);





---------------------------------------------------------------- * 상호관련 쿼리 개념확인 (이건 그냥 참고용)



-- 부서번호가 20번의 평균 급여보다 크고,----------------------------- 이 문제 한번 다시 풀어볼 것
-- 매니저인 사원으로 부서 번호가 20이 아닌 사원의
-- 사번, 이름, 급여, 부서번호

select e.employee_id, e.first_name, e.salary, e.department_id
from (select distinct manager_id
      from employees
      where manager_id is not null) m, employees e
where m.manager_id = e.employee_id
        and salary > (select avg(salary)
                      from employees
                      where department_id = 20)
        and e.department_id <>20
order by m.manager_id;


select distinct m.employee_id, m.first_name, m.salary, m.department_id
from employees e, (select *            
                   from employees
                   where salary > (select avg(salary)
                                   from employees
                                   where department_id = 20
                                   )
                   ) m
where e.manager_id = m.employee_id
        and m.department_id <> 20
order by m.employee_id;




-- 부서번호가 20번의 평균 급여보다 크고,
-- 부서장인 사원으로 부서 번호가 20이 아닌 사원의
-- 사번, 이름, 급여, 부서번호------------------------이거 답 3개 나와야 함


select manager_id
from departments;

select e.employee_id, e.first_name, e.salary, e.department_id
from employees e, (select employee_id
                    from employees
                    where salary > (select avg(salary) 
                                     from employees
                                     where department_id = 20)) s
where e.employee_id = s.employee_id
        and e.employee_id in (select manager_id
                              from departments)
        and e.department_id <> 20;


-------- 이 문제 이렇게 풀어도 값은 같은데, 의미상 맞나?
select employee_id, first_name, salary, department_id
from employees
where salary > (select avg(salary)
                 from employees
                 where department_id = 20)
        and employee_id in (select manager_id
                             from departments)
        and department_id <> 20;
        





-- select 절의 subquery

-- 20번 부서의 평균급여
-- 50번 부서의 급여총합
-- 80번 부서의 인원수

-- 풀어서
select avg(salary) from employees where department_id = 20;
select sum(salary) from employees where department_id = 50;
select count(employee_id) from employees where department_id = 80;

-- 합치면
select
    (select avg(salary) from employees where department_id = 20) avg20,------------ 단일행, 단일컬럼만 사용가능!
    (select sum(salary) from employees where department_id = 50) sum50,
    (select count(employee_id) from employees where department_id = 80) count80
from dual;


        
        
------ 응용문제
-- 모든 사원의 사번, 이름, 급여, 등급, 부서이름
-- 단, A는 1등급, B는 2등급... F는 6등급으로 표현
-- 단, job_grades는 join하지 않는다
select e.employee_id 사번, e.first_name 이름, e.salary 급여,
        decode( (select grade_level from job_grades where e.salary between lowest_sal and highest_sal),
                'A','1등급',
                'B','2등급',
                'C','3등급',
                'D','4등급',
                'E','5등급',
                '6등급') 등급,
        d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);


------정답 --------- case / decode 어느 것이든 사용 가능
select e.employee_id 사번, e.first_name 이름, e.salary 급여,
        case
            when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'A'
            then '1등급'
            when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'B'
            then '2등급'
            when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'C'
            then '3등급'
            when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'D'
            then '4등급'
            when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'E'
            then '5등급'
            else '6등급'
        end 등급,
        d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);

