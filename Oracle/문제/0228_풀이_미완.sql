-- 1조

--1.--20번 부서의 최대급여
--80번 부서의 최소급여
select 
(select max(salary) from employees where department_id = 20) "20번 최대급여",
(select min(salary) from employees where department_id = 80) "80번 최소급여"
from dual;

--2.--'Toronto'에 근무하는 사원의 사번 이름 부서번호 직업번호
select 



3.--모든 사원의 사번 이름 급여 급여등급 부서이름
--단 A는 1등급,B는 2등급 ---- F는 6등급   (decode 를 이용해라)




4.--20번 부서의 최고급여 별칭 부서 20 최고급여
--50번 부서의 최저급여 별칭 부서 50 최저급여
--60번 부서의 평균급여 별칭 부서 60 평균급여
--80번 부서의 급여총합 별칭 부서 80 급여총합
--90번 부서의 인원수   별칭 부서 90 인원수




5. 'sales'에서 일하는 사원의 사번, 이름, 급여을 서브쿼리를 이용하여 나타내시오
-- 급여에 원을 붙이시요 (ex. 15000원)



6. 'Toronto'에 있는 부서의 사원 모두
-- 사원번호, 사원이름, 부서이름
-- 서브쿼리 사용


7. postal_code가 26192인 부서의 번호와 이름을 나타내라




8. postal_code가 26192인 곳에서 근무하는 직원들의 사번, 이름, 핸드폰번호를 출력해라.



9.--20번 부서의 최대 급여 보다 최대 급여가 큰 직급들을 출력하시오



10. -- 문제 2 부서이름이 'Sales'이거나, 대륙 'Europe' 인 사원의 사원번호와 사원의 이름을 검색하라 (질문)



-- 2조


-- 'Executive'부서에 속한 사원 중에서, 직무 변동이 없었던 사원들의
-- 사원번호, 이름, 급여, 급여 등급을 출력하라
-- 단, join은 1회만 사용한다.

select sd.employee_id 사원번호, sd.first_name 이름, sd.salary 급여, 
        (select grade_level from job_grades where sd.salary between lowest_sal and highest_sal) "급여 등급"
from (select * from employees where department_id = (select department_id
                                                        from departments
                                                        where lower(department_name) = lower('Executive')
                                                        )
                                                        ) sd,
        job_history h
where sd.employee_id = h.employee_id(+)
        and h.employee_id is null;

-- 4조


1. 110번 부서에 있는 사원들보다 급여를 적게 받는 사원의 사번, 이름, 급여


2. 근무지역이 영국인 사원들의 평균 급여보다 크고,
-- 누군가의 상급자인 사원으로서 부서 번호가 (10, 20, 90)이 아닌 사원의
-- 사번, 이름, 급여, 부서번호



3. 각 부서에서 최고급여를 받는 사람의 사번, 이름, 봉급




4. 다음 사람들의 정보를 출력해라
-- 사원table에 manage_id 로 등록된 사원들의 사번 이름 급여 를 출력
-- 사번, 이름, 부서명


5. 직책이 바뀐 적이 있던 사원(job_history)의 사번, 이름, 급여, 그 사원이 속한 부서에서 최고급여




6. 80번 부서에 있는 사원들 보다 급여를 많이 받는 사원의 사번 ,이름 ,급여




7. 지역번호가 1700인 부서에서 일하는 사원의
--사번, 이름, 부서번호, 부서이름



8. 20번 부서의 평균급여
-- 부서이름 총 수
-- 매니저인 사원 총 인원수



9.부서번호가 20번의 평균 급여보다 크고,
-- 부서장 사원으로 부서번호가 80,90 아닌 사원의
-- 사번, 이름, 급여, 부서번호

