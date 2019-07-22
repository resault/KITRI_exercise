-- 숫자함수









select 1234.5438, round(1234.5438) round1, round(1234.5438, 0) round2,
        round(1234.5438, 1) round3 , round(1234.5438, -1) round4,
        round(1234.5438, 3) round5, round(1234.5438, -3) round6
from dual;

select 1234.5438, trunc(1234.5438) round1, trunc(1234.5438, 0) round2,
        trunc(1234.5438, 1) round3, trunc(1234.5438, -1) round4,
        trunc(1234.5438, 3) round5, trunc(1234.5438, -3) round6
from dual;

select 1234.5438, floor(1234.5438)
from dual;

select 5 + 3, 5 - 3, 5 * 3, 5 / 3, mod(5, 3)
from dual;

select abs(5), abs(-5), abs(+5)
from dual;

-- 사원의 사번, 이름, 급여, 커미션포함급여
-- 커미션 포함 급여는 100의 자리수로 표현(반올림)
select employee_id 사번, first_name 이름, salary 급여,
        round(salary*(1+nvl(commission_pct, 0)), -2) 커미션포함급여
from employees;


-- 문자함수

select 'kiTRi', lower('kiTRi'), upper('kiTRi'), initcap('kiTRi KKK'), length('kiTRi')
from dual;

-- full name
select employee_id, first_name, last_name,
        first_name || ' ' || last_name "full name",
        concat(first_name,concat(' ' , last_name)) concat
from employees;

select 'hello oracle !!!', 
        instr('hello oracle !!!', 'o') instr, instr('hello oracle !!!', 'o', 6) instr1
from dual;

-- 123-456, 123 zip1, 456 zip2 >>> 1234-56으로 바꾸어도 결과가 나오게
select '123-456' "zipcode",
        substr('123-456', 1,instr('123-456', '-')-1)zip1,
        substr('123-456', instr('123-456', '-')+1)zip2,
        '1234-56' "zipcode",
        substr('1234-56', 1,
        instr('1234-56', '-')-1)zip3,
        substr('1234-56', instr('1234-56', '-')+1)zip4
from dual;


-- 날짜함수

select sysdate, sysdate + 3, sysdate -3,
        to_char(sysdate + 3 /24, 'yyyy-mm-dd hh24:mi:ss')
from dual;

select sysdate, months_between(sysdate, sysdate + 70)개월차,
        next_day(sysdate, 1)"다음 일요일", next_day(sysdate, 3)"다음 화요일",
        add_months(sysdate, 2)"2달 후",
        last_day(sysdate)"마지막 날"
from dual;

select sysdate, to_char(sysdate, 'yyyy') "4자리", to_char(sysdate, 'yy') "2자리",
        to_char(sysdate, 'mm') "월(숫자)",
        to_char(sysdate, 'mon') "월(문자_약어)", to_char(sysdate, 'month') "월(문자)",
        to_char(sysdate, 'w') 주차, to_char(sysdate, 'ww') 주차_연,
        to_char(sysdate, 'd')"요일_숫자",
        to_char(sysdate, 'dy')"요일_약문자", to_char(sysdate, 'day')"요일_문자", 
        to_char(sysdate, 'dd')일자, to_char(sysdate, 'ddd')일자_연
from dual;

select to_char(sysdate, 'hh')"12시간제", to_char(sysdate, 'hh12')"12시간제",
        to_char(sysdate, 'am hh')"오전/오후 시간", to_char(sysdate, 'pm hh')"오전/오후 시간",
        to_char(sysdate, 'hh24')"24시간제",
        to_char(sysdate, 'mi')분, to_char(sysdate, 'ss')초
from dual;



select to_char(sysdate, 'yyyy.mm.dd hh24:mi:ss')a,
        to_char(round(sysdate), 'yyyy.mm.dd hh24:mi:ss')b, -- 일을 기준으로 해서 시간에서 반올림
        to_char(round(sysdate, 'dd'), 'yyyy.mm.dd hh24:mi:ss')c, -- 위와 동일
        to_char(round(sysdate, 'mm'), 'yyyy.mm.dd hh24:mi:ss')d, -- 월을 기준으로 해서 일에서 반올림
        to_char(round(sysdate, 'yy'), 'yyyy.mm.dd hh24:mi:ss')e, -- 년을 기준으로 해서 월에서 반올림
        to_char(round(sysdate, 'hh'), 'yyyy.mm.dd hh24:mi:ss')f, -- 시를 기준으로 해서 분에서 반올림
        to_char(round(sysdate, 'mi'), 'yyyy.mm.dd hh24:mi:ss')g -- 분을 기준으로 해서 초에서 반올림
from dual
union
select to_char(sysdate, 'yyyy.mm.dd hh24:mi:ss')a,
        to_char(trunc(sysdate), 'yyyy.mm.dd hh24:mi:ss')b, -- 일을 기준으로 해서 시간에서 버림
        to_char(trunc(sysdate, 'dd'), 'yyyy.mm.dd hh24:mi:ss')c, -- 위와 동일
        to_char(trunc(sysdate, 'mm'), 'yyyy.mm.dd hh24:mi:ss')d, -- 월을 기준으로 해서 일에서 버림
        to_char(trunc(sysdate, 'yy'), 'yyyy.mm.dd hh24:mi:ss')e, -- 년을 기준으로 해서 월에서 버림
        to_char(trunc(sysdate, 'hh'), 'yyyy.mm.dd hh24:mi:ss')f, -- 시를 기준으로 해서 분에서 버림
        to_char(trunc(sysdate, 'mi'), 'yyyy.mm.dd hh24:mi:ss')g -- 분을 기준으로 해서 초에서 버림
from dual;



-- 변환함수

select 'a', 3, '3', 3 + 5, '3' + 5
from dual;

select 1123456.789,
        to_char(1123456.789, '000,000,000.00')a,
        to_char(1123456.789, '999,999,999.99')b, -- 백만단위 앞에 공간 두개가 있는 것임!
        length(to_char(1123456.789, '000,000,000.00'))c,
        length(to_char(1123456.789, '999,999,999.99'))d,
        to_char(1123456.789, '$999,999,999.99')e
from dual;

select to_char(-12, '99pr'), to_char(-12, '99mi')
from dual;

select '123,456.98', to_number('123,456.98', '000,000.00') + 3 a -- 인수2의 형태는 인수1과 동일해야 함.
from dual;

select sysdate, to_char(sysdate, 'yy.mm.dd')a,
        to_char(sysdate, 'am hh:mi:ss')b,
        to_char(sysdate, 'hh24:mi:ss')c
from dual;


-- 20190225142154 >> 날짜 >> 3일 후 (정답: 2/28)
select to_char( (to_date(to_char(20190225142154, '00000000000000') ,'yyyy.mm.dd hh24:mi:ss'))+3, 'yyyy.mm.dd hh:mi:ss')
from dual;

select to_char( (to_date(to_char(20190225142154, '00000000000000') ,'yyyymmddhh24miss'))+3, 'yyyy.mm.dd hh:mi:ss')
from dual;

    -- 숫자 형식지정을 안해도 자동변환됨. 비추
select to_char(20190225142154)
from dual;

    -- 자동형변환이 적용된 형태임. 비추
select to_date(20190225142154,'yyyy.mm.dd hh24:mi:ss')
from dual;




-- 일반함수

select commission_pct, nvl(commission_pct, 0), nvl2(commission_pct, 1, 0)
from employees;

-- 연봉등급
-- 급여가 4000 미만인 사원은 저연봉
-- 급여가 10000 미만인 사원은 평균연봉
-- 급여가 10000 이상인 사원은 고연봉
-- 사번, 이름, 급여, 연봉등급

select employee_id, first_name, salary,
        case
            when salary < 4000
            then '저연봉'
            when salary < 10000
            then '평균연봉'
            else '고연봉'
        end 연봉등급
from employees
order by salary desc;


-- 사원구분
-- 1980년도 입사 임원
-- 1990년도 입사 평사원
-- 2000년도 입사 신입사원
-- 사번, 이름, 입사일, 사원구분

select employee_id 사번, first_name 이름, hire_date 입사일,
        case
            when to_char(hire_date, 'yyyy') < '1990'
            then '임원'
            when to_char(hire_date, 'yyyy') < '2000'
            then '평사원'
            else '신입사원'
        end 사원구분
from employees;

select employee_id 사번, first_name 이름, hire_date 입사일,
        case
            when to_char(hire_date, 'yyyy') < 1990  -- 아스키 코드값을 통해 비교연산이 가능함
            then '임원'
            when to_char(hire_date, 'yyyy') < 2000
            then '평사원'
            else '신입사원'
        end 사원구분
from employees;

select employee_id 사번, first_name 이름, hire_date 입사일,
        case
            when to_number(to_char(hire_date, 'yyyy'), '0000') < 1990
            then '임원'
            when to_number(to_char(hire_date, 'yyyy'), '0000') < 2000
            then '평사원'
            else '신입사원'
        end 사원구분
from employees;


select employee_id 사번, first_name 이름, hire_date 입사일,
        case
            when substr(to_char(trunc(hire_date, 'yyyy'), 'yyyy'), 1, 3) = '198'
            then '임원'
            when substr(to_char(trunc(hire_date, 'yyyy'), 'yyyy'), 1, 3) = '199'
            then '평사원'
            else '신입사원'
        end 사원구분
from employees;



-- 문자의 비교

select case when 'a' < 'b' then '작다'
            else '크다'
        end
from dual;

select case when 'abc' < 'abe' then '작다'
            else '크다'
        end
from dual;

-- 암기할 것
select ascii('0'), ascii('A'), ascii('a'), chr('48')
from dual;