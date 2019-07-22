-- ���� ������

-- Union, Union all, Intersect,
-- �μ���ȣ�� 50�̰ų� 90�� �����
-- �޿��� 10000 �̻��� �����
-- ���, �̸�, �޿�, �μ���ȣ
select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
union        
select employee_id, first_name, salary, department_id
from employees
where salary >= 10000;

select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
union all
select employee_id, first_name, salary, department_id
from employees
where salary >= 10000;

select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
intersect
select employee_id, first_name, salary, department_id
from employees
where salary >= 10000;

select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
minus
select employee_id, first_name, salary, department_id
from employees
where salary >= 10000;


select employee_id, first_name, salary, department_id
from employees
where salary >= 10000
minus
select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90);



-- [Group by]

-- �μ��� �޿�����, ��ձ޿�, �����, �ִ�޿�, �ּұ޿�
select department_id �μ���ȣ, sum(salary) �޿�����, avg(salary) ��ձ޿�,
        count(employee_id) �����, max(salary) �ִ�޿�, min(salary) �ּұ޿�
from employees 
group by department_id;


select department_id �μ���ȣ, sum(salary) �޿�����, avg(salary) ��ձ޿�,
        count(employee_id) �����, max(salary) �ִ�޿�, min(salary) �ּұ޿�,
        employee_id ---------------------------------------------------------------�׷����� �÷��� �׷��Լ��� ��� ������!
from employees 
group by department_id;


-- having ��
-- �μ��� �޿�����, ��ձ޿�, �����, �ִ�޿�, �ּұ޿�
-- ��ձ޿��� 5000 ������ �μ�
select department_id �μ���ȣ, sum(salary) �޿�����, avg(salary) ��ձ޿�,
        count(employee_id) �����, max(salary) �ִ�޿�, min(salary) �ּұ޿�
from employees
group by department_id 
having avg(salary) <= 5000;



-- ����
-- 1. ��� �μ��� ��� �޿�(�� �μ��� ���)���� ���� �޴� �����
-- ���, �̸�, �޿�
select employee_id, first_name, salary
from employees
where salary > all ((select avg(salary)
                       from employees
                       group by department_id
                      )
                     );


-- 2.�μ��� �ְ� �޿��� �޴� �����
-- �μ��̸�, ���, �̸�, �޿� (��, �μ��� ���� ����� �����Ѵ�)
select (select department_name from departments where e.department_id = department_id) �μ��̸�,
        e.employee_id ���, e.first_name �̸�, e.salary �޿�
from employees e, (select department_id, max(salary) �޿�
                    from employees
                    group by department_id
                    having department_id is not null) m
where e.salary = m."�޿�"
        and e.department_id = m.department_id;

-- �μ��� ���� ����� �����Ϸ���? Union 
select (select department_name from departments where e.department_id = department_id) �μ��̸�,
        e.employee_id ���, e.first_name �̸�, e.salary �޿�
from employees e, (select department_id, max(salary) �޿�
                    from employees
                    group by department_id
                    having department_id is not null) m
where e.salary = m."�޿�"
        and e.department_id = m.department_id
union
select (select department_name from departments where e.department_id = department_id) �μ��̸�,
        e.employee_id ���, e.first_name �̸�, e.salary �޿�
from employees e, (select department_id, max(salary) �޿�
                    from employees
                    group by department_id
                    having department_id is null) m
where e.salary = m."�޿�";



-- is null�� ����??
select (select department_name from departments where e.department_id = department_id) �μ��̸�,
        e.employee_id ���, e.first_name �̸�, e.salary �޿�
from employees e, (select department_id, max(salary) �޿�
                    from employees
                    group by department_id) m
where e.salary = m."�޿�"
        or e.department_id is null  ------ ������ ���� ������, null�� ����� �������� ����� max ��ü�� ����� �ȳ��� ����
        and e.department_id = m.department_id;



------------------------------------------------------------------------------------------������� 

-- Top N Query

-- ���, �̸�, �޿�, �Ի翬��, �μ��̸�
-- �޿��� ����,
-- �� �������� 5�� ��µȴٰ� ������ ��, 2���� ����� ��
-- 1980���, 1990���, 2000��� 

----�̰� ������
select e.employee_id ���, e.first_name �̸�, e.salary �޿�,
        decode( substr( to_char(e.hire_date, 'yyyy') , 3, 2),
                '1980', '1980���',
                '1990', '1990���',
                '2000���') "�Ի� ����",
        (select department_name from departments where e.department_id = department_id) "�μ��̸�"---------- �̰�, A��� ����� �μ� ��ȣ�� X�� ��, �ش� �μ��̸��� �����°� �ƴ�!!!---------�� �κ� Ȯ��!!!
from (select rownum ����, employee_id
       from (select employee_id
              from employees
              order by salary desc)) s, employees e
where s.employee_id = e.employee_id
        and s.���� between ((&page*5)-4) and (&page * 5);


---- ��Ģ���� ����


select b.rn �޿�����, b.employee_id ���, b.first_name �̸�, b.salary �޿�,
        case
            when to_char(b.hire_date, 'yyyy') < '1990'  ----------- �����񱳸� �ϴ� ���̹Ƿ�, �ǹ̻� decode ���ٴ� case�� ������
            then '1980���'
            when to_char(b.hire_date, 'yyyy') < '2000'
            then '1990���'
            else '2000���'
        end �Ի翬��,
        d.department_name �μ��̸�
from (select rownum rn, a.*
       from (select employee_id, first_name, salary, hire_date, department_id
              from employees
              order by salary desc) a
       where rownum <= &page * 5) b, departments d
where b.department_id = d.department_id(+)
        and b.rn > &page * 5 - 5        ------------- ������ ������ ��쵵 ����ؾ� �ϹǷ� ���ڴ� ���ϵǰ� ����ϴ� ���� ����
order by �޿�����;  ----------- �̰� ���ڱ� �� ������ �ٲ������??


-----------����üũ
select rownum, employee_id ---------- ��������� select ������ order by �̱� ������ rownum �� �Ű��� �Ŀ� ���ĵ�
from employees
order by salary desc;


------------���۸��غ��� rank over�� ����ؼ� ���� ���� Ǯ� ��
rank over



-------------- �� �޾ƿ���
select *
from employees
where salary > &page;




-- rownum
select rownum, employee_id, salary
from employees
where rownum < 10;

select rownum, employee_id, salary
from employees
where rownum > 5;


--------------------------------------------------------------------------------- ������� ��Ʈ����!!
