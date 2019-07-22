-- 1조

-- 1. 매니저 번호가 130미만은 초보  130이상 150이하는 중급 그외는 고급이다. 사번 이름 매니저번호를 오름차순으로 정리하라.

select employee_id, first_name, manager_id,
        case
            when manager_id < 130
            then '초보'
            when manager_id <= 150
            then '중급'
            else '고급'
        end
from employees
order by manager_id;

--답
select employee_id, first_name, manager_id,
        case 
        when manager_id < 130
        then '초보'
        when manager_id >= 130 and manager_id <= 150
        then '중급'
        else '고급'
    end 매니저스킬
from employees
order by manager_id;

-- 2. 48,456,231.20451 + 30000을 변환함수를 이용하여 푸시오

select '48,456,231.20451', to_number('48,456,231.20451', '00,000,000.00000') + 30000
from dual
union
-- 답
select '48,456,231.20451', to_number('48,456,231.20451','00,000,000.00000')+30000
from dual;


-- 3. 명예퇴직자
-- 시스템 현재날짜 기준 근속년 30이상 명예퇴직, 그외 보류
-- 사번, 이름, 전화번호, 부서
-- 명예퇴직자 기준 정렬
select employee_id, first_name, phone_number, department_id,
        case
            when to_char(sysdate, 'yyyy')-to_char(hire_date, 'yyyy') >= 30
            then '명예퇴직'
            else '보류'
        end 명예퇴직자
from employees
order by 명예퇴직자;

-- 답

select employee_id, first_name, phone_number,to_char(sysdate,'yyyy')- to_char(hire_date,'yyyy'),
    case when to_char(sysdate,'yyyy')- to_char(hire_date,'yyyy')>= 30
    then '명예퇴직'
    else '보류'
    end "명예퇴직자"
from employees
order by 명예퇴직자;


-- 4. 커미션포함급여가 4000 미만 상여금 10%
-- 커미션포함급여가 10000 미만 상여금 7%
-- 커미션포함급여가 20000 미만 상여금 5%
-- 커미션포함급여가 20000 이상 상여금 2%
-- 사번, 이름, 전화번호, 부서, 커미션포함급여(별칭 : 급여), 상여금포함급여(별칭 : 상여금)
select employee_id, first_name, phone_number, employee_id, salary*(1+nvl(commission_pct,0)) 급여,
        case
            when salary*(1+nvl(commission_pct,0)) < 4000
            then salary*(1+nvl(commission_pct,0)) * 1.1
            when salary*(1+nvl(commission_pct,0)) < 10000
            then salary*(1+nvl(commission_pct,0)) * 1.07
            when salary*(1+nvl(commission_pct,0)) < 20000
            then salary*(1+nvl(commission_pct,0)) * 1.05
            else salary*(1+nvl(commission_pct,0)) * 1.02
        end 상여금
from employees;

-- 답
select employee_id 사번, first_name 이름, phone_number 전화번호, department_id 부서, salary+salary*nvl(commission_pct,0) 급여,
case
    when salary+ salary *nvl(commission_pct,0)  <4000 
    then (salary +(salary *nvl(commission_pct,0))) *(1.1)
    when salary+ salary *nvl(commission_pct,0)  <10000 
    then (salary +(salary *nvl(commission_pct,0))) *(1.07)
    when salary+ salary *nvl(commission_pct,0)  <20000 
    then (salary +(salary *nvl(commission_pct,0))) *(1.05)
    else (salary +(salary *nvl(commission_pct,0))) *(1.02)
end "상여금 포함급여"
from employees
order by 급여;

-- 5. 오늘을 기준으로 근무년수를 구해라 
--"(사원이름)의 근무년수는 (00)년 입니다."의 형식으로 출력하라 
--concat함수 이용
select concat(first_name,
        concat('의 근무년수는 ',
        concat(to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy'),'년 입니다.')))
from employees;

-- 6. 근무지발령   
--job_id가 IT로 시작하면 '판교점발령'
--         S           '강남점발령'
-- 그 외                '홍대점발령'
--사원번호, 이름, job_id 근무지발령을 출력하라
select employee_id, first_name, job_id,
        case
            when upper(job_id) like 'IT%'
            then '판교점발령'
            when upper(job_id) like 'S%'
            then '강남점발령'
            else '홍대점발령'
        end 근무지발령
from employees
order by 근무지발령;


-- 7.--'hello oracle !!!'을  hello HELLO ,oracle ORACLE 로 분리시켜라.
select 'hello oracle !!!'a,
        substr('hello oracle !!!', 1, instr('hello oracle !!!', ' ' , 1, 1)-1)b,
        substr('hello oracle !!!',
                instr('hello oracle !!!', ' ', 1, 1)+1,
                instr('hello oracle !!!', ' ', 1, 2) - instr('hello oracle !!!', ' ', 1,1)-1)c
from dual;

8.--사번이 140미만은 바보
--사번이 180미만은 멍청이
--사번이 180이상은 똥개
--사번, 이름, 연봉, 똥멍청이로 출력
select employee_id, first_name, salary,
        case
            when employee_id < 140
            then '바보'
            when employee_id < 180
            then '멍청이'
            else '똥개'
        end 똥멍청이
from employees;

-- 9. 임금을 3자리(1000의자리) 에서 반올림하여 표현하시오
select round(salary, -3)
from employees;

-- 10. 사원 전화 번호의 .을 -으로 바꿔 표시하시오.




-- 2조

-- 1.자기가 태어난 날부터 현재까지 몇일이 지났는지 계산해보기
select concat(trunc(sysdate - to_date('19890728','yyyymmdd'), 0),'일 지남')일,
        months_between(sysdate, to_date('19890728', 'yyyymmdd'))개월
    
from dual;

-- 2.현재시각을 나타내야한다. 단, 조건이 있는데 조건은 
--	*'현재시각은 오전(오후) 00시 00분 00초 입니다.' 로 출력되어져야하고
--	*12시 이전은 오전, 12시 이후는 오후 이다.
--	*매 20초, 40초 마다 '안녕하세요.' 라고 출력이 되야한다.
select case
            when to_char(sysdate, 'ss') = 20
            then '안녕하세요.'
            when to_char(sysdate, 'ss') = 40
            then '안녕하세요.'
            else ' '
        end 인사,
        to_char(sysdate, 'am hh"시 "mi"분 "ss"초 입니다."')
from dual;


-- 3.지역ID,국가ID,도시,대륙을 출력하시오.(북미(캐나다,미국)/서유럽(영국)/동유럽(독일))
--  별칭을 위에 지정한 것으로 할 것
select location_id 지역ID, country_id 국가ID, city 도시,
        case
            when country_id = 'DE'
            then '동유럽'
            when country_id = 'UK'
            then '서유럽'
            else '북미'
        end 대륙
from locations;

select *
from countries;


-- 4.직원의 ID, 이름, 전화번호, 통신사를 출력하시오.
--  직원의 전화번호가 5로 시작하면 통신사를 SKT, 6으로 시작하면 KT,0으로 시작하면 LG 로 지정하시오 
--  또한 통신사 별로 정렬하시오.
select employee_id, first_name, phone_number,
        case
            when phone_number like '5%'
            then 'SKT'
            when phone_number like '6%'
            then 'KT'
            else 'LG'
        end 통신사
from employees
order by 통신사;


-- 5.사원번호, 사원이름, 입사일,입사월 마지막날짜,입사일 다음 일요일의 날짜, 입사 후 100일의 날짜를 검색하라
select employee_id 사원번호, first_name 사원이름, hire_date 입사일, last_day(hire_date) "입사월 말일",
        next_day(hire_date, 1) "입사일 다음 일요일", hire_date +100 "입사 후 100일"
from employees;


-- 6.사원들의 이름을 풀네임으로 작성하라(concat이용하고 이름사이에 공백넣기)
select concat(first_name, concat(' ', last_name)) "full name"
from employees;


-- 7. 성과등급
-- 입사일이 1995년 이후인 사원들 중,
-- 급여가 5000 미만인 사원은 C
-- 급여가 10000 미만인 사원은 B
-- 급여가 10000 이상인 사원은 A
-- 직원번호, 이름, 입사일, 급여, 성과등급을 출력하라. 성과등급을 내림차순으로 정렬하라

select employee_id 직원번호, first_name 이름, hire_date 입사일, salary 급여,
        case
            when salary < 5000
            then 'C'
            when salary < 10000
            then 'B'
            else 'A'
        end 성과등급
from employees
where to_char(hire_date, 'yyyy') >= 1995
order by 성과등급 asc;


-- 8. 근속년수가 올해로 20년 이상 25년 이하인 사람들에게 보너스를 지급할 예정이다. 다음과 같은 기준으로 보너스를 산정하라.
-- 급여가 5000 미만인 사람은 30%
-- 급여가 10000 미만인 사람은 20%
-- 급여가 10000 이상인 사람은 10%
-- 급여는 커미션을 포함한 것으로 계산하며, 근속년수는 연단위로 계산한다(월,일은 고려하지 않음).
-- 직원번호, 이름, 입사일, 커미션을 포함한 급여, 보너스를 출력하고, 보너스를 기준으로 내림차순 정렬하라.

select employee_id, first_name, hire_date, salary*(1+nvl(commission_pct,0)),
        case
            when salary*(1+nvl(commission_pct,0)) < 5000
            then salary*(1+nvl(commission_pct,0)) * 0.3
            when salary*(1+nvl(commission_pct,0)) < 10000
            then salary*(1+nvl(commission_pct,0)) * 0.2
            else salary*(1+nvl(commission_pct,0)) * 0.1
        end 보너스
from employees
where (to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy')) between 20 and 25
order by 보너스 desc;

9.-- 고용된 날짜가 사원들의 생년월일이라고 가정하고 사원들의 풀네임과 생년월일, 현재나이대(2019년 기준)를 구하시오. 
  -- 나이대는 20대 30대 40대로 구성할 것, 그리고 별칭은 '나이대'로 설정
  -- 그리고 어린 사람들을 기준으로 위로 정렬할 것

select concat(first_name, concat(' ', last_name)), hire_date,
        case
            when (2019 - to_char(hire_date, 'yyyy')) < 30
            then '20대'
            when (2019 - to_char(hire_date, 'yyyy')) < 40
            then '30대'
            else '40대'
        end 나이대
from employees
order by 나이대 asc, hire_date;


-- 3조

1.
-- 각 사원의 이름, 부서번호, 급여, 급여별 레벨을 출력하기
-- 단, 레벨의 종류와 기준은 Job_Grades 테이블을 참고한다.
-- 단, 레벨을 기준으로 오름차순 정렬한다.
-- 단, 레벨에 별칭을 준다(급여별 레벨).

2.
-- 강의 A가 2019년02월20일부터 2019년07월16일까지 실행될 때, 총 기간이 며칠인지 구하시오
-- 단, 날짜는 20190220, 20190716 형태의 숫자로부터 시작한다.
-- 단, 주말도 포함한다
-- 단, 별칭은 수강기간

3.
-- 부서명(department_name)의 마지막 글자를 제외하고 출력하라.
-- 부서명, 마지막글자를 제외한 부서명 출력 및 정렬)

4
-- emp테이블에서 sal이 3000미만 이면 c등급, 3000에서 3900이하 B등급
-- 4000 이상이면 A등급으로 등급을 나타내어라
-- 사번, 이름(풀네임), 급여, 등급별로 정렬)

5.
--사원들의 '이름 성'(concat함수 사용), 연봉, 연봉*커미션 값
(단, 커미션이 있을 경우 일괄적으로 5%적용, 없을 경우 0으로 일괄 적용할 것)


6.
--. 사원들의 전화번호에 '.'과 '.'사이에 있는 4자리 수를 출력하라

7.
--사번,이름, job_id, 근무상황(별칭)
--미국에서 일하는 부서일 경우 "본사근무"
--캐나다에서 일하는 부서일 경우 "파견근무"
--영국에서 일하는 부서일 경우 "해외출장"
--본사, 파견, 해외 순으로 정렬
--부서코드가 없을시에는 '본사근무'로 취급

8.
--아래와 같이 출력되게 코드를 작성하시오.
--'풀네임'의 부서번호와 부서코드는 '90''AD'
--부서를 명시할때는 job_id의 앞 두글자(ex)ST,IT,AD)로 명시. 별칭 부서번호와 코드

9.
--직책이름, 최대급여, 직무별 소득분류를 출력하시오.
--이때 최대급여가 10000이하인 직무는 저소득, 10000은 초과하지만20000이하인 직무는 중간소득, 20000을 초과하는 직무는 고소득으로 정하여 직책분류를 만들고, 직책이름을 기준으로 정렬하시오. 이때, 직책이름은 모두 대문자로 표기하시오.

10.
--오늘날짜를 yymmdd형식으로 문자로 바꾼후 숫자로 다시바꿔 123456을 더한값을 출력하라.

11.
--시스템시간기준 144일후를 yyyy mm dd day 형태로 나타내주세요. 별칭은 "수료일"

12.
--2019/07/21 은 2019년도로부터 몇 번째 날일까?



-- 4조

1. '-' 두개일때 각각의 자리 구하는 쿼리 ex) 010-1234-5678

2. 사번이 100~199번인 사원의 사번, 이름, 급여, 커미션포함급여 ( 100자리수표시)


3. 사원번호, 이름, 급여, 커미션포함급여, 커미션포함급여가 속한 급여등급을 표시 (커미션포함급여로 내림차순)
 -- 급여등급은 job_grades 테이블을 참고


4.
-- phone_number 에서 '.' 구분자가 3개면 핸드폰번호, 2개면 집 전화번호 라고 가정하고 
   집전화번호는 앞에 '02.' 을 추가하고(concat 사용) 핸드폰번호는 그대로 두고 출력한다.
-- 최종출력 : 사번, 기존폰번호, 변경된번호, 폰번호 종류


5.
-- job_id 를 통해 어떤 사업부에서 일하는지 분류하여라.(job_id 의 '_' 이전이 사업부코드라 가정하며 _이전에는 몇개의 알파벳이 올지 알 수 없다.)
-- ad : Administration
-- ac : Accounting
-- sa : Sales
-- st : Stock
-- it : It
-- mk : Marketing
-- 최종형태 : 사번, last_name(이름), job_id(직업코드), 사업부
-- 정렬은 사업부, 사번 순으로 오름차순


6.
-- 근속일에 따른 커미션 상승과 근속월에 따른 임금상승을 하려고 한다.
-- 커미션상승은 근속일 8천미만은 +1, 1만미만은 +2, 그 이상은 +3 (기존에 commission_pct 없다면 0으로 생각)
-- 임금상승은 250주 미만은 +1000 , 300주 미만은 +2000, 350주 미만은 +3000, 350주 이상은 + 5000 을 한 값을 구하라.
-- 사번, 입사일, 기존 커미션, 상승된커미션, 기존임금, 상승된임금 (사번, 입사일순으로 오름차순)


7.
-- 1. 다음의 조건들을 만족하는 "결과" 열을 출력하세요 (내림차순으로 정렬)
-- 1) 부서 번호가 없는 경우 : 풀 네임
-- 2) 관리자 번호가 없는 경우 : 고용 일을 XXXX-YY-ZZ 형식으로
-- 3) 커미션을 알 수 있는 경우 : 봉급에 커미션을 포함하여 십의 자리에서 반올림하고 5자리로 표현 (단, 5자리 보다 작을 경우 공백 처리)
------ 1), 2), 3) 조건을 만족하지 않는 경우 --
-- 4) 이름이 3글자인 경우 : 현재 날짜 기준으로 근속 년수
-- 5) IT로 시작하는 직무인 경우 : 전화번호
------ 4), 5) 조건을 만족하지 않는 경우 --
-- 6) 고용일이 80년대인 경우 : 봉급을 5자리로 표현 (단, 5자리 보다 작을 경우 공백 처리)
-- 7) 그 외의 경우 : 이메일

