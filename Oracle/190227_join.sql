-- non equi join
-- ��� ����� ���, �̸�, �޿�, �޿����
select e.employee_id, e.first_name, e.salary, g.grade_level
from employees e, job_grades g
where e.salary between g.lowest_sal and g.highest_sal 
order by e.salary desc;


-- outter join
-- ��� ����� ���, �̸�, �μ���ȣ, �μ��̸�
-- ��, �μ��� �������� ��� �μ��̸��� '���߷���'���� ���
select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '���߷���')
from employees e, departments d
where e.department_id = d.department_id(+);


select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '���߷���')
from employees e, departments d
where e.department_id(+) = d.department_id; --- �� �ڵ�� ����� �ٸ�!


-- ��� ����� ���, �̸�, ������, ����̸�
-- ��, ����� ���� ��� ����̸��� '����'���� ���
select e.employee_id, e.first_name, e.manager_ID, nvl(m.first_name, '����')
from employees e, employees m
where e.manager_id = m.employee_id(+);


-- ��� ����� ���, �̸�, ������, ����̸�, �μ��̸�
-- ��, ����� ���� ��� ����̸��� '����'���� ���
-- ��, �μ��� �������� ��� �μ��̸��� '���߷���'���� ��� 
select e.employee_id ���, e.first_name �̸�, e.manager_id ������,
        nvl(m.first_name, '����') ����̸�,
        nvl(d.department_name, '���߷���') �μ��̸�
from employees e, employees m, departments d
where e.manager_id = m.employee_id(+)
        and e.department_id = d.department_id(+);

-- ����üũ
select e.employee_id ���, e.first_name �̸�, e.manager_id ������,
        nvl(m.first_name, '����') ����̸�,
        nvl(d.department_name, '���߷���') �μ��̸�
from employees e, employees m, departments d
where e.manager_id = m.employee_id(+)
        and m.department_id = d.department_id(+); -- m�� department_id�� �������� manager�� �μ����� ���͹���


-- ANSI Join
-- Cross Join
select *
from employees, departments;  -- oracle join (katesian join)

select *
from employees cross join departments; --- ansi join (cross join)


-- Inner Join
-- 50�� �μ��� ���, �̸�, �μ��̸�
select e.employee_id, e.first_name, d.department_name
from employees e, departments d     -- oracle join (equi joini)
where e.department_id = d.department_id
        and e.department_id = 50;


select e.employee_id, e.first_name, d.department_name
from employees e join departments d       -- ansi join (inner join)
on e.department_id = d.department_id
where e.department_id = 50;     -- on�� �ȿ��� and�� �ٿ��� �Ǳ� �ϳ� ����X (cross ���� ����� �ȿ��� �߰��� ���� �˻��� �ϹǷ� ��ȿ������)


-- using �� �̿�
select e.employee_id, e.first_name, d.department_name
from employees e join departments d      -- inner ���� ����
using (department_id)
where e.department_id = 50; -- using���� �̿��ϴ� �÷��� ���̺� �����ϸ� ���� �߻���


select e.employee_id, e.first_name, d.department_name
from employees e join departments d      -- inner ���� ����
using (department_id)       -- using�� �̿�
where department_id = 50;


-- natural join
select e.employee_id, e.first_name, d.department_name
from employees e natural join departments d 
where department_id = 50;


-- join�� table �߰�
-- 'seattle'�� �ٹ��ϴ� ���, �̸�, �μ��̸�, ����
select e.employee_id, e.first_name, d.department_name, l.city
from employees e, departments d, locations l    -- oracle join
where e.department_id = d.department_id
            and d.location_id = l.location_id
        and lower(l.city) = lower('seattle');


select e.employee_id, e.first_name, d.department_name, l.city
from employees e join departments d     -- ansi join
                    on e.department_id = d.department_id
                        join locations l
                            on d.location_id = l.location_id
where lower(l.city) = lower('seattle');

-- outter join Ȯ��
-- ��� ����� ���, �̸�, �μ���ȣ, �μ��̸�
-- �μ��� �������� ��� �μ��̸��� '���߷���'
select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '���߷���')
from employees e, departments d
where e.department_id = d.department_id(+);


select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '���߷���') -- nvl�� oracle �Լ���
from employees e left outer join departments d
on e.department_id = d.department_id;



-- ��� �μ��� �ٹ��ϴ� ����� ���, �̸�(�������), �μ���ȣ, �μ��̸�
select e.employee_id, nvl(e.first_name, '�������'), d.department_id, d.department_name 
from departments d, employees e     -- oracle join
where d.department_id = e.department_id(+);



select e.employee_id, nvl(e.first_name, '�������'), d.department_id, d.department_name 
from employees e right outer join departments d 
on d.department_id = e.department_id(+);



-- ��� �μ��� �ٹ��ϴ� ��� ����� ���, �̸�(�������), �μ���ȣ, �μ��̸�
select e.employee_id, nvl(e.first_name, '�������'),
        d.department_id, nvl(d.department_name ,'���߷�')
from departments d, employees e     -- oracle join
where d.department_id(+) = e.department_id(+); -- ���� �߻�


select e.employee_id, nvl(e.first_name, '�������'),
        d.department_id, nvl(d.department_name ,'���߷�')
from departments d full outer join employees e
on d.department_id = e.department_id;
