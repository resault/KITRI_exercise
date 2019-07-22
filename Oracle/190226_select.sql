-- decode

-- ���, �̸�, �μ���ȣ, ��������
-- ��������
-- �μ���ȣ 60 ������
--          90 �ӿ���
--          ������ �񰳹���
select employee_id ���, first_name �̸�, department_id �μ���ȣ,
        case
            when department_id = 60
            then '������'
            when department_id = 90
            then '�ӿ���'
            else '�񰳹���'
        end ��������
from employees
order by ��������, �μ���ȣ;

select employee_id ���, first_name �̸�, department_id �μ���ȣ,
        decode(department_id,
                60, '������',
                90, '�ӿ���',
                '�񰳹���') ��������
from employees
order by ��������, �μ���ȣ;



-- �׷��Լ�
-- ȸ���� �ѻ����, �޿�����, �޿����, �ְ�޿�, �����޿�
select count(employee_id), sum(salary), avg(salary), max(salary), min(salary)
from employees;

-- ��ձ޿����� ���� �޴� ����� ���, �̸�, �޿�
select employee_id, first_name, salary
from employees
where salary > avg(salary);


-- [Join]

-- ���, �̸�, �μ���ȣ, �μ��̸�
select employee_id, first_name, department_id, department_name -- �μ��̸��� ���� ���̺� ���� �÷���
from employees;

select department_id, department_name
from departments;

-- cartesian join (cross join)
--  >> ���̺� �ΰ��� ��ȯ�ϰ� �Ϸ��� from ���� ���̺� �ΰ� �Է�??
select *
from employees, departments -- >> ���� ���̺�� �μ� ���̺��� 1:1 ���εǾ����. (īŸ�þ� ���δ�Ʈ)
order by employee_id; 

-- equi join (natural join)
-- >> Join ���
select employees.employee_id, employees.first_name, employees.department_id, departments.department_name
-- �μ����̺��� �μ���ȣ�� �����͵� ��. �������� ���̺�ǥ�ø� ���ص� ������, �������� ���� ���� ǥ����
from employees, departments
where employees.department_id = departments.department_id -- �μ���ȣ�� ���� Ŵ������ ������. null���� equal �񱳵� �Ұ�
order by employee_id;

select a.employee_id, a.first_name, a.department_id, b.department_name
from employees a, departments b -- ���̺� alias ����
where a.department_id = b.department_id
order by employee_id;

-- 'seattle'�� �ٹ��ϴ� ����� ���, �̸�, �μ��̸�, �����̸�
select a.employee_id, a.first_name, b. department_name, c.city
from employees a, departments b, locations c
where a.department_id = b.department_id and b.location_id = c.location_id and
        lower(c.city) = lower('seattle');
        
        
-- 'asia'�� �ٹ��ϴ� ���, �̸�, �μ��̸�, �����̸�
select e.employee_id, e.first_name, d.department_id, l.city
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id
            and d.location_id = l.location_id
            and l.country_id = c.country_id
            and c.region_id = r.region_id
        and lower(r.region_name) = lower('europe');


-- 10, 80, 90�� �μ��� �ٹ����� �����
-- ���, �̸�, ��å�̸�, �μ��̸�
select e.employee_id, e.first_name, j.job_title, d.department_name
from employees e, jobs j, departments d
where e.job_id = j.job_id
            and e.department_id = d.department_id
        and e.department_id in (10, 80, 90);



-- ����� 200�� ����� �ٹ� �̷�
-- ���, �̸�, ��å�̸�, �μ��̸�, �ٹ�������(�Ҽ��� ��°�ڸ�����)
select e.employee_id ���, e.first_name �̸�, j.job_title ��å�̸�, d.department_name �μ��̸�,
        round(months_between(h.end_date, h.start_date), 2) �ٹ������� -- round���ٴ� to_char�� ���� �����
from employees e, job_history h, jobs j, departments d
where e.employee_id = h.employee_id
            and h.job_id = j.job_id
            and h.department_id = d.department_id
        and h.employee_id = 200;

select e.employee_id ���, e.first_name �̸�, j.job_title ��å�̸�, d.department_name �μ��̸�,
        to_char(months_between(h.end_date, h.start_date), '999.99') �ٹ������� -- to_char ����ϸ� �Ҽ��� �� �ڸ��� 0���� ǥ����
from employees e, job_history h, jobs j, departments d
where e.employee_id = h.employee_id
            and h.job_id = j.job_id
            and h.department_id = d.department_id
        and h.employee_id = 200;

-- @@ �� �������ٰ� ���� ��å�̸��� �μ��̸��� row�� �߰��� �� �ֳ�?
select e.employee_id ���, e.first_name �̸�, j.job_title ��å�̸�, d.department_name �μ��̸�,
        to_char(months_between(h.end_date, h.start_date), '999.99') �ٹ�������,
        ej.job_title ����å, ed.department_name ���μ� -- �̷��� �ϸ� �÷��� �߰��Ǿ� ����. ������?? �װ� ����� �� �� �ִµ�
from employees e, job_history h, jobs j, departments d, jobs ej, departments ed
where e.employee_id = h.employee_id
            and h.job_id = j.job_id
            and h.department_id = d.department_id
            and e.job_id = ej.job_id
            and e.department_id = ed.department_id
        and h.employee_id = 200;


-- self join
-- ��� ����� �μ��̸�, ���, �̸�, �Ŵ������(���ӻ��), �Ŵ����̸�
select d.department_name �μ��̸�, e.employee_id ���, e.first_name �̸�,
        e.manager_id "���ӻ�� ���", em.first_name "���ӻ�� �̸�"
from employees e, departments d, employees em
where e.department_id = d.department_id
        and e.manager_id = em.employee_id;



---- �̰� 2/27 ����
-- ��å ���̵� 'SA_REP'�� �����
-- ���, �̸�, ��å�̸�, �μ��̸�
-- ��, �μ��� ���� ��� '���߷�'���� ���
select e.employee_id, e.first_name, j.job_title,
        case 
            when e.department_id is not null
            then d.department_name
            else '���߷�'
        end �μ��̸�
from employees e, jobs j, departments d
where e.job_id = j.job_id
            and e.department_id = d.department_id -- ���⼭ Ŵ���� ������
        and lower(e.job_id) = lower('SA_REP');
