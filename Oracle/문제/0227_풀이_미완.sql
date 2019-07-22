-- 1조

--1.사번, 이름, 부서번호, 부서이름, 매니저번호, 비고
--비고 : 매니저와 커미션이 둘 다 없으면 '퇴사자'라고 표시, 있으면 빈칸으로 두기 (case when then/ ansi 이용)

select e.employee_id, e.first_name, e.department_id, d.department_name, e.manager_id, 
        case 
            when e.manager_id is null
                    and e.commission_pct is null
            then '퇴사자'
            else ' '
        end "비고"
from employees e join departments d
on e.department_id = d.department_id;



-- 답
select e.employee_id, e.first_name, d.department_name, e.manager_id,
        case 
        when e.manager_id is null and e.commission_pct is null
        then '퇴사자'
        else ' '
        end 비고
from employees e join departments d
on e.department_id=d.department_id;



-- 2.--국가번호, 국가이름, 지역이름, 우편번호를 구해라(anti join/ using이용)
select l.country_id, c.country_name, r.region_name, l.postal_code
from locations l join countries c
on l.country_id = c.country_id
join regions r
on c.region_id = r.region_id;

-- 답
select country_id, c.country_name, r.region_name, l.postal_code
from countries c join regions r
using(region_id)
join locations l
using(country_id);





--3.--직책 아이디가 'SA_REP'인 모든 사원의
--사번, 이름,직책이름,부서이름
--단, 부서가 없는 경우 '대기발령'으로 출력
select e.employee_id, e.first_name, j.job_title, nvl(d.department_name , '대기발령')
from employees e, jobs j, departments d
where e.job_id = j.job_id
            and e.department_id = d.department_id(+)
        and lower(e.job_id) = lower('SA_REP');



-- 답

SELECT E.EMPLOYEE_ID,E.FIRST_NAME,J.JOB_ID,NVL(D.DEPARTMENT_NAME,'대기발령')
FROM EMPLOYEES E,DEPARTMENTS D,JOBS J
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+)
AND E.JOB_ID = J.JOB_ID
AND UPPER(J.JOB_ID) = UPPER('SA_REP')
;




--4.--모든 사원의 사번,이름,상관사번,상관이름, 부서이름
--상관 사번이 없을 경우 상관 사번을 '없음'으로 출력하고 별칭을 상관번호
--단 상관이 없을 경우 상관이름에 '본인'으로 출력하고 별칭을 담당자
--단, 부서가 미지정일 경우 부서이름을 '대기발령중'출력
select e.employee_id 사번, e.first_name 이름, 
        nvl(to_char(e.manager_id, '999999') , '없음') 상관사번, 
            case                                    -- 근데 지금 여기서 굳이 case를 써야 함?
                when e.manager_id is null
                then '본인'
                else m.first_name
            end 담당자,
        nvl(d.department_name, '대기발령중') 부서이름
from employees e, employees m, departments d
where e.manager_id = m.employee_id(+)
        and e.department_id = d.department_id(+);



select nvl(e.manager_id , '없음') 상관사번 -- 에러 발생
from employees e, employees m
where e.manager_id = m.employee_id(+);

select *
from employees e, employees m
where e.manager_id = m.employee_id(+);




--답
SELECT E.EMPLOYEE_ID
            ,E.FIRST_NAME
            ,NVL(TO_CHAR(M.EMPLOYEE_ID,'9999'), '없음')"상관번호"
            ,NVL(M.FIRST_NAME,'본인')"담당자"
            ,NVL(D.DEPARTMENT_NAME,'대기발령중')
FROM EMPLOYEES E
            ,EMPLOYEES M
            ,DEPARTMENTS D
    WHERE E.MANAGER_ID=M.EMPLOYEE_ID(+)
    AND E.DEPARTMENT_ID=D.DEPARTMENT_ID(+);





5.-- 모든 사원의 사번, 이름, 부서이름, 근무지, 근무나라 를 구하시오


6.-- 모든 사원, 부서, 나라의 사번, 이름, 부서이름, 근무지, 근무나라를 구하시오 (각각 별칭을 지정)
-- 단, 부서가 없는 경우 '미정'
-- 단, 부서는 있지만 근무자가 없는 경우 이름에 '근무자없음'
-- 그외의 널 값은 '-'


7.-- 각 부서 별 사원의 급여등급을 표시하시오
-- 출력: 사원번호, 부서 이름, 사원 이름, 급여등급


8.-- 모든 사원의 사원 아이디, 부서이름 (null일 경우 미정) , 연봉에 커미션을 포함했을때의 값을 기준으로 한 연봉등급, 으로 표현하시오
-- 출력:  사원 부서 아이디, 부서이름, 연봉등급 


9.--us에 사는 모든사원의 사번 이름 부서번호 부서이름 나라이름을 쓰시오(ansi 조인을 쓰시오)



10.--사원의 사번 이름 최고급여 최저급여를 non-equi를 이용하시오



-- 2조


--1. 'sales' 부서에서 근무하며, 이름(first_name)이 'a ~ e'로 끝나는 사원의
-- 사번, 이름, 부서이름, 직무이름, 근속 연수, 비고를 출력하라
-- 단, 근속 연수는 시스템 날짜를 기준으로 월/일을 고려하지 않고 산정하며, '30년 근무하였습니다."의 형태로 출력한다.
-- 근속연수가 25년 이상이면 비고에 '장기근속자'를, 그 이외의 경우에는 공란으로 출력하라.
select e.employee_id 사번, e.first_name 이름, d.department_name 부서이름, j.job_title 직무이름,
        concat((to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy')), '년 근무하였습니다.') "근속 연수",
        case
            when (to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy')) >= 25
            then '장기근속자'
            else ' '
        end "비고"
from employees e, departments d, jobs j
where e.department_id = d.department_id
            and e.job_id = j.job_id
        and ascii(substr( e.first_name, length(e.first_name), 1)) between 97 and 101;



--2. 직무 변동이 없었던 사원의 사번, 이름, 부서이름, 직무이름, 입사 연도, 커미션을 포함한 급여를
-- 사번 순서로 정렬하여 출력하라 
-- join 사용
select e.employee_id 사번, e.first_name 이름, d.department_name 부서이름, j.job_title 직무이름,
        to_char(e.hire_date, 'yyyy') 입사연도, e.salary*(1+nvl(e.commission_pct, 0)) 급여
from employees e, job_history h, departments d, jobs j
where e.employee_id = h.employee_id(+)
        and h.employee_id is null
        and e.department_id = d.department_id(+)
        and e.job_id = j.job_id
order by e.employee_id; 

select *
from employees e, job_history h
where e.employee_id = h.employee_id(+)
        and h.employee_id is null;

-- subquery 사용
select e.employee_id 사번, e.first_name 이름,
        (select department_name from departments where e.department_id = department_id) 부서이름,
        (select job_title from jobs where e.job_id = job_id) 직무이름,
        to_char(e.hire_date, 'yyyy') "입사 연도", e.salary*(1+nvl(e.commission_pct, 0)) 급여
from employees e
where e.employee_id <> all (select employee_id
                            from job_history)
order by e.employee_id;

3.
--trenna rajs 한사람이 모든 부서에서 일을 했을 때의 일련코드(사번+부서이름+고용일+매니저이름)를 만들고자 한다.
--단 매니저가 없을 땐 매니저번호를 x 이라고 한뒤 출력



4.
--모든 국가의 사원의 사번, 이름, 부서번호,도시,국가이름을 쓰시오 (oracle join으로)


5.
--모든 사원의 사번, 이름, 커미션이 포함된 급여(커미션 없으면 그냥 급여), 매니저이름, 급여수준을 구하시오
--매니저가 없는 사람은 '사장'이라고 쓰시오
--급여수준은 5000미만 이면 하, 10000미만이면 중, 10000이상이면 상 이다. (ANSI join으로 쓰시오)


6. 급여가 4000 미만인 사원은 3년차
            10000 미만         5년차
            10000 이상         10년차

'Seattle'에 사는 사원의 사번, 이름, 급여, 부서이름, 도시,경력을 구하여라
(case문과 조인을 이용하여 풀어라, null값도 모두 표시) 
경력을 내림차순으로 정렬




7. 'programmer'의 사번, 이름, 직책, 직업을 출력하라(ansi조인으로)



8. 
-- 성이나 이름에 's'가 들어가는 사람들을 기준으로
-- 풀네임, 사번, 직책, 부서이름을 출력할 것
-- hint : 총 9명 나옴!


-- 3조

1. 
--inner join 사용할것, 매니저아이디가 100번인 사원의 사번, 이름, 부서이름


2. 
--inner join 사용할것, Washington 주에 위치한 부서의 부서번호와 부서이름


3. 
--ANSI 조인을 사용하여 'accounting' 부서 소속 사원의 이름과 입사일을 출력하세요.
--단, 입사일은 년도만 표기 하시오.    


4.
--ANSI 조인을 사용하여 토론토에서 근무하는 사원의 이름과 급여를 출력하세요.

5.모든 부서에 근무하는 사원의 이름, 직책이름, 부서이름
-- 단, 부서가 미지정인 경우, 부서이름은 '미지정'으로 출력
-- 결과 : 20행

6.
--모든 사원의 사번, 이름, 경력 중 당시직책이름
-- 단, 경력이 없는 사원의 경우, 당시직책이름은 '경력 없음'으로 출력
-- 결과 : 23행
7.
-.모든 사원들에게 설선물 세트를 배송하려한다.
--ansi join을 이용하여사원들의 지역에 따른 우편번호를 알아내시오.
--모든 사원들의 사번, 이름, 부서 이름, 우편번호

8.
--위에서 사용한 것과 다른 형식의 ansi join 을 이용하여
--모든 사원들의 사번, 이름, 부서 이름, 우편번호
--부서가 따로 없는 경우 '대기발령중', 우편번호가 없을경우 '자택수령' 으로 표시한다.



9.
--모든 직원의 이름, 연봉, 직책이름, 연봉 수준
--단, 연봉이 높은 순으로 정렬하라


10
--모든 사원의 이름, 부서이름, 도시, 나라이름, 대륙이름 출력(join을 이용해서 출력)

11.
-- 이직 경험이 있는 사원의 이름(현재 없으면 '현재퇴사') "인사이동", 당시직업이름 "직업" (이름순정렬)



12.
-  이직 경험이 있는 사원의 이름(현재 없으면 '현재퇴사') "인사이동", 당시직업이름 "직업" (이름순정렬)  (right join써주세요)



-- 4조

1--모든사원의 사번, 이름, 부서이름 ,부서번호 , 상관사번, 상관이름 , 상관부서번호, 상관부서이름
--null : 사원없음, 사장 , 대기발령  
--Join 을 이용하여 출력




2--
--모든 사원의 이름 부서이름 도시이름, 국가이름

1. 한번도 직책이 변경된 적이 없는 사람의 사번과 이름 출력



2. 퇴직자사번, 퇴직일자 찾기
-- 직책이 변경된 이력은 있지만 현재 사원테이블에는 없는 사람을 퇴직한 사람이라 하고, 직책이 끝난날을 퇴직일이라 한다.


3.모든 부서 모든 사원 근무하는 사원의 사번, 이름(사원 없음), 부서번호, 부서이름, 부서, 도시이름(seattle) (ansi 사용하기)(소문자만 사용)

상식문제


맞는것은?


1.join 바로 뒤에 on, where 둘다 사용 가능하다.
2.natural join은 컬럼이 달라도 자동으로 조인된다.
3.(+)는 기준에 상관 없이 항상 아무곳에 들어가면 안된다.

1999년 1월 1일 이후에 입사한 사원번호, 사원명, 부서번호, 부서명 (ansi join)


1. -- 근무 지역이 미국인 사원들의 사번, 급여, 급여 등급, 상급자 번호
         -- 해당 data가 없는 경우에는 '-1'으로 표시


2. -- 급여 등급이 B, D, F 인 사원들의 이름, 급여, 근무 도시 (JOIN 키워드 사용)

