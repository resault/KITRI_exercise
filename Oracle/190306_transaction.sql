select* from tab;


purge recyclebin;   -- 휴지통 비우기



-- subquery를 이용한 insert
select *
from emp_blank;

insert into emp_blank
select *
from employees
where department_id = 80;   --- value 자리에 query 문으로 값을 가져옴..?? << 확인



-- 예제
-- 1. 100번 사원의 사번, 이름, 직책, 부서번호
-- emp_blank 삽입
insert into emp_blank (employee_id, first_name, last_name, email, hire_date, job_id, department_id)
select employee_id, first_name, last_name, email, hire_date, job_id, department_id
from employees
where employee_id = 100;


-- update               ---- update all 없음!!
-- 'java2'의 비번을 9876으로 변경
update member
set pass = 9876
where id = 'java2'; 


-- 'java2'의 비번을 1234로, 나이를 25로 변경
update member
set pass = 1234, age = 25       -- 여러 컬럼을 한번에 변경할 때는 , 로 나열
where id = 'java2';



-- 'java2'의 비번을 5678, 나이를 아이디가 oracle인 사람과 같게 변경
update member
set pass = 5678, age = (select age from member where id = 'oracle')     -- update의 subquery    
where id = 'java2';


-- 주소에 '구로'가 들어가는 회원들의 비밀번호를 87654321 로 변경
update member
set pass = 87654321
where id in (select id from member_detail where address = '%구로%');  --  update의 where절의 subquery



-- 응?? id 안바뀐다고 했는데 됨;; 이거 detail은 안 만들어서 그런가? >> ㅇㅇ 맞음 
-- (나는 이거 실습할때 detail에 데이터 입력 안함ㅋㅋ 다른사람들은 어제 워크시트 중에서 insert all 예제 가져와서 member랑 member_detail 모두에 데이터 입력함)
-----------  >> primary key 라도 변경 가능(단 update로 변경하는건 권장되지 않음) 다만 다른 테이블에서 해당 키를 참조할 때는 변경 불가! (참조 테이블의 참조 무결성에 위배됨)

update member
set id = 'abc'
where id = '정현정';



-- DELETE [FROM] table_name
-- 참조하는 테이블 먼저 지우고, 참조 테이블을 지워야 함

delete member;  -- 참조하는 테이블 먼저 안지우고 얘부터 하면 에러 발생함

delete member_detail
where id = 'java2';     ---- 조건 설정해야 해당 로우만 삭제됨

delete member
where id = 'java2';     ----- delete all 없음ㅋㅋ 걍 순서대로 따로따로 삭제해야 함    ---- update나 delete의 경우 insert all 처럼 한번에 실행할 수 없기 때문에 batch(?) 이용함



-- merge
drop table product;

create table product
(
    pid number,     -------- number는 길이 기본값은 38(?) 자리임
    pname varchar2(10),
    cnt number,
    price number,
    constraint product_pid_pk primary key (pid)
);

insert into product (pid, pname, cnt, price)
values (100, '새우깡', 100, 1500);

insert into product (pid, pname, cnt, price)
values (200, '꼬북칩', 80, 2700);

insert into product (pid, pname, cnt, price)
values (300, '빼빼로', 120, 1000);



-- 상품코드가 400인 자갈치(1200원) 150개 입고    >> 기존에 없는 상품코드이므로 insert
merge into product
using dual
on (pid = 400)
when matched then
update set cnt = cnt + 150
when not matched then
insert (pid, pname, cnt, price)
values (400, '자갈치', 150, 1200);

-- 상품코드가 100인 새우깡(1500원) 50개 입고     >> 기존에 있는 상품코드이므로 update
merge into product
using dual
on (pid = 100)
when matched then
update set cnt = cnt + 50
when not matched then
insert (pid, pname, cnt, price)
values (100, '새우깡', 50, 1500);

commit;
----------------------------------------------------------------------------------------------------------------------------------


-- transaction : 작업단위

select *
from product;

update product
set cnt = 200
where pid = 100;

update product
set cnt = 800
where pid = 100;


commit;

rollback;   -- 최종 commit 다음시점까지 되돌림

--- savepoint
insert into product
values (101, '조개깡', 150, 1500);

insert into product
values (102, '문어깡', 250, 1500);

insert into product
values (103, '고래깡', 55, 1500);

savepoint a;

insert into product
values (104, '한우깡', 58, 1500);

insert into product
values (105, '돼지깡', 120, 1500);

savepoint b;

insert into product
values (106, '버섯깡', 120, 1500);

insert into product
values (107, '차돌깡', 220, 1500);



select *
from product;


rollback to b;



---- sequence       -- 일련번호나, 게시판 번호등을 만들 때 많이 사용하며, insert 구문에서 사용함. 아래 실습처럼 select에서 사용할 일은 없음
create sequence product_pid_seq
start with 1 increment by 1;

insert into product (pid, pname, cnt, price)
values (product_pid_seq.nextval, '이름', 10, 1000);


select product_pid_seq.nextval  --- 이거 실행하는 순간 번호가 매겨진것이라, 바로 다음에 위 insert 하면 다음 숫자가 입력되어버림
from dual;

select product_pid_seq.currval  -- 현재 시퀀스 값을 확인!
from dual;



select product_pid_seq.nextval, product_pid_seq.nextval     -- 한번의 쿼리 안에서 sequence의 증가는 한번 뿐임
from dual;

select product_pid_seq.nextval, product_pid_seq.nextval, product_pid_seq.currval
from dual;




delete product;

commit;


rollback; 



