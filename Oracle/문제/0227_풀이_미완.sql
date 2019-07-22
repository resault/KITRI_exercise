-- 1��

--1.���, �̸�, �μ���ȣ, �μ��̸�, �Ŵ�����ȣ, ���
--��� : �Ŵ����� Ŀ�̼��� �� �� ������ '�����'��� ǥ��, ������ ��ĭ���� �α� (case when then/ ansi �̿�)

select e.employee_id, e.first_name, e.department_id, d.department_name, e.manager_id, 
        case 
            when e.manager_id is null
                    and e.commission_pct is null
            then '�����'
            else ' '
        end "���"
from employees e join departments d
on e.department_id = d.department_id;



-- ��
select e.employee_id, e.first_name, d.department_name, e.manager_id,
        case 
        when e.manager_id is null and e.commission_pct is null
        then '�����'
        else ' '
        end ���
from employees e join departments d
on e.department_id=d.department_id;



-- 2.--������ȣ, �����̸�, �����̸�, �����ȣ�� ���ض�(anti join/ using�̿�)
select l.country_id, c.country_name, r.region_name, l.postal_code
from locations l join countries c
on l.country_id = c.country_id
join regions r
on c.region_id = r.region_id;

-- ��
select country_id, c.country_name, r.region_name, l.postal_code
from countries c join regions r
using(region_id)
join locations l
using(country_id);





--3.--��å ���̵� 'SA_REP'�� ��� �����
--���, �̸�,��å�̸�,�μ��̸�
--��, �μ��� ���� ��� '���߷�'���� ���
select e.employee_id, e.first_name, j.job_title, nvl(d.department_name , '���߷�')
from employees e, jobs j, departments d
where e.job_id = j.job_id
            and e.department_id = d.department_id(+)
        and lower(e.job_id) = lower('SA_REP');



-- ��

SELECT E.EMPLOYEE_ID,E.FIRST_NAME,J.JOB_ID,NVL(D.DEPARTMENT_NAME,'���߷�')
FROM EMPLOYEES E,DEPARTMENTS D,JOBS J
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+)
AND E.JOB_ID = J.JOB_ID
AND UPPER(J.JOB_ID) = UPPER('SA_REP')
;




--4.--��� ����� ���,�̸�,������,����̸�, �μ��̸�
--��� ����� ���� ��� ��� ����� '����'���� ����ϰ� ��Ī�� �����ȣ
--�� ����� ���� ��� ����̸��� '����'���� ����ϰ� ��Ī�� �����
--��, �μ��� �������� ��� �μ��̸��� '���߷���'���
select e.employee_id ���, e.first_name �̸�, 
        nvl(to_char(e.manager_id, '999999') , '����') ������, 
            case                                    -- �ٵ� ���� ���⼭ ���� case�� ��� ��?
                when e.manager_id is null
                then '����'
                else m.first_name
            end �����,
        nvl(d.department_name, '���߷���') �μ��̸�
from employees e, employees m, departments d
where e.manager_id = m.employee_id(+)
        and e.department_id = d.department_id(+);



select nvl(e.manager_id , '����') ������ -- ���� �߻�
from employees e, employees m
where e.manager_id = m.employee_id(+);

select *
from employees e, employees m
where e.manager_id = m.employee_id(+);




--��
SELECT E.EMPLOYEE_ID
            ,E.FIRST_NAME
            ,NVL(TO_CHAR(M.EMPLOYEE_ID,'9999'), '����')"�����ȣ"
            ,NVL(M.FIRST_NAME,'����')"�����"
            ,NVL(D.DEPARTMENT_NAME,'���߷���')
FROM EMPLOYEES E
            ,EMPLOYEES M
            ,DEPARTMENTS D
    WHERE E.MANAGER_ID=M.EMPLOYEE_ID(+)
    AND E.DEPARTMENT_ID=D.DEPARTMENT_ID(+);





5.-- ��� ����� ���, �̸�, �μ��̸�, �ٹ���, �ٹ����� �� ���Ͻÿ�


6.-- ��� ���, �μ�, ������ ���, �̸�, �μ��̸�, �ٹ���, �ٹ����� ���Ͻÿ� (���� ��Ī�� ����)
-- ��, �μ��� ���� ��� '����'
-- ��, �μ��� ������ �ٹ��ڰ� ���� ��� �̸��� '�ٹ��ھ���'
-- �׿��� �� ���� '-'


7.-- �� �μ� �� ����� �޿������ ǥ���Ͻÿ�
-- ���: �����ȣ, �μ� �̸�, ��� �̸�, �޿����


8.-- ��� ����� ��� ���̵�, �μ��̸� (null�� ��� ����) , ������ Ŀ�̼��� ������������ ���� �������� �� �������, ���� ǥ���Ͻÿ�
-- ���:  ��� �μ� ���̵�, �μ��̸�, ������� 


9.--us�� ��� ������� ��� �̸� �μ���ȣ �μ��̸� �����̸��� ���ÿ�(ansi ������ ���ÿ�)



10.--����� ��� �̸� �ְ�޿� �����޿��� non-equi�� �̿��Ͻÿ�



-- 2��


--1. 'sales' �μ����� �ٹ��ϸ�, �̸�(first_name)�� 'a ~ e'�� ������ �����
-- ���, �̸�, �μ��̸�, �����̸�, �ټ� ����, ��� ����϶�
-- ��, �ټ� ������ �ý��� ��¥�� �������� ��/���� ������� �ʰ� �����ϸ�, '30�� �ٹ��Ͽ����ϴ�."�� ���·� ����Ѵ�.
-- �ټӿ����� 25�� �̻��̸� ��� '���ټ���'��, �� �̿��� ��쿡�� �������� ����϶�.
select e.employee_id ���, e.first_name �̸�, d.department_name �μ��̸�, j.job_title �����̸�,
        concat((to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy')), '�� �ٹ��Ͽ����ϴ�.') "�ټ� ����",
        case
            when (to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy')) >= 25
            then '���ټ���'
            else ' '
        end "���"
from employees e, departments d, jobs j
where e.department_id = d.department_id
            and e.job_id = j.job_id
        and ascii(substr( e.first_name, length(e.first_name), 1)) between 97 and 101;



--2. ���� ������ ������ ����� ���, �̸�, �μ��̸�, �����̸�, �Ի� ����, Ŀ�̼��� ������ �޿���
-- ��� ������ �����Ͽ� ����϶� 
-- join ���
select e.employee_id ���, e.first_name �̸�, d.department_name �μ��̸�, j.job_title �����̸�,
        to_char(e.hire_date, 'yyyy') �Ի翬��, e.salary*(1+nvl(e.commission_pct, 0)) �޿�
from employees e, job_history h, departments d, jobs j
where e.employee_id = h.employee_id(+)
        and h.employee_id is null
        and e.department_id = d.department_id(+)
        and e.job_id = j.job_id
order by e.employee_id; 

select *
from employees e, job_history h
where e.employee_id = h.employee_id(+)
        and h.employee_id is null;

-- subquery ���
select e.employee_id ���, e.first_name �̸�,
        (select department_name from departments where e.department_id = department_id) �μ��̸�,
        (select job_title from jobs where e.job_id = job_id) �����̸�,
        to_char(e.hire_date, 'yyyy') "�Ի� ����", e.salary*(1+nvl(e.commission_pct, 0)) �޿�
from employees e
where e.employee_id <> all (select employee_id
                            from job_history)
order by e.employee_id;

3.
--trenna rajs �ѻ���� ��� �μ����� ���� ���� ���� �Ϸ��ڵ�(���+�μ��̸�+�����+�Ŵ����̸�)�� ������� �Ѵ�.
--�� �Ŵ����� ���� �� �Ŵ�����ȣ�� x �̶�� �ѵ� ���



4.
--��� ������ ����� ���, �̸�, �μ���ȣ,����,�����̸��� ���ÿ� (oracle join����)


5.
--��� ����� ���, �̸�, Ŀ�̼��� ���Ե� �޿�(Ŀ�̼� ������ �׳� �޿�), �Ŵ����̸�, �޿������� ���Ͻÿ�
--�Ŵ����� ���� ����� '����'�̶�� ���ÿ�
--�޿������� 5000�̸� �̸� ��, 10000�̸��̸� ��, 10000�̻��̸� �� �̴�. (ANSI join���� ���ÿ�)


6. �޿��� 4000 �̸��� ����� 3����
            10000 �̸�         5����
            10000 �̻�         10����

'Seattle'�� ��� ����� ���, �̸�, �޿�, �μ��̸�, ����,����� ���Ͽ���
(case���� ������ �̿��Ͽ� Ǯ���, null���� ��� ǥ��) 
����� ������������ ����




7. 'programmer'�� ���, �̸�, ��å, ������ ����϶�(ansi��������)



8. 
-- ���̳� �̸��� 's'�� ���� ������� ��������
-- Ǯ����, ���, ��å, �μ��̸��� ����� ��
-- hint : �� 9�� ����!


-- 3��

1. 
--inner join ����Ұ�, �Ŵ������̵� 100���� ����� ���, �̸�, �μ��̸�


2. 
--inner join ����Ұ�, Washington �ֿ� ��ġ�� �μ��� �μ���ȣ�� �μ��̸�


3. 
--ANSI ������ ����Ͽ� 'accounting' �μ� �Ҽ� ����� �̸��� �Ի����� ����ϼ���.
--��, �Ի����� �⵵�� ǥ�� �Ͻÿ�.    


4.
--ANSI ������ ����Ͽ� ����信�� �ٹ��ϴ� ����� �̸��� �޿��� ����ϼ���.

5.��� �μ��� �ٹ��ϴ� ����� �̸�, ��å�̸�, �μ��̸�
-- ��, �μ��� �������� ���, �μ��̸��� '������'���� ���
-- ��� : 20��

6.
--��� ����� ���, �̸�, ��� �� �����å�̸�
-- ��, ����� ���� ����� ���, �����å�̸��� '��� ����'���� ���
-- ��� : 23��
7.
-.��� ����鿡�� ������ ��Ʈ�� ����Ϸ��Ѵ�.
--ansi join�� �̿��Ͽ�������� ������ ���� �����ȣ�� �˾Ƴ��ÿ�.
--��� ������� ���, �̸�, �μ� �̸�, �����ȣ

8.
--������ ����� �Ͱ� �ٸ� ������ ansi join �� �̿��Ͽ�
--��� ������� ���, �̸�, �μ� �̸�, �����ȣ
--�μ��� ���� ���� ��� '���߷���', �����ȣ�� ������� '���ü���' ���� ǥ���Ѵ�.



9.
--��� ������ �̸�, ����, ��å�̸�, ���� ����
--��, ������ ���� ������ �����϶�


10
--��� ����� �̸�, �μ��̸�, ����, �����̸�, ����̸� ���(join�� �̿��ؼ� ���)

11.
-- ���� ������ �ִ� ����� �̸�(���� ������ '�������') "�λ��̵�", ��������̸� "����" (�̸�������)



12.
-  ���� ������ �ִ� ����� �̸�(���� ������ '�������') "�λ��̵�", ��������̸� "����" (�̸�������)  (right join���ּ���)



-- 4��

1--������� ���, �̸�, �μ��̸� ,�μ���ȣ , ������, ����̸� , ����μ���ȣ, ����μ��̸�
--null : �������, ���� , ���߷�  
--Join �� �̿��Ͽ� ���




2--
--��� ����� �̸� �μ��̸� �����̸�, �����̸�

1. �ѹ��� ��å�� ����� ���� ���� ����� ����� �̸� ���



2. �����ڻ��, �������� ã��
-- ��å�� ����� �̷��� ������ ���� ������̺��� ���� ����� ������ ����̶� �ϰ�, ��å�� �������� �������̶� �Ѵ�.


3.��� �μ� ��� ��� �ٹ��ϴ� ����� ���, �̸�(��� ����), �μ���ȣ, �μ��̸�, �μ�, �����̸�(seattle) (ansi ����ϱ�)(�ҹ��ڸ� ���)

��Ĺ���


�´°���?


1.join �ٷ� �ڿ� on, where �Ѵ� ��� �����ϴ�.
2.natural join�� �÷��� �޶� �ڵ����� ���εȴ�.
3.(+)�� ���ؿ� ��� ���� �׻� �ƹ����� ���� �ȵȴ�.

1999�� 1�� 1�� ���Ŀ� �Ի��� �����ȣ, �����, �μ���ȣ, �μ��� (ansi join)


1. -- �ٹ� ������ �̱��� ������� ���, �޿�, �޿� ���, ����� ��ȣ
         -- �ش� data�� ���� ��쿡�� '-1'���� ǥ��


2. -- �޿� ����� B, D, F �� ������� �̸�, �޿�, �ٹ� ���� (JOIN Ű���� ���)

