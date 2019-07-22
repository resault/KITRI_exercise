-- 1��
--1. ����� �ִ� ������ �ּ� ������ ����� ���ϰ� ��Ī�� "��ձ޿�"��� ���. 
select (min_salary+max_salary)/2 as "��ձ޿�"
from jobs;

--2. ����� �̸��ϰ� ��ȭ��ȣ�� �����Ͽ� "ȸ��"�̶�� ��Ī���� ����Ʈ�� ������. (�̸��ϰ� ��ȭ��ȣ ���̿��� /�߰�)
select email || '/' || phone_number ȸ�� 
from employees;

--3. ����� id�� �μ�id�� Ȱ���Ͽ� ��� �Ҽ����� �˾Ƴ���
select department_ID, department_name
from departments;

select employee_ID, department_ID
from employees;

--4. ������� ���� Ŀ�̼��� �޴��� ���϶�( �˼� ������ 0���� ���Ѵ�.)
select salary*((1+nvl(commission_PCT,0))-1)
from employees;

--5. (Ǯ����)�� ��ȭ��ȣ�� (��ȭ��ȣ)�Դϴ�.   ��Ī : ��� ��ȭ��ȣ
select first_name || '�� ��ȭ��ȣ�� ' || phone_number || '�Դϴ�.'
from employees;

--6. (�����̸�)�� ��� �ӱ��� (��� �޿�)�� �Դϴ�.   ��Ī : ������ ��� �޿�
select job_title || '�� ��� �ӱ��� ' || (min_salary+max_salary)/2 || '�� �Դϴ�.'
from jobs;

--7. ������Ʈ ���� �Ⱓ�� (������Ʈ ���� �Ⱓ) �Դϴ�.
select '������Ʈ ���� �Ⱓ�� ' || (end_date-start_date) || ' �Դϴ�.'
from job_history;

--8. (�μ��̸�)�� ������ ��ȣ�� (�޴��� ��ȣ) �Դϴ�.
select department_name || '�� ������ ��ȣ�� ' || manager_ID || '�Դϴ�.'
from departments;

--9. �μ� ��ȣ�� xx�� �μ��� �̸��� xx �Դϴ�.
select '�μ� ��ȣ�� ' || department_id || '�� �μ��� �̸��� ' || department_name || '�Դϴ�.'
from departments;

--10. ��� ��ȣ xx�� xx������ ������Ʈ�� �����߽��ϴ�.
select '��� ��ȣ ' || employee_ID || '�� ' || hire_date || '������ ������Ʈ�� �����߽��ϴ�.'
from employees;



-- 2��
-- 1. employees���̺� ���� �� ���� ���ο�  ������ ��¥�� ���̰� �μ���ȣ�� null�� ����� ã�Ƽ� null�� 80���� �ٲ��
select '2019.02.21.', nvl(department_ID,80)
from employees;

-- 2. ���� �������� ���ϴ� ��� 4���߿� ������ ���� ���� �޴»����?
-- ������ �ִ� �μ��� sales(80)�̴�. �ش� �μ����� ���ϴ� ��� �� �޿��� ���� ���� ����� Ellen abel
select *
from regions;

select *
from countries;

select *
from locations;

select *
from departments;

select department_ID, salary, first_name || ' ' || last_name
from employees;

-- 3. jobs ���̺��� ���� �̸��� �ּ� �޿�, �ִ�޿�, ��ձ޿��� ����ϰ� ��ձ޿��� ��Ī�� ��� �޿��� �Ͻÿ�.
--    (��ձ޿��� �ּұ޿��� �ִ�޿��� ��հ����� �Ѵ�.)
select job_title, min_salary, max_salary, (min_salary+max_salary)/2 as "��� �޿�"
from jobs;

-- 4. locations ���̺��� ��ü�ּҸ� ����ϰ� ��Ī�� �ּ� �� �Ͻÿ� . (��ü�ּ� : street_address, city, country_ID )
select street_address || ' ' || city || ' ' || country_ID �ּ�
from locations;

-- 5. �μ���ȣ�� ()�� ����� Ŀ�̼����Ա޿��� ()�̴�. ��� ����Ͻÿ�
select '�μ���ȣ�� ' || department_ID || '�� ����� Ŀ�̼� ���Ա޿��� ' || salary*(1+nvl(commission_pct,0)) || '�̴�.'
from employees;

-- 6. (Ǯ������)�� ����ȣ�� ()�̰� �̸�����()�̴�. ��� ����Ͻÿ�
select first_name || ' ' || last_name || '�� ����ȣ�� ' || phone_number || '�̰� �̸����� ' || email || '�̴�.'
from employees;

-- 7. '����'�� ���� �� �ִ� ���� �ݾ��� ' '���̸�, �ְ�ݾ��� ' '���Դϴ�. �׸��� �� �ݾ��� ���̴� ' '���Դϴ�. 
--    (�̷��� �� ��µǰ� ����, ���̺��� �̸��� as�� �̿��ؼ� ��̴��ӴϷ� ������ ��)
select job_title || '�� ���� �� �ִ� ���� �ݾ��� ' || min_salary || '���̸�, �ְ�ݾ��� ' || max_salary || '���Դϴ�. �׸��� �� �ݾ��� ���̴� ' || (max_salary-min_salary) || '���Դϴ�.'
from jobs;

-- 8. '��� �̸�+��'�� ���� ������ ' '���̴�. (Ŀ�̼��� ���� ������� �װ� �����Ͽ� ������� �� ���)
-- �׸��� Ŀ�̼��� ���� ������� Ŀ�̼��� �Ⱥپ����� �������̰� �󸶳� ������ ���� ��Ÿ�� ��(��Ī�� ���� Ŀ�̼�), Ŀ�̼��� 0�� ������� 0���� ǥ��
-- << �� �� 2��
select first_name || ' ' || last_name || '�� ���� ������ ' || salary*(1+nvl(commission_PCT,0)) || '���̴�.', salary*(1+nvl(commission_PCT,0))-salary "���� Ŀ�̼�"
from employees;

-- 9. "President"�� �ִ� �޿��� 40000�Դϴ�. (���� ���� ���·� ����ϸ�, ��Ī�� ���� �Ѵ�.)
select employee_id ���, hire_date �Ի���, salary*(1+nvl(commission_pct,0)) "�޿�_Ŀ�̼� ����"
from employees;

-- 10. ���, �Ի���, Ŀ�̼��� ���Ե� �޿��� ����϶�. (��Ī�� ���� ���, �Ի���, �޿�_Ŀ�̼� ���� ���� �Ѵ�.)
select '"' || job_title || '"�� �ִ� �޿��� ' || max_salary || '�Դϴ�.'
from jobs;


-- 3��
-- Q1. **(�̸�)�� �����ּҴ�**�̰� �ڵ�����ȣ��**�̴�. ������ ���� ����ϱ� column�̸��� ����ó
select first_name || '�� �����ּҴ�' || email || '�̰� �ڵ�����ȣ�� ' || phone_number || '�̴�.' ����ó
from employees;

-- Q2. **(����) **(����)�� **(����)�� **(�ּ�)�� �����ȣ�� **�̴�. ������ ���� ����ϱ� column�̸��� �����ȣ
select country_id || ' ' || 'state_province' || '�� ' || city || '�� ' || street_address || '�� �����ȣ�� ' || postal_code || '�̴�.' �����ȣ
from locations;

-- Q3. "000 ��� - �̸��� : 000@gamil.com / ��ȭ��ȣ : ***.***.****" �������� ����ϼ��� (�̸��� '�̸� ��' ����)
select first_name || '��� - �̸��� : ' || email || '@gmail.com / ��ȭ��ȣ : ' || phone_number
from employees;

-- Q4. "���� �ּ�, ���ø�, ���̸�, ����ID" �������� ����ϼ��� (Column���� '�ּ�')
select street_address || ', ' || city || ', ' || state_province || ', ' || location_id
from locations;

-- Q5."full name"�� ������ "job_id"�̸� �Ի糯¥�� "hire_date"�̴�. 
select '"' || first_name || ' ' || last_name || '�� ������ "' || job_id || '�̸� �Ի糯¥�� "' || hire_date || '�̴�.'
from employees;

-- Q6. "�����ȣ - ���� - �ּ�"  ���·� ������ּ���.
select postal_code || ' - ' || city || ' ' || street_address
from locations;

-- Q7 �ͽ��� �þ�Ʋ�� ��ġ�� ������ �����ȣ�� 98199�̴�.(��Ī : Post code)
select state_province || ' ' || city || '�� ��ġ�� ������ �����ȣ�� ' || postal_code || '�̴�.' "post code"
from locations;

-- Q8.�̸�(Ǯ����)�� �޿��� 10% �λ�Ǿ� ??�̴�. (��Ī : �޿��λ�)
select first_name || ' ' || last_name || '�� �޿��� 10% �λ�Ǿ� ' || salary*1.1 || '�̴�.' �޿��λ�
from employees;



-- 4��
-- 1. ����̸�(Ǯ����), �Ի���, �Ŵ�����ȣ (�Ŵ����� ���� ��� '-1' ���� ǥ��)
select first_name || ' ' || last_name, hire_date, nvl(manager_id, -1)
from employees;

-- 2. oo�� ����� oo�� �μ����� oo������ �����ϰ� �� ���ڴ� oo�� �Դϴ�. (��Ī "�������")
select employee_id || '�� ����� ' || department_id || '�μ����� ' || job_id || '������ �����ϰ� �� ���ڴ� ' || start_date || '�� �Դϴ�.' �������
from job_history;

-- 3. ����ڵ�, �̸�(Ǯ����), Ŀ�̼��� ����� �޿�('�������޿�' �� ǥ��), �����Ŀ�̼� +3.5 �� �ö� �޿�('�����ı޿�' �� ǥ��) �� ����ϼ���.           
-- (Ŀ�̼��� null �ΰ��� 0���� ����մϴ�.)
select employee_id, first_name || ' ' || last_name, salary*(1+nvl(commission_pct, 0)) �������޿�, salary*1.035 �����ı޿�
from employees;

-- 4. " location_id �� US Texas Southlake 2014 jabberwocky Rd, �����ȣ �Դϴ�. " �� ���� �������� select ���� ����ϼ���(alias�� "�ּ�" �Դϴ�.) 
select location_id || '�� ' || country_id || ' ' || state_province || ' ' || city || ' ' || street_address || ', ' || postal_code || '�Դϴ�.' �ּ�
from locations;

-- 5. ������ xx�� ����� �̸� xxx �̸� �޿��� xxx �Դϴ�.
select '������ ' || job_id || '�� ����� �̸��� ' || first_name || '�̸� �޿��� ' || salary || '�Դϴ�.'
from employees;

-- 6. ����  �̸�(Ǯ����) ��� �޿� Ŀ�̼�(0) Ŀ�̼��ձ޿�+2
select job_id ����, first_name || ' ' || last_name �̸�, employee_id ���, salary �޿�, salary*nvl(commission_pct, 0) Ŀ�̼�, salary*(1+nvl(commission_pct, 0))+2 "Ŀ�̼��ձ޿�+2"
from employees;

-- 7. �� ������ �ּ� ������ ����ϼ��� (��� ���� : XXX ������ XXX �����ȣ�� XXX �Դϴ�.)  (Alias : Address Info)
select city || ' ������ ' || street_address || ' �����ȣ�� ' || postal_code || '�Դϴ�.' as "Address Info"
from locations;

-- 8. ���� �� ���� ������ ����ϼ��� (��� ���� : XX ������ ������ XXX ~ XXX ���� �Դϴ�.)  (Alias : Salary Info)
select job_title || ' ������ ������ ' || min_salary || ' ~ ' || max_salary || '���� �Դϴ�.' as "Salary Info"
from jobs;

-- 9. ����̸�(Ǯ���� �߰��� ����ֱ�), ����� Ŀ�̼��� ���� �˻��϶�, �÷����� �̸��� ������� �����϶�.(Ŀ�̼��� ���� ������ 0)
select first_name || ' ' || last_name �̸�, salary*nvl(commission_pct, 0) ������
from employees;

-- 10. ���, �޿�, 300���� �޿�
select employee_id, salary, salary-300
from employees;

-- 11. ��Ī�� ���� �� ���� �����?     
select employee_id as ���
from employees;

select employee_id as "���"  
from employees;

select employee_id "���" 
from employees;

select employee_id ���
from employees;

select employee_id '���'
from employees;

-- 12. ���, �̸�(Ǯ����), �޿�, Ŀ�̼����Ա޿�, 100�λ� �� Ŀ�̼����Ա޿�/ (��ü Į�� �̸� ����)
select employee_id ���, first_name || ' ' || last_name �̸�, salary �޿�, salary*(1+nvl(commission_pct, 0)) "Ŀ�̼� ���� �޿�", salary*(1+nvl(commission_pct, 0))+100 "�λ� ��"
from employees;