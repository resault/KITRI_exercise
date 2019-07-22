-- �޿��� 5000�̻� �޴� ����� ���, �̸�, �޿�, �μ���ȣ
select employee_id, first_name, salary, department_id
from employees
where salary >= 5000;

-- ����� 100���� ����� ���, �̸�, �μ���ȣ
select employee_id, first_name, department_id
from employees
where employee_id = 100;

-- �ٹ����ð� seattle�� ������ ������ȣ, �����ȣ, ����
select location_id, postal_code, city
from locations
where city = 'Seattle';

-- �޿��� 5000�̻� 12000�̸� �޴� ����� ���, �̸�, �޿�, �μ���ȣ
select employee_id, first_name, salary, department_id
from employees
where salary >= 5000 and salary < 12000;

-- �μ���ȣ�� 50�� ��� �� �޿��� 5000�̻� �޴� ����� ���, �̸�, �޿�, �μ���ȣ
select employee_id, first_name, salary, department_id
from employees
where department_id = 50 and salary >= 5000;

-- �޿��� 5000�̻� 12000���� �޴� ����� ���, �̸�, �޿�, �μ���ȣ
select employee_id, first_name, salary, department_id
from employees
where salary >= 5000 and salary <= 12000;

select employee_id, first_name, salary, department_id
from employees
where salary between 5000 and 12000;

-- Ŀ�̼��� �޴� ����� ���, �̸�, �޿�, Ŀ�̼����Ա޿�
select employee_id, first_name, salary, commission_pct, salary*(1+commission_pct)
from employees
where commission_pct > 0;

select employee_id, first_name, salary, salary*(1+commission_pct), commission_pct
from employees
where commission_pct is not null;

-- �ٹ��μ��� 50, 60, 80�� ����� ���, �̸�, �μ���ȣ
select employee_id, first_name, department_id
from employees
where department_id = 50 or department_id = 60 or department_id = 80;

-- �ٹ��μ��� 50, 60, 80�� �ƴ� ����� ���, �̸�, �μ���ȣ
select employee_id, first_name, department_id 
from employees
where department_id != 50 and department_id != 60 and department_id != 80 or department_id is null ;

-- �ٹ��μ��� 50, 60, 80�� ����� ���, �̸�, �μ���ȣ
select employee_id, first_name, department_id
from employees
where department_id in (50, 60, 80);

-- �ٹ��μ��� 50, 60, 80�� �ƴ� ����� ���, �̸�, �μ���ȣ
select employee_id, first_name, department_id 
from employees
where department_id not in (50, 60, 80);

-- �޿��� 3000 �̻��̰ų�, 8000 �̻��̰ų�, 5000 �̻��� ����� ���, �̸�, �޿�
select employee_id, first_name, salary
from employees
where salary >= 3000 or salary >= 8000 or salary >= 5000;

-- �޿��� 3000 �̻��̰ų�, 8000 �̻��̰ų�, 5000 �̻��� ����� ���, �̸�, �޿�
select employee_id, first_name, salary
from employees
where salary >= any (3000, 8000, 5000);

-- �޿��� 3000 �̻��̰� 8000 �̻��̰�, 5000 �̻��� ����� ���, �̸�, �޿�
select employee_id, first_name, salary
from employees
where salary >= 3000 and salary >= 8000 and salary >= 5000;

-- �޿��� 3000 �̻��̰� 8000 �̻��̰�, 5000 �̻��� ����� ���, �̸�, �޿�
select employee_id, first_name, salary
from employees
where salary >= all (3000, 8000, 5000);

-- ���� �ð�, 3�� ��, 3�ð� ��
select sysdate, to_char(sysdate, 'yy.mm.dd hh24:mi:ss') "���� �ð�",
        to_char(sysdate + 3, 'yy.mm.dd hh24:mi:ss') "3����", 
        to_char(sysdate + 3/24, 'yy.mm.dd hh24:mi:ss') "3�ð� ��",
        to_char(sysdate - 3, 'yy.mm.dd hh24:mi:ss') "3����",
        to_char(sysdate - 3/1440, 'yy.mm.dd hh24:mi:ss') "3�� ��"
from dual;

-- �̸��� Steven�� ����� ���, �̸�
select employee_id, first_name
from employees
where first_name = 'Steven';

-- �̸��� 'S'�� �����ϴ� ����� ���, �̸�
select employee_id, first_name
from employees
where first_name like 'S%';

-- �̸��� 'e'�� �����ϰ� �ִ� ����� ���, �̸�
select employee_id, first_name
from employees
where first_name like '%e%';

-- �̸��� 'y'�� ������ ����� ���, �̸�
select employee_id, first_name
from employees
where first_name like '%y';

-- �̸��� ������ ����°�� 'e'�� ����� ���, �̸�
select employee_id, first_name
from employees
where first_name like '%e__';

-- �μ���ȣ�� 50�� �ƴ� ����� ���, �̸�, �μ���ȣ
select employee_id, first_name, department_id
from employees
where department_id != 50;

select employee_id, first_name, department_id
from employees
where department_id ^= 50;

select employee_id, first_name, department_id
from employees
where department_id <> 50;

-- ��� ����� ���, �̸�, �޿�
-- ��, �޿��� ����
select employee_id, first_name, salary
from employees
order by salary desc;

-- �μ���ȣ, ���, �̸�, �޿�
-- �μ��� �޿������� ����
select department_id, employee_id, first_name, salary
from employees
order by department_id, salary desc;

select department_id did, employee_id, first_name, salary sal
from employees
order by did, sal desc;

-- �ٹ����ð� 'Seattle'�� ����� ���, �̸�, �μ���ȣ
select city, location_id
from locations
where city = 'Seattle';

select location_id, department_id
from departments
where location_id = 1700;

select employee_id, first_name, department_id
from employees
where department_id in (10, 90, 110, 190);

