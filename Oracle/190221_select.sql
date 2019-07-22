-- ��� ����� ��� ����
select *
from employees;

-- ����� ���, �̸�, �޿�
select employee_id, first_name, salary
from employees;

-- �μ��� �μ���ȣ, �μ��̸�
select department_id, department_name
from departments;

-- �μ���ȣ (employees ����)
select distinct department_id, employee_id
from employees;




select 1+1, 10-5, 2*10, 10/3
from dual;

-- ���, �̸�, �޿�, 200�λ� �޿�(�޿�200)
select employee_id as "���", first_name "�̸�", salary �޿�, salary+200 "�޿� 200"
from employees;

-- ���, �̸�, �޿�, Ŀ�̼� ���� �޿�
select employee_id as "���", first_name as �̸�, salary �޿�,
        nvl(commission_pct,0) Ŀ�̼�, salary*(1+nvl(commission_pct,0)) "Ŀ�̼� ����"
from employees;


-- ���, �̸�(Ǯ����)
select employee_Id, first_name || ' ' || last_name name
from employees;

-- ����� 100���� ����� �̸��� Steven King�Դϴ�.(info)
select '����� ' || employee_id || '�� ����� �̸��� ' || first_name || ' ' || last_name || '�Դϴ�.' info
from employees;

select *
from employees;

-- ����1 : ���(���), �Ի���(�Ի���), Ŀ�̼� ���� �޿�(�޿�_Ŀ�̼� ����)
select employee_id ���, hire_date �Ի���, salary*(1+nvl(commission_pct,0)) "�޿�_Ŀ�̼� ����"
from employees;

-- ����2 : "President"�� �ִ� �޿��� 40000�Դϴ�.    ���·� ���. �÷��̸��� ���
select '"' || job_title || '"�� �ִ� �޿��� ' || max_salary || '�Դϴ�.'
from jobs;