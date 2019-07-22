-- 집합 연산자

-- Union, Union all, Intersect,
-- 부서번호가 50이거나 90인 사원과
-- 급여가 10000 이상인 사원의
-- 사번, 이름, 급여, 부서번호
select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
union        
select employee_id, first_name, salary, department_id
from employees
where salary >= 10000;

select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
union all
select employee_id, first_name, salary, department_id
from employees
where salary >= 10000;

select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
intersect
select employee_id, first_name, salary, department_id
from employees
where salary >= 10000;

select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
minus
select employee_id, first_name, salary, department_id
from employees
where salary >= 10000;


select employee_id, first_name, salary, department_id
from employees
where salary >= 10000
minus
select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90);



-- [Group by]

-- 부서별 급여총합, 평균급여, 사원수, 최대급여, 최소급여
select department_id 부서번호, sum(salary) 급여총합, avg(salary) 평균급여,
        count(employee_id) 사원수, max(salary) 최대급여, min(salary) 최소급여
from employees 
group by department_id;


select department_id 부서번호, sum(salary) 급여총합, avg(salary) 평균급여,
        count(employee_id) 사원수, max(salary) 최대급여, min(salary) 최소급여,
        employee_id ---------------------------------------------------------------그룹핑한 컬럼과 그룹함수만 사용 가능함!
from employees 
group by department_id;


-- having 절
-- 부서별 급여총합, 평균급여, 사원수, 최대급여, 최소급여
-- 평균급여가 5000 이하인 부서
select department_id 부서번호, sum(salary) 급여총합, avg(salary) 평균급여,
        count(employee_id) 사원수, max(salary) 최대급여, min(salary) 최소급여
from employees
group by department_id 
having avg(salary) <= 5000;



-- 응용
-- 1. 모든 부서의 평균 급여(각 부서별 평균)보다 많이 받는 사원의
-- 사번, 이름, 급여
select employee_id, first_name, salary
from employees
where salary > all ((select avg(salary)
                       from employees
                       group by department_id
                      )
                     );


-- 2.부서별 최고 급여를 받는 사원의
-- 부서이름, 사번, 이름, 급여 (단, 부서가 없는 사원은 제외한다)
select (select department_name from departments where e.department_id = department_id) 부서이름,
        e.employee_id 사번, e.first_name 이름, e.salary 급여
from employees e, (select department_id, max(salary) 급여
                    from employees
                    group by department_id
                    having department_id is not null) m
where e.salary = m."급여"
        and e.department_id = m.department_id;

-- 부서가 없는 사원을 포함하려면? Union 
select (select department_name from departments where e.department_id = department_id) 부서이름,
        e.employee_id 사번, e.first_name 이름, e.salary 급여
from employees e, (select department_id, max(salary) 급여
                    from employees
                    group by department_id
                    having department_id is not null) m
where e.salary = m."급여"
        and e.department_id = m.department_id
union
select (select department_name from departments where e.department_id = department_id) 부서이름,
        e.employee_id 사번, e.first_name 이름, e.salary 급여
from employees e, (select department_id, max(salary) 급여
                    from employees
                    group by department_id
                    having department_id is null) m
where e.salary = m."급여";



-- is null을 쓰면??
select (select department_name from departments where e.department_id = department_id) 부서이름,
        e.employee_id 사번, e.first_name 이름, e.salary 급여
from employees e, (select department_id, max(salary) 급여
                    from employees
                    group by department_id) m
where e.salary = m."급여"
        or e.department_id is null  ------ 지금은 값이 같지만, null인 사람이 여러명인 경우라면 max 자체가 제대로 안나올 것임
        and e.department_id = m.department_id;



------------------------------------------------------------------------------------------여기부터 

-- Top N Query

-- 사번, 이름, 급여, 입사연대, 부서이름
-- 급여순 순위,
-- 한 페이지당 5명씩 출력된다고 가정할 때, 2쪽을 출력할 것
-- 1980년대, 1990년대, 2000년대 

----이거 오답임
select e.employee_id 사번, e.first_name 이름, e.salary 급여,
        decode( substr( to_char(e.hire_date, 'yyyy') , 3, 2),
                '1980', '1980년대',
                '1990', '1990년대',
                '2000년대') "입사 연대",
        (select department_name from departments where e.department_id = department_id) "부서이름"---------- 이건, A라는 사람의 부서 번호가 X일 때, 해당 부서이름을 가져온게 아님!!!---------이 부분 확인!!!
from (select rownum 순번, employee_id
       from (select employee_id
              from employees
              order by salary desc)) s, employees e
where s.employee_id = e.employee_id
        and s.순번 between ((&page*5)-4) and (&page * 5);


---- 원칙적인 정답


select b.rn 급여순위, b.employee_id 사번, b.first_name 이름, b.salary 급여,
        case
            when to_char(b.hire_date, 'yyyy') < '1990'  ----------- 범위비교를 하는 것이므로, 의미상 decode 보다는 case가 적합함
            then '1980년대'
            when to_char(b.hire_date, 'yyyy') < '2000'
            then '1990년대'
            else '2000년대'
        end 입사연대,
        d.department_name 부서이름
from (select rownum rn, a.*
       from (select employee_id, first_name, salary, hire_date, department_id
              from employees
              order by salary desc) a
       where rownum <= &page * 5) b, departments d
where b.department_id = d.department_id(+)
        and b.rn > &page * 5 - 5        ------------- 변수로 지정할 경우도 고려해야 하므로 숫자는 통일되게 계산하는 것이 좋음
order by 급여순위;  ----------- 이게 갑자기 왜 순서가 바뀌었을까??


-----------오답체크
select rownum, employee_id ---------- 실행순서가 select 다음에 order by 이기 때문에 rownum 값 매겨진 후에 정렬됨
from employees
order by salary desc;


------------구글링해보고 rank over를 사용해서 위의 문제 풀어볼 것
rank over



-------------- 값 받아오기
select *
from employees
where salary > &page;




-- rownum
select rownum, employee_id, salary
from employees
where rownum < 10;

select rownum, employee_id, salary
from employees
where rownum > 5;


--------------------------------------------------------------------------------- 여기까지 노트정리!!
