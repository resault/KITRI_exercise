select* from tab;


purge recyclebin;   -- ������ ����



-- subquery�� �̿��� insert
select *
from emp_blank;

insert into emp_blank
select *
from employees
where department_id = 80;   --- value �ڸ��� query ������ ���� ������..?? << Ȯ��



-- ����
-- 1. 100�� ����� ���, �̸�, ��å, �μ���ȣ
-- emp_blank ����
insert into emp_blank (employee_id, first_name, last_name, email, hire_date, job_id, department_id)
select employee_id, first_name, last_name, email, hire_date, job_id, department_id
from employees
where employee_id = 100;


-- update               ---- update all ����!!
-- 'java2'�� ����� 9876���� ����
update member
set pass = 9876
where id = 'java2'; 


-- 'java2'�� ����� 1234��, ���̸� 25�� ����
update member
set pass = 1234, age = 25       -- ���� �÷��� �ѹ��� ������ ���� , �� ����
where id = 'java2';



-- 'java2'�� ����� 5678, ���̸� ���̵� oracle�� ����� ���� ����
update member
set pass = 5678, age = (select age from member where id = 'oracle')     -- update�� subquery    
where id = 'java2';


-- �ּҿ� '����'�� ���� ȸ������ ��й�ȣ�� 87654321 �� ����
update member
set pass = 87654321
where id in (select id from member_detail where address = '%����%');  --  update�� where���� subquery



-- ��?? id �ȹٲ�ٰ� �ߴµ� ��;; �̰� detail�� �� ���� �׷���? >> ���� ���� 
-- (���� �̰� �ǽ��Ҷ� detail�� ������ �Է� ���Ԥ��� �ٸ�������� ���� ��ũ��Ʈ �߿��� insert all ���� �����ͼ� member�� member_detail ��ο� ������ �Է���)
-----------  >> primary key �� ���� ����(�� update�� �����ϴ°� ������� ����) �ٸ� �ٸ� ���̺��� �ش� Ű�� ������ ���� ���� �Ұ�! (���� ���̺��� ���� ���Ἲ�� �����)

update member
set id = 'abc'
where id = '������';



-- DELETE [FROM] table_name
-- �����ϴ� ���̺� ���� �����, ���� ���̺��� ������ ��

delete member;  -- �����ϴ� ���̺� ���� ������� ����� �ϸ� ���� �߻���

delete member_detail
where id = 'java2';     ---- ���� �����ؾ� �ش� �ο츸 ������

delete member
where id = 'java2';     ----- delete all �������� �� ������� ���ε��� �����ؾ� ��    ---- update�� delete�� ��� insert all ó�� �ѹ��� ������ �� ���� ������ batch(?) �̿���



-- merge
drop table product;

create table product
(
    pid number,     -------- number�� ���� �⺻���� 38(?) �ڸ���
    pname varchar2(10),
    cnt number,
    price number,
    constraint product_pid_pk primary key (pid)
);

insert into product (pid, pname, cnt, price)
values (100, '�����', 100, 1500);

insert into product (pid, pname, cnt, price)
values (200, '����Ĩ', 80, 2700);

insert into product (pid, pname, cnt, price)
values (300, '������', 120, 1000);



-- ��ǰ�ڵ尡 400�� �ڰ�ġ(1200��) 150�� �԰�    >> ������ ���� ��ǰ�ڵ��̹Ƿ� insert
merge into product
using dual
on (pid = 400)
when matched then
update set cnt = cnt + 150
when not matched then
insert (pid, pname, cnt, price)
values (400, '�ڰ�ġ', 150, 1200);

-- ��ǰ�ڵ尡 100�� �����(1500��) 50�� �԰�     >> ������ �ִ� ��ǰ�ڵ��̹Ƿ� update
merge into product
using dual
on (pid = 100)
when matched then
update set cnt = cnt + 50
when not matched then
insert (pid, pname, cnt, price)
values (100, '�����', 50, 1500);

commit;
----------------------------------------------------------------------------------------------------------------------------------


-- transaction : �۾�����

select *
from product;

update product
set cnt = 200
where pid = 100;

update product
set cnt = 800
where pid = 100;


commit;

rollback;   -- ���� commit ������������ �ǵ���

--- savepoint
insert into product
values (101, '������', 150, 1500);

insert into product
values (102, '�����', 250, 1500);

insert into product
values (103, '����', 55, 1500);

savepoint a;

insert into product
values (104, '�ѿ��', 58, 1500);

insert into product
values (105, '������', 120, 1500);

savepoint b;

insert into product
values (106, '������', 120, 1500);

insert into product
values (107, '������', 220, 1500);



select *
from product;


rollback to b;



---- sequence       -- �Ϸù�ȣ��, �Խ��� ��ȣ���� ���� �� ���� ����ϸ�, insert �������� �����. �Ʒ� �ǽ�ó�� select���� ����� ���� ����
create sequence product_pid_seq
start with 1 increment by 1;

insert into product (pid, pname, cnt, price)
values (product_pid_seq.nextval, '�̸�', 10, 1000);


select product_pid_seq.nextval  --- �̰� �����ϴ� ���� ��ȣ�� �Ű������̶�, �ٷ� ������ �� insert �ϸ� ���� ���ڰ� �ԷµǾ����
from dual;

select product_pid_seq.currval  -- ���� ������ ���� Ȯ��!
from dual;



select product_pid_seq.nextval, product_pid_seq.nextval     -- �ѹ��� ���� �ȿ��� sequence�� ������ �ѹ� ����
from dual;

select product_pid_seq.nextval, product_pid_seq.nextval, product_pid_seq.currval
from dual;




delete product;

commit;


rollback; 



