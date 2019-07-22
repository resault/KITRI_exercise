
-- [JOIN �� SUBQUERY]

-- 2. SubQuery

-- �μ��̸��� 'IT'�� �ٹ��ϴ� ����� ���, �̸�, �޿�
select e.employee_id, e.first_name, e.salary
from departments d, employees e
where d.department_id = e.department_id -- catesian product���� ������ �˻��ϹǷ�, ȿ���� ������
        and lower(d.department_name) like lower('it');


-- >> employees ���̺����� �˻��Ϸ���?
select department_id
from departments
where department_name = 'IT';

select employee_id, first_name, salary
from employees
where department_id = 60; -- IT �μ��� �μ���ȣ


-- >> ���� ������ �ϳ��� ��ġ����?
select employee_id, first_name, salary
from employees
where department_id = select department_id
                        from departments
                        where department_name = 'IT'; -- ���� ���;� �� �ڸ��� select���� ���ͼ� ���� �߻�

-- >> ��ȣ�� ������ ���� �����Ű�� >> subquery �ϼ�!
select employee_id, first_name, salary
from employees
where department_id = (select department_id
                        from departments
                        where department_name = 'IT');


-- 1) subquery ��  subquery/join ��ø���

-- 'Seattle'�� �ٹ��ϴ� ����� ���, �̸�, �޿�

-- �ϴ� ���������� Ǯ���
select employee_id, first_name, salary
from employees
where department_id in();

select department_id
from departments
where location_id = 1700;
                                                
select location_id
from locations
where lower(city) = lower('Seattle');

-- >> subquery�� ��ġ��!! ----------------------------------------------------------------- ?? �ٵ� �� ����, join���ε� ����?
select employee_id, first_name, salary
from employees
where department_id in (select department_id
                        from departments
                        where location_id = (select location_id
                                                from locations
                                                where lower(city) = lower('Seattle')));


-------- ?? Ȯ���غ��� select�� subquery ����?? ----------- ����! ��, where���� �ٸ� ���̺��� ��ȸ�� �ʿ䰡 ���� ��쿡����
                                                ----------- ������ �Ʒ� ����

select employee_id, department_id, (select department_name
                                     from departments d
                                     where e.department_id = d.department_id )
from employees e
order by department_id;

-----------------------------------------------------------------------



-- inline view : ������ ���̺�. from������ subquery ���           * create view (�ӽ÷� ����� ���̺�) ���� �ٸ�
-- ������ȣ�� 1700�� �μ����� ���ϴ� �����
-- ���, �̸�, �μ���ȣ, �μ��̸�
-- >> join���� Ǯ���
select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id
        and d.location_id = 1700;   --- ���� �õ��غ� ��ó�� select���� subquery �־ �ذ��Ϸ��� �ϸ�, 
                                     --- ��������� from > where > select ���̱⿡, where �������� subquery�� ����ؼ� �� ����.

-------------�� ������ ������� Ȯ�� : catesian product 160�ǿ��� join ���� 19�� ���� �ű⼭ �Ϲ����� 6�� ����


-- >>> ȿ���� ��������
select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e, (select department_id, department_name
                    from departments
                    where location_id = 1700) d
where e.department_id = d.department_id;

------------->> ������� : ������ ���̺� (location_id 1700�� ���̺�)�� employees ���̺��� catessian product 80�ǿ���, join ������ �����ϴ� 6�� ����

-------------- * �ٵ�, ���� ����ϴ� ȿ������ �ӵ��� �����ϴ� �� �ƴ�. �̷������� ���������� ȿ�����̶�� ����, �ӵ��� ������ �����ȹ(?)�� ����������








---- ���� ����


-- 'Kevin'���� �޿��� ���� �޴� ����� ���, �̸�, �޿�

-- Ǯ�
select employee_id, first_name, salary
from employees
where salary > ();

select salary
from employees
where lower(first_name) = lower('Kevin');

-- ��ġ��
select employee_id, first_name, salary
from employees
where salary > (select salary
                 from employees
                 where lower(first_name) = lower('Kevin'));



-- 50�� �μ��� �ִ� ����麸�� �޿��� ���� �޴� ����� ���, �̸�, �޿�

-- Ǯ�
select employee_id, first_name, salary
from employees
where salary > ();

select max(salary)
from employees
where department_id = 50
order by salary desc;

-- ��ġ��
select employee_id, first_name, salary
from employees
where salary > (select max(salary)
                 from employees
                 where department_id = 50);


------ ��Ģ���� ����! max �Լ��� �ƴ϶�, �������� all ���!!  (50�� �μ��� �޿��� �������̹Ƿ�)-------???? ���� Ȯ��!!!!
select employee_id, first_name, salary
from employees
where salary > all ();

select salary
from employees
where department_id = 50
order by salary desc;

-- >>>> ��ġ��
select employee_id, first_name, salary
from employees
where salary > all (select salary
                     from employees
                     where department_id = 50);



-- �μ��� �ٹ��ϴ� ��� ������� ��� �޿����� ���� �޴� ����� ���, �̸�, �޿�

-- Ǯ�
select employee_id, first_name, salary
from employees
where salary > (); 

select salary
from employees
where department_id is not null -- Ŵ������ ������ 19��!
order by salary;


select round(avg(salary))
from employees
where department_id is not null
order by salary;


-- ��ġ��
select employee_id, first_name, salary
from employees
where salary > (select round(avg(salary))
                 from employees
                 where department_id is not null);





---------------------------------------------------------------- * ��ȣ���� ���� ����Ȯ�� (�̰� �׳� �����)



-- �μ���ȣ�� 20���� ��� �޿����� ũ��,----------------------------- �� ���� �ѹ� �ٽ� Ǯ� ��
-- �Ŵ����� ������� �μ� ��ȣ�� 20�� �ƴ� �����
-- ���, �̸�, �޿�, �μ���ȣ

select e.employee_id, e.first_name, e.salary, e.department_id
from (select distinct manager_id
      from employees
      where manager_id is not null) m, employees e
where m.manager_id = e.employee_id
        and salary > (select avg(salary)
                      from employees
                      where department_id = 20)
        and e.department_id <>20
order by m.manager_id;


select distinct m.employee_id, m.first_name, m.salary, m.department_id
from employees e, (select *            
                   from employees
                   where salary > (select avg(salary)
                                   from employees
                                   where department_id = 20
                                   )
                   ) m
where e.manager_id = m.employee_id
        and m.department_id <> 20
order by m.employee_id;




-- �μ���ȣ�� 20���� ��� �޿����� ũ��,
-- �μ����� ������� �μ� ��ȣ�� 20�� �ƴ� �����
-- ���, �̸�, �޿�, �μ���ȣ------------------------�̰� �� 3�� ���;� ��


select manager_id
from departments;

select e.employee_id, e.first_name, e.salary, e.department_id
from employees e, (select employee_id
                    from employees
                    where salary > (select avg(salary) 
                                     from employees
                                     where department_id = 20)) s
where e.employee_id = s.employee_id
        and e.employee_id in (select manager_id
                              from departments)
        and e.department_id <> 20;


-------- �� ���� �̷��� Ǯ� ���� ������, �ǹ̻� �³�?
select employee_id, first_name, salary, department_id
from employees
where salary > (select avg(salary)
                 from employees
                 where department_id = 20)
        and employee_id in (select manager_id
                             from departments)
        and department_id <> 20;
        





-- select ���� subquery

-- 20�� �μ��� ��ձ޿�
-- 50�� �μ��� �޿�����
-- 80�� �μ��� �ο���

-- Ǯ�
select avg(salary) from employees where department_id = 20;
select sum(salary) from employees where department_id = 50;
select count(employee_id) from employees where department_id = 80;

-- ��ġ��
select
    (select avg(salary) from employees where department_id = 20) avg20,------------ ������, �����÷��� ��밡��!
    (select sum(salary) from employees where department_id = 50) sum50,
    (select count(employee_id) from employees where department_id = 80) count80
from dual;


        
        
------ ���빮��
-- ��� ����� ���, �̸�, �޿�, ���, �μ��̸�
-- ��, A�� 1���, B�� 2���... F�� 6������� ǥ��
-- ��, job_grades�� join���� �ʴ´�
select e.employee_id ���, e.first_name �̸�, e.salary �޿�,
        decode( (select grade_level from job_grades where e.salary between lowest_sal and highest_sal),
                'A','1���',
                'B','2���',
                'C','3���',
                'D','4���',
                'E','5���',
                '6���') ���,
        d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);


------���� --------- case / decode ��� ���̵� ��� ����
select e.employee_id ���, e.first_name �̸�, e.salary �޿�,
        case
            when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'A'
            then '1���'
            when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'B'
            then '2���'
            when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'C'
            then '3���'
            when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'D'
            then '4���'
            when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'E'
            then '5���'
            else '6���'
        end ���,
        d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);

