-- [1조]

--1. 이름이 bruce인 사람의 사번, 부서번호, 급여를 뽑아라. (구성이 대문자인지 소문자인지는 모른다.)
select employee_id, department_id, salary
from employees
where lower(first_name) = 'bruce';

select employee_id, department_id, salary
from employees
where upper(first_name) = upper('bruce');

-- 2. 이름이 Steven인 사람이 근무하는 도시이름을 구해라
select department_id, first_name
from employees
where first_name = 'Steven';

select location_id
from departments
where department_id = 90;

select city
from locations
where location_id = 1700;

-- 3. 커미션을 받는 사람중 10000이 넘는 사람의 사번 이름 부서번호, 커미션을 포함한 급여를 찾아라
select employee_id, first_name, department_id, salary*(1+commission_pct)
from employees
where commission_pct is not null and salary*(1+commission_pct) > 10000;

-- 4. 근무부서가 null인 사람의 사번 이름 부서번호를 찾아라
select employee_id, first_name, department_id
from employees
where department_id is null;

-- 5. 근무 부서가 Oxford인 지역번호 찾기 (대소문자 섞어서 찾기) (별칭: 지역 번호)
select location_id
from locations
where lower(city) = lower('oXford');

-- 6. 근무자의 직업 종류 출력하기 (중복없이) (별칭: 직업)
select distinct job_id as "직업"
from employees;

-- 7. 직무별 최소급여와 최대 급여의 차이가 2배 미만으로 차이나는 직무아이디, 최소급여, 최대급여, 급여차이( 별칭 급여차이 )
select job_id, min_salary, max_salary, max_salary - min_salary 급여차이
from jobs
where 2 * min_salary > max_salary ;

-- 8. 직무가 programmer인 사람의 풀네임(별칭 : 이름), 급여(별칭 : 급여) 
select job_id, job_title
from jobs
where lower(job_title) like '%programmer%';

select first_name || ' ' || last_name 이름, salary 급여
from employees
where upper(job_id) = 'IT_PROG' ;

-- 9. 커미션을 받는 사원의 사번 , 이름, 급여를 급여별 내림차순 정리를 하라.
select employee_id, first_name, salary
from employees
where commission_pct is not null
order by salary desc;

-- 10. 사번, 이름, 커미션을 포함한 급여를 내림차순 정리를 하라.(커미션을 포함한 급여의 별칭은 cms)
select employee_id, first_name, salary*(1+nvl(commission_pct, 0)) cms
from employees
order by salary desc;


-- 2조

-- 1. 오늘을 기준으로 근로자의 근속년수를 나타내고 25년이하의 사람중에 직업등급레벨이 D인사람을을 나타내시오. 
--  (사번, 이름, 고용일, 근속년수)
--  (단, 월일은 신경쓰지않는다.귀찮으니깐 ㅎ)
select lowest_sal, highest_sal
from job_grades
where grade_level = 'D';

select employee_id 사번, first_name 이름, hire_date 고용일, to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy') 근속년수
from employees
where (to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy')) <= 25 and salary between 10000 and 14999;


-- * 근속년수 구하기
select to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy') 근속년수
from employees;


-- 2. last_name에 a가 들어가는 사람의 사번, 풀네임, 급여를 급여가 높은 순서대로 나타내어라.
--   이름의 컬럼은 employee_name로 표시한다.
--   (단, a는 대소문자 포함한다.)
select employee_id, first_name || ' '|| last_name "employee_name", salary
from employees
where lower(last_name) like '%a%'
order by salary desc;

-- 3. 매니저 번호가 100 이상 200 미만이고, 미국에 위치하고 있는 부서의 부서번호, 부서명 (3개 출력되면 정답)
select location_id
from locations
where country_id = 'US';

select department_id, department_name, location_id, manager_id
from departments
where manager_id < 200 and location_id in (1400, 1500, 1700);

-- 4. 우편번호에 9가 들어가는 지역에 위치한 부서에서 일하며, 급여가 7000 이상인 사원의 이름
-- 부서별 이름순으로 정렬
select *
from locations
where postal_code not like '%9%';

select department_id
from departments
where location_id not in (1800);

select first_name
from employees
where department_id in (60, 50, 10, 90, 110, 190, 80)  and salary >= 7000
order by department_id, first_name asc;

select department_id, first_name, salary
from employees
order by department_id, salary desc, first_name;

-- 5. 급여가 3000이상이고 50번이상 부서에 근무하며 이름에 r이 들어가는 사원들의 사번과 이름, 급여를 검색하라
select employee_id, first_name, salary
from employees
where salary >= 3000 and department_id >= 50 and lower(first_name) like '%r%';

-- 6. 직업아이디가 AD로 시작하는 것을 검색하고 최고급여부터 내림차순으로 급여를 정렬하라
select salary
from employees
where job_id like 'AD%'
order by salary desc;

-- 7. 근무국가가 미국인 사원의 풀네임과 근무시작 날짜를 적어서 'OOO은 OOO부터 미국에서 일한다.' 로 출력하라. 
--   별칭은 노동자 from USA로 저장(공백포함)
select location_id, country_id
from locations
where country_id = 'US';

select department_id
from departments
where location_id in (1400, 1500, 1700) ;

select first_name || ' ' || last_name || '은 ' || hire_date || '부터 미국에서 일한다.' "노동자 from USA"
from employees
where department_id in (60, 50, 10, 90, 110, 190) ;


-- 8. 성이나 이름에 h가 들어간 사원에 대한 정보를 모두 출력하되 급여와 고용일을 내림차순으로 정렬하여라.
select salary, hire_date
from employees
where lower(first_name) like '%h%' or lower(last_name) like '%h%'
order by salary desc, hire_date desc;


-- 3조

-- 1. 매니저가 없는 부서를 조건을 통해 찾으시오..
select department_name, manager_id
from departments
where manager_id is null;

-- 2. 최저월급과 최고월급의 차이가 3000이상 나는 grade_level을 찾으시오.
select grade_level, highest_sal - lowest_sal
from job_grades
where (highest_sal - lowest_sal) >= 3000;

-- 3. 4년이상 근무하고 퇴사한 사원의 번호과 JOB_ID 출력하시오.
select employee_id, job_id, (to_char(end_date, 'yyyy') - to_char(start_date, 'yyyy')) 근속년수
from job_history
where (to_char(end_date, 'yyyy') - to_char(start_date, 'yyyy')) >= 4;

-- 4. 관리자 ID가 124번이며, 급여가 2500 이상 3500 미만인 사원의 (이름, 급여, 관리자 ID)를 출력하세요.
-- 단, 급여가 높은 순으로 정렬
select first_name, salary, manager_id
from employees
where manager_id = 124 and salary >= 2500 and salary < 3500
order by salary desc;

-- 5. 관리자 ID가 100이고 이름의 2번째가 'o'인 사원의 (이름, 커미션, 커미션 적용 후 급여)를 출력하세요.
-- *커미션이 null인 경우 0으로 대체하여 계산 및 출력
-- 단, 커미션 적용 후 급여가 높은 순으로 정렬
select last_name, salary*commission_pct, salary*(1+nvl(commission_pct, 0))
from employees
where manager_id = 100 and lower(last_name) like '_o%'
order by salary*(1+nvl(commission_pct, 0)) desc ;

-- 6. 관리자가 지정되지 않은 사원의 (이름)을 출력하세요. *이름 형식 : [성 이름]
select last_name || ' ' || first_name
from employees
where manager_id is null;

-- 7. 최대 급여와 최소 임금의 차가 5000 이상인 직급의 (이름, 최대 급여, 최소 급여, 급여의 차이)을 출력하세요.
-- 단, 급여의 차이가 큰 순으로 정렬하세요.
select job_title, max_salary, min_salary, (max_salary - min_salary) as "급여의 차이"
from jobs
where (max_salary - min_salary) >= 5000
order by (max_salary - min_salary) desc;

-- 8. 현재 시간, 3일 후, 3시간 후, 3분 후, 3초 후를 출력하세요 *각각에 별칭 지정(현재 시간, 3일 후 ~)
-- 단, 출력 형식은 '년도.월.일 시:분:초'
select to_char(sysdate, 'yy.mm.dd hh:mi:ss') "현재 시간",
       to_char(sysdate+3, 'yy.mm.dd hh:mi:ss') "3일 후",
       to_char(sysdate+3/(24*60), 'yy.mm.dd hh:mi:ss') "3분 후",
       to_char(sysdate+3/(24*60*60), 'yy.mm.dd hh:mi:ss') "3초 후"
from dual;

-- 9. 90년 이전에 고용된 사원들의 최대 급여, 부서이름  
select department_id, job_id, hire_date 검토
from employees
where to_char(hire_date, 'yyyy') <= 1990
order by hire_date asc;

select max_salary, job_id
from jobs
where lower(job_id) in ('ad_pres', 'ad_asst', 'ad_vp', 'it_prog');

select department_name, department_id
from departments
where department_id in (90, 10, 60) ;

-- 10. 직책이 President 인 사원의 고용날짜, 이름 , 급여
select job_id
from jobs
where job_title = 'President';

select hire_date, first_name, salary, job_id 검토
from employees
where job_id = 'AD_PRES';

-- 11. 급여가 5000이상이고 매니저가 지정된 사람의 이름을 출력하시오
select first_name
from employees
where salary >= 5000 and manager_id is not null;

-- 12. 최대 급여와 최소 급여가 4000 이하로 차이나는 job_title을 찾으시오
select job_title
from jobs
where (max_salary - min_salary) <= 4000; 

-- 13. 매니저가 지정되지 않은 사람의 '이메일, 전화번호'의 형식으로 출력하시오
select email || ', ' || phone_number
from employees
where manager_id is null;

-- 14. 마케팅 부서가 위치한 지역의 우편번호를 찾으시오.
select location_id, department_name
from departments
where lower(department_name) = 'marketing';

select postal_code
from locations
where location_id = 1800;

-- 15. it부서가 위치한 지역의 주소를 찾으시오.
select location_id, department_name
from departments
where upper(department_name) like '%IT%'; 

select street_address
from locations
where location_id = 1400;

-- 16. Steven King 직원의 직급이 벌수 있는 최고연봉을 찾으시오.
select job_id
from employees
where first_name = 'Steven' and last_name = 'King';

select max_salary
from jobs
where upper(job_id) = 'AD_PRES';

-- 17. 조건1. last_name 의 앞에서 두번째에 'u'가 들어간 사람의 커미션이 포함된 급여를 출력하시오.
--     조건2. 커미션이 포함된 급여에 별칭 "급여"를 입력하시오.
select salary*(1+nvl(commission_pct, 0)) 급여
from employees
where lower(last_name) like '_u%';

-- 18. 부서번호가 50이상, 이름이 아닌 성에서 끝에 두번째에 'o'가 들어간 사원의 전체 풀네임과 급여를 나타내시오. 
--     별칭 : 이름 /  급여
--     급여 오름차순으로 정렬 하시오.
select first_name || ' ' || last_name 이름, salary 급여
from employees
where department_id >= 50 and lower(last_name) like '%o_'
order by salary desc;


-- 4조

-- 1. 직무가 IT인 사람들의 이름, 급여, 근무년수(소수점 버리고 년수만)
select first_name, salary, to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy') 근속년수, job_ID
from employees
where upper(job_id) like '%IT%';

-- 2. 근무도시가 'Southlake'인 사원의 사번, 이름, 이메일, 급여를 검색하고 콜럼명 지정
select location_id, city
from locations
where city = 'Southlake';

select department_id
from departments
where location_id = 1400;

select employee_id 사번, first_name 이름, email 이메일, salary 급여
from employees
where department_id = 60;


-- 3. 입사일이 91/01/02 과 98/12/21 사이인 사원의 정보를 출력.
--   (사원번호, 풀네임, 입사일, 급여(커미션이 있다면 포함할것), 커미션(없으면 0으로 표시) 으로 출력할것)
select employee_id 사원번호, first_name || ' ' || last_name 이름, hire_date 입사일, salary*(1+nvl(commission_pct, 0)) 급여
from employees
where hire_date between to_date('1991-01-02', 'yy/mm/dd') and to_date('1998-12-21', 'yy/mm/dd');

select employee_id 사원번호, first_name || ' ' || last_name 이름, hire_date 입사일, salary*(1+nvl(commission_pct, 0)) 급여
from employees
where to_char(hire_date, 'yyyy-mm-dd') between '1991-01-02' and '1998-12-21';

-- 4. 회장(president)의 사번을 알아낸뒤 회장의 인적사항을 채워넣으세요.
-- 사번 : 
-- 풀네임 : 
-- 입사일 : 
-- 커미션포함된 급여 : 
-- 소속부서명 : 
-- 부서가 속한 주소 : 
select job_id
from jobs
where lower(job_title) = 'president';

select employee_id 사번, first_name || ' ' || last_name 풀네임, hire_date 입사일,
        salary*(1+nvl(commission_pct, 0)) "커미션포함된 급여", department_id 
from employees
where job_ID = 'AD_PRES';

select location_id
from departments
where department_id = 90;

select country_id, state_province, street_address, postal_code
from locations
where location_id = 1700;


--5. 부서명 ShiPping 에 속하면서 급여(salary)는  2000 ~ 4000 사이면서 
--          firstName에 t 가 들어가는 사람이면서 
--          입사일(hire_date)이 97/01/01 ~ 98/12/30 에 포함되지 않는 사람의 사번과 풀네임은?
-- 사번 : 
-- 이름 : 
select department_id
from departments
where lower(department_name) = lower('ShiPping') ;

select employee_id 사번, first_name || ' ' || last_name 이름
from employees
where department_id = 50 and (salary between 2000 and 4000) and (lower(first_name) like '%t%') and
       to_char(hire_date, 'yyyy/mm/dd') not between '1997/01/01' and '1998/12/30';


-- 6. 7000~9000 사이의 급여를 받을 수 있는 직업 이름 중에서 'Manager'를 포함하는 직업 이름, 최소 급여, 최대 급여 (최소 급여는 오름차순으로 정렬)
select job_title, min_salary, max_salary
from jobs
where min_salary < 9000 and max_salary >7000 and lower(job_title) like lower('%Manager%') 
order by min_salary;

-- 7. 관리자 번호가 부여되지 않은 부서의 부서번호
select department_id
from departments
where manager_id is null;

-- 8. 세자리 부서 번호에 속한 사원의 급여 (급여가 많은 순서대로 정렬)
select salary
from employees
where department_id like '___'
order by salary desc;

-- 9. 1990년 이후에 고용된 사원의 이름, 이메일, 고용 일자 (먼저 입사한 순서대로 정렬)
select first_name, email, hire_date
from employees
where to_char(hire_date, 'yyyy') >= 1990
order by hire_date;

-- 10. 커미션, 관리 번호, 부서 번호가 하나라도 알 수 없는 사원의 이름, 전화번호 (전화번호는 오름차순)
select first_name, phone_number
from employees
where commission_pct is null or manager_id is null or department_id is null
order by phone_number;

-- 11. 다음 중 실행 결과가 다른 하나는? (단, 각 열의 이름은 무시한다.) 
--    (코드 수행 전에 먼저 employees 테이블을 보면서 머리 속으로 생각을 해보는 것을 권장함.)
--    (참고 : employees 테이블은 기본적으로 employee_id 로 정렬되어 있다. 그리고 employee_id 는 고유한 값이다.)  
            
1)
SELECT employee_id, email, hire_date, salary, manager_id, department_id
FROM employees
WHERE commission_pct is null;


2)
SELECT employee_id, email, hire_date, salary, manager_id, department_id
FROM employees
WHERE commission_pct is null
ORDER BY employee_id asc;


3)
SELECT employee_id, email, hire_date, salary, manager_id, department_id
FROM employees
WHERE commission_pct is null
ORDER BY commission_pct asc;


4)
SELECT employee_id, email, hire_date, salary, manager_id, department_id
FROM employees
WHERE commission_pct is null
ORDER BY commission_pct desc, employee_id asc;


5)
SELECT employee_id, email, hire_date, salary, manager_id, department_id
FROM employees
WHERE commission_pct is null
ORDER BY employee_id asc, commission_pct desc;
