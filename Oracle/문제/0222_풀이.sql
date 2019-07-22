-- [1��]

--1. �̸��� bruce�� ����� ���, �μ���ȣ, �޿��� �̾ƶ�. (������ �빮������ �ҹ��������� �𸥴�.)
select employee_id, department_id, salary
from employees
where lower(first_name) = 'bruce';

select employee_id, department_id, salary
from employees
where upper(first_name) = upper('bruce');

-- 2. �̸��� Steven�� ����� �ٹ��ϴ� �����̸��� ���ض�
select department_id, first_name
from employees
where first_name = 'Steven';

select location_id
from departments
where department_id = 90;

select city
from locations
where location_id = 1700;

-- 3. Ŀ�̼��� �޴� ����� 10000�� �Ѵ� ����� ��� �̸� �μ���ȣ, Ŀ�̼��� ������ �޿��� ã�ƶ�
select employee_id, first_name, department_id, salary*(1+commission_pct)
from employees
where commission_pct is not null and salary*(1+commission_pct) > 10000;

-- 4. �ٹ��μ��� null�� ����� ��� �̸� �μ���ȣ�� ã�ƶ�
select employee_id, first_name, department_id
from employees
where department_id is null;

-- 5. �ٹ� �μ��� Oxford�� ������ȣ ã�� (��ҹ��� ��� ã��) (��Ī: ���� ��ȣ)
select location_id
from locations
where lower(city) = lower('oXford');

-- 6. �ٹ����� ���� ���� ����ϱ� (�ߺ�����) (��Ī: ����)
select distinct job_id as "����"
from employees;

-- 7. ������ �ּұ޿��� �ִ� �޿��� ���̰� 2�� �̸����� ���̳��� �������̵�, �ּұ޿�, �ִ�޿�, �޿�����( ��Ī �޿����� )
select job_id, min_salary, max_salary, max_salary - min_salary �޿�����
from jobs
where 2 * min_salary > max_salary ;

-- 8. ������ programmer�� ����� Ǯ����(��Ī : �̸�), �޿�(��Ī : �޿�) 
select job_id, job_title
from jobs
where lower(job_title) like '%programmer%';

select first_name || ' ' || last_name �̸�, salary �޿�
from employees
where upper(job_id) = 'IT_PROG' ;

-- 9. Ŀ�̼��� �޴� ����� ��� , �̸�, �޿��� �޿��� �������� ������ �϶�.
select employee_id, first_name, salary
from employees
where commission_pct is not null
order by salary desc;

-- 10. ���, �̸�, Ŀ�̼��� ������ �޿��� �������� ������ �϶�.(Ŀ�̼��� ������ �޿��� ��Ī�� cms)
select employee_id, first_name, salary*(1+nvl(commission_pct, 0)) cms
from employees
order by salary desc;


-- 2��

-- 1. ������ �������� �ٷ����� �ټӳ���� ��Ÿ���� 25�������� ����߿� ������޷����� D�λ������ ��Ÿ���ÿ�. 
--  (���, �̸�, �����, �ټӳ��)
--  (��, ������ �Ű澲���ʴ´�.�������ϱ� ��)
select lowest_sal, highest_sal
from job_grades
where grade_level = 'D';

select employee_id ���, first_name �̸�, hire_date �����, to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy') �ټӳ��
from employees
where (to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy')) <= 25 and salary between 10000 and 14999;


-- * �ټӳ�� ���ϱ�
select to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy') �ټӳ��
from employees;


-- 2. last_name�� a�� ���� ����� ���, Ǯ����, �޿��� �޿��� ���� ������� ��Ÿ�����.
--   �̸��� �÷��� employee_name�� ǥ���Ѵ�.
--   (��, a�� ��ҹ��� �����Ѵ�.)
select employee_id, first_name || ' '|| last_name "employee_name", salary
from employees
where lower(last_name) like '%a%'
order by salary desc;

-- 3. �Ŵ��� ��ȣ�� 100 �̻� 200 �̸��̰�, �̱��� ��ġ�ϰ� �ִ� �μ��� �μ���ȣ, �μ��� (3�� ��µǸ� ����)
select location_id
from locations
where country_id = 'US';

select department_id, department_name, location_id, manager_id
from departments
where manager_id < 200 and location_id in (1400, 1500, 1700);

-- 4. �����ȣ�� 9�� ���� ������ ��ġ�� �μ����� ���ϸ�, �޿��� 7000 �̻��� ����� �̸�
-- �μ��� �̸������� ����
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

-- 5. �޿��� 3000�̻��̰� 50���̻� �μ��� �ٹ��ϸ� �̸��� r�� ���� ������� ����� �̸�, �޿��� �˻��϶�
select employee_id, first_name, salary
from employees
where salary >= 3000 and department_id >= 50 and lower(first_name) like '%r%';

-- 6. �������̵� AD�� �����ϴ� ���� �˻��ϰ� �ְ�޿����� ������������ �޿��� �����϶�
select salary
from employees
where job_id like 'AD%'
order by salary desc;

-- 7. �ٹ������� �̱��� ����� Ǯ���Ӱ� �ٹ����� ��¥�� ��� 'OOO�� OOO���� �̱����� ���Ѵ�.' �� ����϶�. 
--   ��Ī�� �뵿�� from USA�� ����(��������)
select location_id, country_id
from locations
where country_id = 'US';

select department_id
from departments
where location_id in (1400, 1500, 1700) ;

select first_name || ' ' || last_name || '�� ' || hire_date || '���� �̱����� ���Ѵ�.' "�뵿�� from USA"
from employees
where department_id in (60, 50, 10, 90, 110, 190) ;


-- 8. ���̳� �̸��� h�� �� ����� ���� ������ ��� ����ϵ� �޿��� ������� ������������ �����Ͽ���.
select salary, hire_date
from employees
where lower(first_name) like '%h%' or lower(last_name) like '%h%'
order by salary desc, hire_date desc;


-- 3��

-- 1. �Ŵ����� ���� �μ��� ������ ���� ã���ÿ�..
select department_name, manager_id
from departments
where manager_id is null;

-- 2. �������ް� �ְ������ ���̰� 3000�̻� ���� grade_level�� ã���ÿ�.
select grade_level, highest_sal - lowest_sal
from job_grades
where (highest_sal - lowest_sal) >= 3000;

-- 3. 4���̻� �ٹ��ϰ� ����� ����� ��ȣ�� JOB_ID ����Ͻÿ�.
select employee_id, job_id, (to_char(end_date, 'yyyy') - to_char(start_date, 'yyyy')) �ټӳ��
from job_history
where (to_char(end_date, 'yyyy') - to_char(start_date, 'yyyy')) >= 4;

-- 4. ������ ID�� 124���̸�, �޿��� 2500 �̻� 3500 �̸��� ����� (�̸�, �޿�, ������ ID)�� ����ϼ���.
-- ��, �޿��� ���� ������ ����
select first_name, salary, manager_id
from employees
where manager_id = 124 and salary >= 2500 and salary < 3500
order by salary desc;

-- 5. ������ ID�� 100�̰� �̸��� 2��°�� 'o'�� ����� (�̸�, Ŀ�̼�, Ŀ�̼� ���� �� �޿�)�� ����ϼ���.
-- *Ŀ�̼��� null�� ��� 0���� ��ü�Ͽ� ��� �� ���
-- ��, Ŀ�̼� ���� �� �޿��� ���� ������ ����
select last_name, salary*commission_pct, salary*(1+nvl(commission_pct, 0))
from employees
where manager_id = 100 and lower(last_name) like '_o%'
order by salary*(1+nvl(commission_pct, 0)) desc ;

-- 6. �����ڰ� �������� ���� ����� (�̸�)�� ����ϼ���. *�̸� ���� : [�� �̸�]
select last_name || ' ' || first_name
from employees
where manager_id is null;

-- 7. �ִ� �޿��� �ּ� �ӱ��� ���� 5000 �̻��� ������ (�̸�, �ִ� �޿�, �ּ� �޿�, �޿��� ����)�� ����ϼ���.
-- ��, �޿��� ���̰� ū ������ �����ϼ���.
select job_title, max_salary, min_salary, (max_salary - min_salary) as "�޿��� ����"
from jobs
where (max_salary - min_salary) >= 5000
order by (max_salary - min_salary) desc;

-- 8. ���� �ð�, 3�� ��, 3�ð� ��, 3�� ��, 3�� �ĸ� ����ϼ��� *������ ��Ī ����(���� �ð�, 3�� �� ~)
-- ��, ��� ������ '�⵵.��.�� ��:��:��'
select to_char(sysdate, 'yy.mm.dd hh:mi:ss') "���� �ð�",
       to_char(sysdate+3, 'yy.mm.dd hh:mi:ss') "3�� ��",
       to_char(sysdate+3/(24*60), 'yy.mm.dd hh:mi:ss') "3�� ��",
       to_char(sysdate+3/(24*60*60), 'yy.mm.dd hh:mi:ss') "3�� ��"
from dual;

-- 9. 90�� ������ ���� ������� �ִ� �޿�, �μ��̸�  
select department_id, job_id, hire_date ����
from employees
where to_char(hire_date, 'yyyy') <= 1990
order by hire_date asc;

select max_salary, job_id
from jobs
where lower(job_id) in ('ad_pres', 'ad_asst', 'ad_vp', 'it_prog');

select department_name, department_id
from departments
where department_id in (90, 10, 60) ;

-- 10. ��å�� President �� ����� ��볯¥, �̸� , �޿�
select job_id
from jobs
where job_title = 'President';

select hire_date, first_name, salary, job_id ����
from employees
where job_id = 'AD_PRES';

-- 11. �޿��� 5000�̻��̰� �Ŵ����� ������ ����� �̸��� ����Ͻÿ�
select first_name
from employees
where salary >= 5000 and manager_id is not null;

-- 12. �ִ� �޿��� �ּ� �޿��� 4000 ���Ϸ� ���̳��� job_title�� ã���ÿ�
select job_title
from jobs
where (max_salary - min_salary) <= 4000; 

-- 13. �Ŵ����� �������� ���� ����� '�̸���, ��ȭ��ȣ'�� �������� ����Ͻÿ�
select email || ', ' || phone_number
from employees
where manager_id is null;

-- 14. ������ �μ��� ��ġ�� ������ �����ȣ�� ã���ÿ�.
select location_id, department_name
from departments
where lower(department_name) = 'marketing';

select postal_code
from locations
where location_id = 1800;

-- 15. it�μ��� ��ġ�� ������ �ּҸ� ã���ÿ�.
select location_id, department_name
from departments
where upper(department_name) like '%IT%'; 

select street_address
from locations
where location_id = 1400;

-- 16. Steven King ������ ������ ���� �ִ� �ְ����� ã���ÿ�.
select job_id
from employees
where first_name = 'Steven' and last_name = 'King';

select max_salary
from jobs
where upper(job_id) = 'AD_PRES';

-- 17. ����1. last_name �� �տ��� �ι�°�� 'u'�� �� ����� Ŀ�̼��� ���Ե� �޿��� ����Ͻÿ�.
--     ����2. Ŀ�̼��� ���Ե� �޿��� ��Ī "�޿�"�� �Է��Ͻÿ�.
select salary*(1+nvl(commission_pct, 0)) �޿�
from employees
where lower(last_name) like '_u%';

-- 18. �μ���ȣ�� 50�̻�, �̸��� �ƴ� ������ ���� �ι�°�� 'o'�� �� ����� ��ü Ǯ���Ӱ� �޿��� ��Ÿ���ÿ�. 
--     ��Ī : �̸� /  �޿�
--     �޿� ������������ ���� �Ͻÿ�.
select first_name || ' ' || last_name �̸�, salary �޿�
from employees
where department_id >= 50 and lower(last_name) like '%o_'
order by salary desc;


-- 4��

-- 1. ������ IT�� ������� �̸�, �޿�, �ٹ����(�Ҽ��� ������ �����)
select first_name, salary, to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy') �ټӳ��, job_ID
from employees
where upper(job_id) like '%IT%';

-- 2. �ٹ����ð� 'Southlake'�� ����� ���, �̸�, �̸���, �޿��� �˻��ϰ� �ݷ��� ����
select location_id, city
from locations
where city = 'Southlake';

select department_id
from departments
where location_id = 1400;

select employee_id ���, first_name �̸�, email �̸���, salary �޿�
from employees
where department_id = 60;


-- 3. �Ի����� 91/01/02 �� 98/12/21 ������ ����� ������ ���.
--   (�����ȣ, Ǯ����, �Ի���, �޿�(Ŀ�̼��� �ִٸ� �����Ұ�), Ŀ�̼�(������ 0���� ǥ��) ���� ����Ұ�)
select employee_id �����ȣ, first_name || ' ' || last_name �̸�, hire_date �Ի���, salary*(1+nvl(commission_pct, 0)) �޿�
from employees
where hire_date between to_date('1991-01-02', 'yy/mm/dd') and to_date('1998-12-21', 'yy/mm/dd');

select employee_id �����ȣ, first_name || ' ' || last_name �̸�, hire_date �Ի���, salary*(1+nvl(commission_pct, 0)) �޿�
from employees
where to_char(hire_date, 'yyyy-mm-dd') between '1991-01-02' and '1998-12-21';

-- 4. ȸ��(president)�� ����� �˾Ƴ��� ȸ���� ���������� ä����������.
-- ��� : 
-- Ǯ���� : 
-- �Ի��� : 
-- Ŀ�̼����Ե� �޿� : 
-- �ҼӺμ��� : 
-- �μ��� ���� �ּ� : 
select job_id
from jobs
where lower(job_title) = 'president';

select employee_id ���, first_name || ' ' || last_name Ǯ����, hire_date �Ի���,
        salary*(1+nvl(commission_pct, 0)) "Ŀ�̼����Ե� �޿�", department_id 
from employees
where job_ID = 'AD_PRES';

select location_id
from departments
where department_id = 90;

select country_id, state_province, street_address, postal_code
from locations
where location_id = 1700;


--5. �μ��� ShiPping �� ���ϸ鼭 �޿�(salary)��  2000 ~ 4000 ���̸鼭 
--          firstName�� t �� ���� ����̸鼭 
--          �Ի���(hire_date)�� 97/01/01 ~ 98/12/30 �� ���Ե��� �ʴ� ����� ����� Ǯ������?
-- ��� : 
-- �̸� : 
select department_id
from departments
where lower(department_name) = lower('ShiPping') ;

select employee_id ���, first_name || ' ' || last_name �̸�
from employees
where department_id = 50 and (salary between 2000 and 4000) and (lower(first_name) like '%t%') and
       to_char(hire_date, 'yyyy/mm/dd') not between '1997/01/01' and '1998/12/30';


-- 6. 7000~9000 ������ �޿��� ���� �� �ִ� ���� �̸� �߿��� 'Manager'�� �����ϴ� ���� �̸�, �ּ� �޿�, �ִ� �޿� (�ּ� �޿��� ������������ ����)
select job_title, min_salary, max_salary
from jobs
where min_salary < 9000 and max_salary >7000 and lower(job_title) like lower('%Manager%') 
order by min_salary;

-- 7. ������ ��ȣ�� �ο����� ���� �μ��� �μ���ȣ
select department_id
from departments
where manager_id is null;

-- 8. ���ڸ� �μ� ��ȣ�� ���� ����� �޿� (�޿��� ���� ������� ����)
select salary
from employees
where department_id like '___'
order by salary desc;

-- 9. 1990�� ���Ŀ� ���� ����� �̸�, �̸���, ��� ���� (���� �Ի��� ������� ����)
select first_name, email, hire_date
from employees
where to_char(hire_date, 'yyyy') >= 1990
order by hire_date;

-- 10. Ŀ�̼�, ���� ��ȣ, �μ� ��ȣ�� �ϳ��� �� �� ���� ����� �̸�, ��ȭ��ȣ (��ȭ��ȣ�� ��������)
select first_name, phone_number
from employees
where commission_pct is null or manager_id is null or department_id is null
order by phone_number;

-- 11. ���� �� ���� ����� �ٸ� �ϳ���? (��, �� ���� �̸��� �����Ѵ�.) 
--    (�ڵ� ���� ���� ���� employees ���̺��� ���鼭 �Ӹ� ������ ������ �غ��� ���� ������.)
--    (���� : employees ���̺��� �⺻������ employee_id �� ���ĵǾ� �ִ�. �׸��� employee_id �� ������ ���̴�.)  
            
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
