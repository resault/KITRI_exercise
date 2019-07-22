-- 1조

-- 1. 모든사원의 사번, 직책,  급여, 최고급여, 최저급여를 구하시오 
select e.employee_id, j.job_title, e.salary, j.max_salary, j.min_salary
from employees e, jobs j
where e.job_id = j.job_id;

-- 답
select e.salary, j.job_id, j.min_salary, j.max_salary
from employees e, jobs j
where e.job_id = j.job_id;

-- 2. US에 거주하는 사원의 사번 직책을 뽑으시오
select e.employee_id, j.job_title
from employees e, jobs j, departments d, locations l
where e.job_id = j.job_id
        and e.department_id = d.department_id
        and d.location_id = l.location_id
        and lower(l.country_id) = lower('US')
order by e.employee_id;

-- 답
select e.employee_id, e.job_id, c.country_id, d.department_id, l.city
from employees e, countries c, locations l, departments d
where upper(c.country_id) = upper('us')
and c.country_id = l.country_id
and d.department_id = e.department_id
and l.location_id = d.location_id;


-- 3. 모든 사원의 부서이름, 사번, 이름, 매니저사번, 매니저이름 (case 문 사용)
select d.department_name 부서이름, e.employee_id 사번, e.first_name 이름, e.manager_id 매니저사번,
        case
            when e.manager_id = m.employee_id
            then m.first_name
        end 매니저이름
from employees e, departments d, employees m
where e.department_id = d.department_id
        and e.manager_id = m.employee_id
order by d.department_name;



-- 답
select d.department_name, e.employee_id, e.first_name, d.manager_id, e.manager_id,
    case when e.manager_id = m.employee_id
        then m.first_name
        end "매니저이름"
from employees e, departments d, employees m
where e.department_id = d.department_id 
    and e.manager_id = m.employee_id
order by department_name;



-- 4. 모든 직원의 사번, 이름, 부서이름, 직책이름, 부서장 (본인이 부서장일 경우 null 표시는 무시)
select e.employee_id, e.first_name, d.department_name, j.job_title, p.first_name
from employees e, departments d, jobs j, employees p
where e.department_id = d.department_id
        and e.job_id = j.job_id
        and d.manager_id = p.employee_id;

select e.employee_id, e.first_name, d.department_name, j.job_title, p.first_name,
        case
            when d.manager_id = p.employee_id
            then p.first_name
        end
from employees e, departments d, jobs j, employees p
where e.department_id = d.department_id
        and e.job_id = j.job_id
        and d.manager_id = p.employee_id;


-- 답
select e.employee_id, e.first_name, d.department_name, j.job_title, d.manager_id,
    case when d.manager_id = e.manager_id
         then m.first_name
         when e.manager_id = m.employee_id
         then e.first_name
        end "부서장"
from employees e, departments d, jobs j, employees m

where e.department_id = d.department_id
      and e.job_id = j.job_id
      and e.manager_id = m.employee_id;




-- 5. 사번, 이름, 부서번호, 부서이름, 분류를 뽑아라.
--분류(decode이용)
--부서번호가 110이면 경영
--          60이면 개발
--          50이면 운송
--          그외 기타
select e.employee_id, e.first_name, e.department_id, d.department_name,
        decode(e.department_id, 110, '경영', 60, '개발', 50, '운송', '기타') 분류
from employees e, departments d
where e.department_id = d.department_id;


-- 6. 직업 번호, 직업이름, 사번, 이름, 급여, 최대급여, 최소급여를 구해라
select e.job_id, j.job_title, e.employee_id, e.first_name, e.salary, j.max_salary, j.min_salary
from employees e, jobs j
where e.job_id = j.job_id;


-- 2조


--1. 최소연봉이 10000이 넘는 직책의 사원의 사원번호, 이름, 연봉, 직책이름,부서이름
select e.employee_id, e.first_name, e.salary, j.job_title, d.department_name
from employees e, jobs j, departments d
where e.job_id = j.job_id
            and e.department_id = d.department_id
        and j.min_salary > 10000;

--2.사번,이름,매니저사번,매니저이름,매니저의 직책 
--(별칭을 매니저직책으로 바꾸시오.)

select e.employee_id, e.first_name, e.manager_id, m.first_name, j.job_title
from employees e, employees m, jobs j
where e.manager_id = m.employee_id
        and m.job_id = j.job_id;



-- 3. 'toronto'에 위치한 부서에 근무하는 사원 중 8월에 입사한 사람의
-- 사번, 이름, 부서명, 직책이름, 매니저 이름을 출력하라.
select e.employee_id, e.first_name, d.department_name, j.job_title, em.first_name
from departments d, locations l, employees e, jobs j, employees em
where d.location_id = l.location_id 
            and d.department_id = e.department_id
            and e.job_id = j.job_id
            and e.manager_id = em.employee_id
        and lower(l.city) = lower('toronto')
        and to_char(e.hire_date, 'mm') = '08';




-- 4. 1995년 이전에 입사한 사원 중 5000 이하의 급여를 받는 사람의
-- 사번, 이름, 직책이름, 급여, 근무 도시를 출력하라

select e.employee_id, e.first_name, j.job_title, e.salary, l.city, e.hire_date
from employees e, jobs j, departments d, locations l
where e.job_id = j.job_id
        and e.department_id = d.department_id
        and d.location_id = l.location_id
        and to_number(to_char(e.hire_date, 'yyyy'), '9999') <= 1995
        and e.salary <= 5000;

-- 5.같은 지역에 사는 사람별 연봉이 높은 순으로 나타내보자
select e.employee_id, e.first_name, r.region_name, e.salary
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id
        and d.location_id = l.location_id
        and l.country_id = c.country_id
        and c.region_id = r.region_id
order by r.region_name, salary desc;



-- 6.미국에 사는 전화 끝번호가 8009인 사람한테 편지를 보내야 합니다. 주소가 어딜까여?ㅋㅅㅋ
select l.street_address, l.postal_code, l.city, l.state_province
from departments d, locations l, countries c, employees e
where d.location_id = l.location_id
            and l.country_id = c.country_id
            and d.department_id = e.department_id
        and lower(c.country_name) like lower('united states of america')
        and substr(e.phone_number, length(e.phone_number)-3, 4) = 8009;
        
-- 답
select l.street_address, l.postal_code, l.city, l.state_province 
from employees e, departments d, locations l, countries c, regions r
where r.region_id = c.region_id
        and c.country_id = l.country_id
        and l.location_id = d.location_id
        and d.department_id = e.department_id
    and lower(r.region_name) = 'americas' and phone_number like '%8009';


-- 7. 전체 사원들의 사번과, 풀네임, 부서이름, 근무지 주소(ex. Americas> 2004 Jabberwocky Rd, Southlake, Texas, US)를 출력할것
select e.employee_id 사번, concat(e.first_name, concat( ' ' , last_name)) 풀네임,
        d.department_id, concat( r.region_name, 
                                concat( '> ', 
                                    concat( l.street_address, 
                                        concat( ', ',
                                            concat( l.city, 
                                                concat( ', ', 
                                                    concat( l.state_province, 
                                                        concat( ', ', l.country_id) ) ) ) ) ) ) )
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id
        and d.location_id = l.location_id
        and l.country_id = c.country_id
        and c.region_id = r.region_id;


-- 8.부서이름이 'marketing'이면서 'americas'에 근무하는 사원의 사번,이름,부서이름,도시이름 출력하세요
select e.employee_id, e.first_name, d.department_name, l.city
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id
            and d.location_id = l.location_id
            and l.country_id = c.country_id
            and c.region_id = r.region_id
        and lower(d.department_name) = lower('marketing')
        and lower(r.region_name) = lower('americas');


-- 답
select e.employee_id, first_name, d.department_name,l. city
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id
          and d.location_id = l.location_id
          and l.country_id = c.country_id
          and c.region_id = r.region_id
          and lower(d.department_name) = lower('marketing')
          and lower(r.region_name) = lower('americas');


-- 3조

--1. 급여가 10000이상인 사원들의 "이름", "주소", "급여"  
--급여가 높은순으로 정렬
select e.first_name, l.street_address, e.salary
from employees e, departments d, locations l
where e.department_id = d.department_id
            and d.location_id = l.location_id
order by salary desc;


--2. Kevin 사원이 근무 중인 부서이름과 state
select e.first_name, d.department_name, l.state_province
from employees e, departments d, locations l
where e.department_id = d.department_id
            and d.location_id = l.location_id
        and lower(e.first_name) = lower('Kevin');



--3. 셀프조인 사용해서 모든사원의 사번, 이름, 급여, 직속상관이름, 직속상관(매니저)의급여 출력





4.
--99년도에 프로젝트 진행을 시작한적이 있는 부서들이 현재 위치한 주소와 우편번호

5.
--이름이 'pat'인 사원의 매니저이름, 회사 주소를 출력하기
--단, 주소 형식은 [대륙명 나라명 주이름 도시 도로주소]

6.
--경력이 1개 이상인 사원의 사번, 이름, 근무 기간(년수), 당시 직책 이름을 출력하기
--단, 사번별로 정렬

7.
--peter 와 동일한 근무지에 근무하는 사원의 이름을 출력하시오

8.
----us(대문자인지, 소문자인지 모름)에 사번, 이름(풀네임), 급여 출력
--급여가 높은 순으로 출력

9.
--decode를 이용하여 미국에서 일하는 사람은 미국, 영국에서 일하는 사람은 영국, 캐나다에서 일하는 사람은 캐나다라고 출력하시오
--테이블이름 :사번, 이름, 부서이름, 근무국가

10.
--마케팅 부서 사원 중 가장 높은 연봉액과 가장 낮은 연봉액을 구하시오.
--테이블이름 : 부서이름, 최고연봉, 최저연봉



-- 4조

1. 사원들의 grade_level 를 구하시오.
   사번, 이름, 급여, grade_level (정렬은 사번)



2. 직책이 변경된 적이 있는 사람들(job_historys 에 이력이 있는 사람)의 
   사번, 이름, 이전직책코드, 이전직책명, 현재직책코드, 현재직책명을 표시
   (정렬기준은 사번)


3. 한사람을 찾아라.
- 그 사람은 3000 ~ 4500 사이의 급여를 받을 수 있는 직책을 가지고 있다.
- 그 사람이 일하는 부서명은 Administration 이다.
- 그 사람의 사번, 이름, 급여, 부서명 표시



4. 'europe'에 근무하는 사원 이름 부서이름 도시이름



5. 사번이 100~150번인 사원의근무 이력
   사번, 이름, 직책이름, 부서이름,  근무개월




6. 'canada'에서 근무하는 사원들의 매니져들의 급여평균을 구하시오.




7. first_name에 e가 들어가는 사원들의 매니져들 중에서 급여가 10000이상인 사람들의 급여 합계를 구하시오




8. 'Europe' 에 근무하는 사람들 이름, 연봉




9. 급여가 10000이상이고 부서번호가 110인 사원의 이름, 직책이름



10. 급여 등급이 B, D, F 인 사원들의 이름, 급여, 근무 도시
