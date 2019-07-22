-- 1��

-- 1. ������� ���, ��å,  �޿�, �ְ�޿�, �����޿��� ���Ͻÿ� 
select e.employee_id, j.job_title, e.salary, j.max_salary, j.min_salary
from employees e, jobs j
where e.job_id = j.job_id;

-- ��
select e.salary, j.job_id, j.min_salary, j.max_salary
from employees e, jobs j
where e.job_id = j.job_id;

-- 2. US�� �����ϴ� ����� ��� ��å�� �����ÿ�
select e.employee_id, j.job_title
from employees e, jobs j, departments d, locations l
where e.job_id = j.job_id
        and e.department_id = d.department_id
        and d.location_id = l.location_id
        and lower(l.country_id) = lower('US')
order by e.employee_id;

-- ��
select e.employee_id, e.job_id, c.country_id, d.department_id, l.city
from employees e, countries c, locations l, departments d
where upper(c.country_id) = upper('us')
and c.country_id = l.country_id
and d.department_id = e.department_id
and l.location_id = d.location_id;


-- 3. ��� ����� �μ��̸�, ���, �̸�, �Ŵ������, �Ŵ����̸� (case �� ���)
select d.department_name �μ��̸�, e.employee_id ���, e.first_name �̸�, e.manager_id �Ŵ������,
        case
            when e.manager_id = m.employee_id
            then m.first_name
        end �Ŵ����̸�
from employees e, departments d, employees m
where e.department_id = d.department_id
        and e.manager_id = m.employee_id
order by d.department_name;



-- ��
select d.department_name, e.employee_id, e.first_name, d.manager_id, e.manager_id,
    case when e.manager_id = m.employee_id
        then m.first_name
        end "�Ŵ����̸�"
from employees e, departments d, employees m
where e.department_id = d.department_id 
    and e.manager_id = m.employee_id
order by department_name;



-- 4. ��� ������ ���, �̸�, �μ��̸�, ��å�̸�, �μ��� (������ �μ����� ��� null ǥ�ô� ����)
select e.employee_id, e.first_name, d.department_name, j.job_title, p.first_name
from employees e, departments d, jobs j, employees p
where e.department_id = d.department_id
        and e.job_id = j.job_id
        and d.manager_id = p.employee_id;

select e.employee_id, e.first_name, d.department_name, j.job_title, p.first_name,
        case
            when d.manager_id = p.employee_id
            then p.first_name
        end
from employees e, departments d, jobs j, employees p
where e.department_id = d.department_id
        and e.job_id = j.job_id
        and d.manager_id = p.employee_id;


-- ��
select e.employee_id, e.first_name, d.department_name, j.job_title, d.manager_id,
    case when d.manager_id = e.manager_id
         then m.first_name
         when e.manager_id = m.employee_id
         then e.first_name
        end "�μ���"
from employees e, departments d, jobs j, employees m

where e.department_id = d.department_id
      and e.job_id = j.job_id
      and e.manager_id = m.employee_id;




-- 5. ���, �̸�, �μ���ȣ, �μ��̸�, �з��� �̾ƶ�.
--�з�(decode�̿�)
--�μ���ȣ�� 110�̸� �濵
--          60�̸� ����
--          50�̸� ���
--          �׿� ��Ÿ
select e.employee_id, e.first_name, e.department_id, d.department_name,
        decode(e.department_id, 110, '�濵', 60, '����', 50, '���', '��Ÿ') �з�
from employees e, departments d
where e.department_id = d.department_id;


-- 6. ���� ��ȣ, �����̸�, ���, �̸�, �޿�, �ִ�޿�, �ּұ޿��� ���ض�
select e.job_id, j.job_title, e.employee_id, e.first_name, e.salary, j.max_salary, j.min_salary
from employees e, jobs j
where e.job_id = j.job_id;


-- 2��


--1. �ּҿ����� 10000�� �Ѵ� ��å�� ����� �����ȣ, �̸�, ����, ��å�̸�,�μ��̸�
select e.employee_id, e.first_name, e.salary, j.job_title, d.department_name
from employees e, jobs j, departments d
where e.job_id = j.job_id
            and e.department_id = d.department_id
        and j.min_salary > 10000;

--2.���,�̸�,�Ŵ������,�Ŵ����̸�,�Ŵ����� ��å 
--(��Ī�� �Ŵ�����å���� �ٲٽÿ�.)

select e.employee_id, e.first_name, e.manager_id, m.first_name, j.job_title
from employees e, employees m, jobs j
where e.manager_id = m.employee_id
        and m.job_id = j.job_id;



-- 3. 'toronto'�� ��ġ�� �μ��� �ٹ��ϴ� ��� �� 8���� �Ի��� �����
-- ���, �̸�, �μ���, ��å�̸�, �Ŵ��� �̸��� ����϶�.
select e.employee_id, e.first_name, d.department_name, j.job_title, em.first_name
from departments d, locations l, employees e, jobs j, employees em
where d.location_id = l.location_id 
            and d.department_id = e.department_id
            and e.job_id = j.job_id
            and e.manager_id = em.employee_id
        and lower(l.city) = lower('toronto')
        and to_char(e.hire_date, 'mm') = '08';




-- 4. 1995�� ������ �Ի��� ��� �� 5000 ������ �޿��� �޴� �����
-- ���, �̸�, ��å�̸�, �޿�, �ٹ� ���ø� ����϶�

select e.employee_id, e.first_name, j.job_title, e.salary, l.city, e.hire_date
from employees e, jobs j, departments d, locations l
where e.job_id = j.job_id
        and e.department_id = d.department_id
        and d.location_id = l.location_id
        and to_number(to_char(e.hire_date, 'yyyy'), '9999') <= 1995
        and e.salary <= 5000;

-- 5.���� ������ ��� ����� ������ ���� ������ ��Ÿ������
select e.employee_id, e.first_name, r.region_name, e.salary
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id
        and d.location_id = l.location_id
        and l.country_id = c.country_id
        and c.region_id = r.region_id
order by r.region_name, salary desc;



-- 6.�̱��� ��� ��ȭ ����ȣ�� 8009�� ������� ������ ������ �մϴ�. �ּҰ� ����?������
select l.street_address, l.postal_code, l.city, l.state_province
from departments d, locations l, countries c, employees e
where d.location_id = l.location_id
            and l.country_id = c.country_id
            and d.department_id = e.department_id
        and lower(c.country_name) like lower('united states of america')
        and substr(e.phone_number, length(e.phone_number)-3, 4) = 8009;
        
-- ��
select l.street_address, l.postal_code, l.city, l.state_province 
from employees e, departments d, locations l, countries c, regions r
where r.region_id = c.region_id
        and c.country_id = l.country_id
        and l.location_id = d.location_id
        and d.department_id = e.department_id
    and lower(r.region_name) = 'americas' and phone_number like '%8009';


-- 7. ��ü ������� �����, Ǯ����, �μ��̸�, �ٹ��� �ּ�(ex. Americas> 2004 Jabberwocky Rd, Southlake, Texas, US)�� ����Ұ�
select e.employee_id ���, concat(e.first_name, concat( ' ' , last_name)) Ǯ����,
        d.department_id, concat( r.region_name, 
                                concat( '> ', 
                                    concat( l.street_address, 
                                        concat( ', ',
                                            concat( l.city, 
                                                concat( ', ', 
                                                    concat( l.state_province, 
                                                        concat( ', ', l.country_id) ) ) ) ) ) ) )
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id
        and d.location_id = l.location_id
        and l.country_id = c.country_id
        and c.region_id = r.region_id;


-- 8.�μ��̸��� 'marketing'�̸鼭 'americas'�� �ٹ��ϴ� ����� ���,�̸�,�μ��̸�,�����̸� ����ϼ���
select e.employee_id, e.first_name, d.department_name, l.city
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id
            and d.location_id = l.location_id
            and l.country_id = c.country_id
            and c.region_id = r.region_id
        and lower(d.department_name) = lower('marketing')
        and lower(r.region_name) = lower('americas');


-- ��
select e.employee_id, first_name, d.department_name,l. city
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id
          and d.location_id = l.location_id
          and l.country_id = c.country_id
          and c.region_id = r.region_id
          and lower(d.department_name) = lower('marketing')
          and lower(r.region_name) = lower('americas');


-- 3��

--1. �޿��� 10000�̻��� ������� "�̸�", "�ּ�", "�޿�"  
--�޿��� ���������� ����
select e.first_name, l.street_address, e.salary
from employees e, departments d, locations l
where e.department_id = d.department_id
            and d.location_id = l.location_id
order by salary desc;


--2. Kevin ����� �ٹ� ���� �μ��̸��� state
select e.first_name, d.department_name, l.state_province
from employees e, departments d, locations l
where e.department_id = d.department_id
            and d.location_id = l.location_id
        and lower(e.first_name) = lower('Kevin');



--3. �������� ����ؼ� ������� ���, �̸�, �޿�, ���ӻ���̸�, ���ӻ��(�Ŵ���)�Ǳ޿� ���





4.
--99�⵵�� ������Ʈ ������ ���������� �ִ� �μ����� ���� ��ġ�� �ּҿ� �����ȣ

5.
--�̸��� 'pat'�� ����� �Ŵ����̸�, ȸ�� �ּҸ� ����ϱ�
--��, �ּ� ������ [����� ����� ���̸� ���� �����ּ�]

6.
--����� 1�� �̻��� ����� ���, �̸�, �ٹ� �Ⱓ(���), ��� ��å �̸��� ����ϱ�
--��, ������� ����

7.
--peter �� ������ �ٹ����� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�

8.
----us(�빮������, �ҹ������� ��)�� ���, �̸�(Ǯ����), �޿� ���
--�޿��� ���� ������ ���

9.
--decode�� �̿��Ͽ� �̱����� ���ϴ� ����� �̱�, �������� ���ϴ� ����� ����, ĳ���ٿ��� ���ϴ� ����� ĳ���ٶ�� ����Ͻÿ�
--���̺��̸� :���, �̸�, �μ��̸�, �ٹ�����

10.
--������ �μ� ��� �� ���� ���� �����װ� ���� ���� �������� ���Ͻÿ�.
--���̺��̸� : �μ��̸�, �ְ���, ��������



-- 4��

1. ������� grade_level �� ���Ͻÿ�.
   ���, �̸�, �޿�, grade_level (������ ���)



2. ��å�� ����� ���� �ִ� �����(job_historys �� �̷��� �ִ� ���)�� 
   ���, �̸�, ������å�ڵ�, ������å��, ������å�ڵ�, ������å���� ǥ��
   (���ı����� ���)


3. �ѻ���� ã�ƶ�.
- �� ����� 3000 ~ 4500 ������ �޿��� ���� �� �ִ� ��å�� ������ �ִ�.
- �� ����� ���ϴ� �μ����� Administration �̴�.
- �� ����� ���, �̸�, �޿�, �μ��� ǥ��



4. 'europe'�� �ٹ��ϴ� ��� �̸� �μ��̸� �����̸�



5. ����� 100~150���� ����Ǳٹ� �̷�
   ���, �̸�, ��å�̸�, �μ��̸�,  �ٹ�����




6. 'canada'���� �ٹ��ϴ� ������� �Ŵ������� �޿������ ���Ͻÿ�.




7. first_name�� e�� ���� ������� �Ŵ����� �߿��� �޿��� 10000�̻��� ������� �޿� �հ踦 ���Ͻÿ�




8. 'Europe' �� �ٹ��ϴ� ����� �̸�, ����




9. �޿��� 10000�̻��̰� �μ���ȣ�� 110�� ����� �̸�, ��å�̸�



10. �޿� ����� B, D, F �� ������� �̸�, �޿�, �ٹ� ����
