-- 1조
--1. 사원의 최대 연봉과 최소 연봉의 평균을 구하고 별칭을 "평균급여"라고 줘라. 
select (min_salary+max_salary)/2 as "평균급여"
from jobs;

--2. 사원의 이메일과 전화번호를 결합하여 "회신"이라는 별칭으로 리스트를 만들어라. (이메일과 전화번호 사이에는 /추가)
select email || '/' || phone_number 회신 
from employees;

--3. 사원의 id와 부서id를 활용하여 어디 소속인지 알아내라
select department_ID, department_name
from departments;

select employee_ID, department_ID
from employees;

--4. 사원들이 얼마의 커미션을 받는지 구하라( 알수 없을땐 0으로 구한다.)
select salary*((1+nvl(commission_PCT,0))-1)
from employees;

--5. (풀네임)의 전화번호는 (전화번호)입니다.   별칭 : 사원 전화번호
select first_name || '의 전화번호는 ' || phone_number || '입니다.'
from employees;

--6. (직무이름)의 평균 임금은 (평균 급여)원 입니다.   별칭 : 직무별 평균 급여
select job_title || '의 평균 임금은 ' || (min_salary+max_salary)/2 || '원 입니다.'
from jobs;

--7. 프로젝트 진행 기간은 (프로젝트 진행 기간) 입니다.
select '프로젝트 진행 기간은 ' || (end_date-start_date) || ' 입니다.'
from job_history;

--8. (부서이름)의 관리자 번호는 (메니저 번호) 입니다.
select department_name || '의 관리자 번호는 ' || manager_ID || '입니다.'
from departments;

--9. 부서 번호가 xx인 부서의 이름은 xx 입니다.
select '부서 번호가 ' || department_id || '인 부서의 이름은 ' || department_name || '입니다.'
from departments;

--10. 사원 번호 xx는 xx날부터 프로젝트를 시작했습니다.
select '사원 번호 ' || employee_ID || '는 ' || hire_date || '날부터 프로젝트를 시작했습니다.'
from employees;



-- 2조
-- 1. employees테이블 제일 앞 열에 새로운  오늘의 날짜를 붙이고 부서번호가 null인 사람을 찾아서 null을 80으로 바꿔라
select '2019.02.21.', nvl(department_ID,80)
from employees;

-- 2. 유럽 영국에서 일하는 사람 4명중에 봉급을 제일 많이 받는사람은?
-- 영국에 있는 부서는 sales(80)이다. 해당 부서에서 일하는 사람 중 급여가 가장 많은 사람은 Ellen abel
select *
from regions;

select *
from countries;

select *
from locations;

select *
from departments;

select department_ID, salary, first_name || ' ' || last_name
from employees;

-- 3. jobs 테이블에서 직무 이름과 최소 급여, 최대급여, 평균급여를 출력하고 평균급여의 별칭을 평균 급여로 하시오.
--    (평균급여는 최소급여와 최대급여의 평균값으로 한다.)
select job_title, min_salary, max_salary, (min_salary+max_salary)/2 as "평균 급여"
from jobs;

-- 4. locations 테이블에서 전체주소를 출력하고 별칭을 주소 로 하시오 . (전체주소 : street_address, city, country_ID )
select street_address || ' ' || city || ' ' || country_ID 주소
from locations;

-- 5. 부서번호가 ()인 사원의 커미션포함급여는 ()이다. 라고 출력하시오
select '부서번호가 ' || department_ID || '인 사원의 커미션 포함급여는 ' || salary*(1+nvl(commission_pct,0)) || '이다.'
from employees;

-- 6. (풀네임은)의 폰번호는 ()이고 이메일은()이다. 라고 출력하시오
select first_name || ' ' || last_name || '의 폰번호는 ' || phone_number || '이고 이메일은 ' || email || '이다.'
from employees;

-- 7. '직무'가 받을 수 있는 최저 금액은 ' '원이며, 최고금액은 ' '원입니다. 그리고 그 금액의 차이는 ' '원입니다. 
--    (이렇게 쫙 출력되게 쓰기, 테이블의 이름은 as를 이용해서 쇼미더머니로 수정할 것)
select job_title || '가 받을 수 있는 최저 금액은 ' || min_salary || '원이며, 최고금액은 ' || max_salary || '원입니다. 그리고 그 금액의 차이는 ' || (max_salary-min_salary) || '원입니다.'
from jobs;

-- 8. '사원 이름+성'의 예상 연봉은 ' '원이다. (커미션이 붙은 사람들은 그것 포함하여 사람별로 쫙 출력)
-- 그리고 커미션이 붙은 사람들은 커미션이 안붙었을때 연봉차이가 얼마나 나는지 따로 나타낼 것(별칭은 오예 커미션), 커미션이 0인 사람들은 0으로 표시
-- << 행 총 2개
select first_name || ' ' || last_name || '의 예상 연봉은 ' || salary*(1+nvl(commission_PCT,0)) || '원이다.', salary*(1+nvl(commission_PCT,0))-salary "오예 커미션"
from employees;

-- 9. "President"의 최대 급여는 40000입니다. (위와 같은 형태로 출력하며, 별칭은 비고로 한다.)
select employee_id 사번, hire_date 입사일, salary*(1+nvl(commission_pct,0)) "급여_커미션 포함"
from employees;

-- 10. 사번, 입사일, 커미션이 포함된 급여를 출력하라. (별칭은 각각 사번, 입사일, 급여_커미션 포함 으로 한다.)
select '"' || job_title || '"의 최대 급여는 ' || max_salary || '입니다.'
from jobs;


-- 3조
-- Q1. **(이름)의 메일주소는**이고 핸드폰번호는**이다. 다음과 같이 출력하기 column이름은 연락처
select first_name || '의 메일주소는' || email || '이고 핸드폰번호는 ' || phone_number || '이다.' 연락처
from employees;

-- Q2. **(국가) **(지역)주 **(도시)시 **(주소)의 우편번호는 **이다. 다음과 같이 출력하기 column이름은 우편번호
select country_id || ' ' || 'state_province' || '주 ' || city || '시 ' || street_address || '의 우편번호는 ' || postal_code || '이다.' 우편번호
from locations;

-- Q3. "000 사원 - 이메일 : 000@gamil.com / 전화번호 : ***.***.****" 형식으로 출력하세요 (이름은 '이름 성' 형식)
select first_name || '사원 - 이메일 : ' || email || '@gmail.com / 전화번호 : ' || phone_number
from employees;

-- Q4. "도로 주소, 도시명, 주이름, 국가ID" 형식으로 출력하세요 (Column명은 '주소')
select street_address || ', ' || city || ', ' || state_province || ', ' || location_id
from locations;

-- Q5."full name"의 직업은 "job_id"이며 입사날짜는 "hire_date"이다. 
select '"' || first_name || ' ' || last_name || '의 직업은 "' || job_id || '이며 입사날짜는 "' || hire_date || '이다.'
from employees;

-- Q6. "우편번호 - 도시 - 주소"  형태로 출력해주세요.
select postal_code || ' - ' || city || ' ' || street_address
from locations;

-- Q7 와싱턴 시애틀에 위치한 지사의 우편번호는 98199이다.(별칭 : Post code)
select state_province || ' ' || city || '에 위치한 지사의 우편번호는 ' || postal_code || '이다.' "post code"
from locations;

-- Q8.이름(풀네임)의 급여는 10% 인상되어 ??이다. (별칭 : 급여인상)
select first_name || ' ' || last_name || '의 급여는 10% 인상되어 ' || salary*1.1 || '이다.' 급여인상
from employees;



-- 4조
-- 1. 사원이름(풀네임), 입사일, 매니저번호 (매니저가 없을 경우 '-1' 으로 표시)
select first_name || ' ' || last_name, hire_date, nvl(manager_id, -1)
from employees;

-- 2. oo번 사원이 oo번 부서에서 oo업무를 시작하게 된 일자는 oo일 입니다. (별칭 "업무기록")
select employee_id || '번 사원이 ' || department_id || '부서에서 ' || job_id || '업무를 시작하게 된 일자는 ' || start_date || '일 입니다.' 업무기록
from job_history;

-- 3. 사원코드, 이름(풀네임), 커미션이 적용된 급여('변경전급여' 라 표시), 전사원커미션 +3.5 가 올라간 급여('변경후급여' 라 표시) 를 출력하세요.           
-- (커미션이 null 인경우는 0으로 계산합니다.)
select employee_id, first_name || ' ' || last_name, salary*(1+nvl(commission_pct, 0)) 변경전급여, salary*1.035 변경후급여
from employees;

-- 4. " location_id 는 US Texas Southlake 2014 jabberwocky Rd, 우편번호 입니다. " 와 같은 형식으로 select 문을 출력하세요(alias는 "주소" 입니다.) 
select location_id || '는 ' || country_id || ' ' || state_province || ' ' || city || ' ' || street_address || ', ' || postal_code || '입니다.' 주소
from locations;

-- 5. 직업이 xx인 사원의 이름 xxx 이며 급여는 xxx 입니다.
select '직업이 ' || job_id || '인 사원의 이름은 ' || first_name || '이며 급여는 ' || salary || '입니다.'
from employees;

-- 6. 직업  이름(풀네임) 사번 급여 커미션(0) 커미션합급여+2
select job_id 직업, first_name || ' ' || last_name 이름, employee_id 사번, salary 급여, salary*nvl(commission_pct, 0) 커미션, salary*(1+nvl(commission_pct, 0))+2 "커미션합급여+2"
from employees;

-- 7. 각 도시의 주소 정보를 출력하세요 (출력 예시 : XXX 도시의 XXX 우편번호는 XXX 입니다.)  (Alias : Address Info)
select city || ' 도시의 ' || street_address || ' 우편번호는 ' || postal_code || '입니다.' as "Address Info"
from locations;

-- 8. 직업 별 연봉 정보를 출력하세요 (출력 예시 : XX 직업의 연봉은 XXX ~ XXX 만원 입니다.)  (Alias : Salary Info)
select job_title || ' 직업의 연봉은 ' || min_salary || ' ~ ' || max_salary || '만원 입니다.' as "Salary Info"
from jobs;

-- 9. 사원이름(풀네임 중간에 띄어쓰기넣기), 계산한 커미션의 값을 검색하라, 컬럼명을 이름과 수수료로 설정하라.(커미션을 받지 않으면 0)
select first_name || ' ' || last_name 이름, salary*nvl(commission_pct, 0) 수수료
from employees;

-- 10. 사번, 급여, 300감봉 급여
select employee_id, salary, salary-300
from employees;

-- 11. 별칭을 붙일 수 없는 방법은?     
select employee_id as 사번
from employees;

select employee_id as "사번"  
from employees;

select employee_id "사번" 
from employees;

select employee_id 사번
from employees;

select employee_id '사번'
from employees;

-- 12. 사번, 이름(풀네임), 급여, 커미션포함급여, 100인상 후 커미션포함급여/ (전체 칼럼 이름 변경)
select employee_id 사번, first_name || ' ' || last_name 이름, salary 급여, salary*(1+nvl(commission_pct, 0)) "커미션 포함 급여", salary*(1+nvl(commission_pct, 0))+100 "인상 후"
from employees;