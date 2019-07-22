-- 1��

-- 1. �Ŵ��� ��ȣ�� 130�̸��� �ʺ�  130�̻� 150���ϴ� �߱� �׿ܴ� ����̴�. ��� �̸� �Ŵ�����ȣ�� ������������ �����϶�.

select employee_id, first_name, manager_id,
        case
            when manager_id < 130
            then '�ʺ�'
            when manager_id <= 150
            then '�߱�'
            else '���'
        end
from employees
order by manager_id;

--��
select employee_id, first_name, manager_id,
        case 
        when manager_id < 130
        then '�ʺ�'
        when manager_id >= 130 and manager_id <= 150
        then '�߱�'
        else '���'
    end �Ŵ�����ų
from employees
order by manager_id;

-- 2. 48,456,231.20451 + 30000�� ��ȯ�Լ��� �̿��Ͽ� Ǫ�ÿ�

select '48,456,231.20451', to_number('48,456,231.20451', '00,000,000.00000') + 30000
from dual
union
-- ��
select '48,456,231.20451', to_number('48,456,231.20451','00,000,000.00000')+30000
from dual;


-- 3. ��������
-- �ý��� ���糯¥ ���� �ټӳ� 30�̻� ������, �׿� ����
-- ���, �̸�, ��ȭ��ȣ, �μ�
-- �������� ���� ����
select employee_id, first_name, phone_number, department_id,
        case
            when to_char(sysdate, 'yyyy')-to_char(hire_date, 'yyyy') >= 30
            then '������'
            else '����'
        end ��������
from employees
order by ��������;

-- ��

select employee_id, first_name, phone_number,to_char(sysdate,'yyyy')- to_char(hire_date,'yyyy'),
    case when to_char(sysdate,'yyyy')- to_char(hire_date,'yyyy')>= 30
    then '������'
    else '����'
    end "��������"
from employees
order by ��������;


-- 4. Ŀ�̼����Ա޿��� 4000 �̸� �󿩱� 10%
-- Ŀ�̼����Ա޿��� 10000 �̸� �󿩱� 7%
-- Ŀ�̼����Ա޿��� 20000 �̸� �󿩱� 5%
-- Ŀ�̼����Ա޿��� 20000 �̻� �󿩱� 2%
-- ���, �̸�, ��ȭ��ȣ, �μ�, Ŀ�̼����Ա޿�(��Ī : �޿�), �󿩱����Ա޿�(��Ī : �󿩱�)
select employee_id, first_name, phone_number, employee_id, salary*(1+nvl(commission_pct,0)) �޿�,
        case
            when salary*(1+nvl(commission_pct,0)) < 4000
            then salary*(1+nvl(commission_pct,0)) * 1.1
            when salary*(1+nvl(commission_pct,0)) < 10000
            then salary*(1+nvl(commission_pct,0)) * 1.07
            when salary*(1+nvl(commission_pct,0)) < 20000
            then salary*(1+nvl(commission_pct,0)) * 1.05
            else salary*(1+nvl(commission_pct,0)) * 1.02
        end �󿩱�
from employees;

-- ��
select employee_id ���, first_name �̸�, phone_number ��ȭ��ȣ, department_id �μ�, salary+salary*nvl(commission_pct,0) �޿�,
case
    when salary+ salary *nvl(commission_pct,0)  <4000 
    then (salary +(salary *nvl(commission_pct,0))) *(1.1)
    when salary+ salary *nvl(commission_pct,0)  <10000 
    then (salary +(salary *nvl(commission_pct,0))) *(1.07)
    when salary+ salary *nvl(commission_pct,0)  <20000 
    then (salary +(salary *nvl(commission_pct,0))) *(1.05)
    else (salary +(salary *nvl(commission_pct,0))) *(1.02)
end "�󿩱� ���Ա޿�"
from employees
order by �޿�;

-- 5. ������ �������� �ٹ������ ���ض� 
--"(����̸�)�� �ٹ������ (00)�� �Դϴ�."�� �������� ����϶� 
--concat�Լ� �̿�
select concat(first_name,
        concat('�� �ٹ������ ',
        concat(to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy'),'�� �Դϴ�.')))
from employees;

-- 6. �ٹ����߷�   
--job_id�� IT�� �����ϸ� '�Ǳ����߷�'
--         S           '�������߷�'
-- �� ��                'ȫ�����߷�'
--�����ȣ, �̸�, job_id �ٹ����߷��� ����϶�
select employee_id, first_name, job_id,
        case
            when upper(job_id) like 'IT%'
            then '�Ǳ����߷�'
            when upper(job_id) like 'S%'
            then '�������߷�'
            else 'ȫ�����߷�'
        end �ٹ����߷�
from employees
order by �ٹ����߷�;


-- 7.--'hello oracle !!!'��  hello HELLO ,oracle ORACLE �� �и����Ѷ�.
select 'hello oracle !!!'a,
        substr('hello oracle !!!', 1, instr('hello oracle !!!', ' ' , 1, 1)-1)b,
        substr('hello oracle !!!',
                instr('hello oracle !!!', ' ', 1, 1)+1,
                instr('hello oracle !!!', ' ', 1, 2) - instr('hello oracle !!!', ' ', 1,1)-1)c
from dual;

8.--����� 140�̸��� �ٺ�
--����� 180�̸��� ��û��
--����� 180�̻��� �˰�
--���, �̸�, ����, �˸�û�̷� ���
select employee_id, first_name, salary,
        case
            when employee_id < 140
            then '�ٺ�'
            when employee_id < 180
            then '��û��'
            else '�˰�'
        end �˸�û��
from employees;

-- 9. �ӱ��� 3�ڸ�(1000���ڸ�) ���� �ݿø��Ͽ� ǥ���Ͻÿ�
select round(salary, -3)
from employees;

-- 10. ��� ��ȭ ��ȣ�� .�� -���� �ٲ� ǥ���Ͻÿ�.




-- 2��

-- 1.�ڱⰡ �¾ ������ ������� ������ �������� ����غ���
select concat(trunc(sysdate - to_date('19890728','yyyymmdd'), 0),'�� ����')��,
        months_between(sysdate, to_date('19890728', 'yyyymmdd'))����
    
from dual;

-- 2.����ð��� ��Ÿ�����Ѵ�. ��, ������ �ִµ� ������ 
--	*'����ð��� ����(����) 00�� 00�� 00�� �Դϴ�.' �� ��µǾ������ϰ�
--	*12�� ������ ����, 12�� ���Ĵ� ���� �̴�.
--	*�� 20��, 40�� ���� '�ȳ��ϼ���.' ��� ����� �Ǿ��Ѵ�.
select case
            when to_char(sysdate, 'ss') = 20
            then '�ȳ��ϼ���.'
            when to_char(sysdate, 'ss') = 40
            then '�ȳ��ϼ���.'
            else ' '
        end �λ�,
        to_char(sysdate, 'am hh"�� "mi"�� "ss"�� �Դϴ�."')
from dual;


-- 3.����ID,����ID,����,����� ����Ͻÿ�.(�Ϲ�(ĳ����,�̱�)/������(����)/������(����))
--  ��Ī�� ���� ������ ������ �� ��
select location_id ����ID, country_id ����ID, city ����,
        case
            when country_id = 'DE'
            then '������'
            when country_id = 'UK'
            then '������'
            else '�Ϲ�'
        end ���
from locations;

select *
from countries;


-- 4.������ ID, �̸�, ��ȭ��ȣ, ��Ż縦 ����Ͻÿ�.
--  ������ ��ȭ��ȣ�� 5�� �����ϸ� ��Ż縦 SKT, 6���� �����ϸ� KT,0���� �����ϸ� LG �� �����Ͻÿ� 
--  ���� ��Ż� ���� �����Ͻÿ�.
select employee_id, first_name, phone_number,
        case
            when phone_number like '5%'
            then 'SKT'
            when phone_number like '6%'
            then 'KT'
            else 'LG'
        end ��Ż�
from employees
order by ��Ż�;


-- 5.�����ȣ, ����̸�, �Ի���,�Ի�� ��������¥,�Ի��� ���� �Ͽ����� ��¥, �Ի� �� 100���� ��¥�� �˻��϶�
select employee_id �����ȣ, first_name ����̸�, hire_date �Ի���, last_day(hire_date) "�Ի�� ����",
        next_day(hire_date, 1) "�Ի��� ���� �Ͽ���", hire_date +100 "�Ի� �� 100��"
from employees;


-- 6.������� �̸��� Ǯ�������� �ۼ��϶�(concat�̿��ϰ� �̸����̿� ����ֱ�)
select concat(first_name, concat(' ', last_name)) "full name"
from employees;


-- 7. �������
-- �Ի����� 1995�� ������ ����� ��,
-- �޿��� 5000 �̸��� ����� C
-- �޿��� 10000 �̸��� ����� B
-- �޿��� 10000 �̻��� ����� A
-- ������ȣ, �̸�, �Ի���, �޿�, ��������� ����϶�. ��������� ������������ �����϶�

select employee_id ������ȣ, first_name �̸�, hire_date �Ի���, salary �޿�,
        case
            when salary < 5000
            then 'C'
            when salary < 10000
            then 'B'
            else 'A'
        end �������
from employees
where to_char(hire_date, 'yyyy') >= 1995
order by ������� asc;


-- 8. �ټӳ���� ���ط� 20�� �̻� 25�� ������ ����鿡�� ���ʽ��� ������ �����̴�. ������ ���� �������� ���ʽ��� �����϶�.
-- �޿��� 5000 �̸��� ����� 30%
-- �޿��� 10000 �̸��� ����� 20%
-- �޿��� 10000 �̻��� ����� 10%
-- �޿��� Ŀ�̼��� ������ ������ ����ϸ�, �ټӳ���� �������� ����Ѵ�(��,���� ������� ����).
-- ������ȣ, �̸�, �Ի���, Ŀ�̼��� ������ �޿�, ���ʽ��� ����ϰ�, ���ʽ��� �������� �������� �����϶�.

select employee_id, first_name, hire_date, salary*(1+nvl(commission_pct,0)),
        case
            when salary*(1+nvl(commission_pct,0)) < 5000
            then salary*(1+nvl(commission_pct,0)) * 0.3
            when salary*(1+nvl(commission_pct,0)) < 10000
            then salary*(1+nvl(commission_pct,0)) * 0.2
            else salary*(1+nvl(commission_pct,0)) * 0.1
        end ���ʽ�
from employees
where (to_char(sysdate, 'yyyy') - to_char(hire_date, 'yyyy')) between 20 and 25
order by ���ʽ� desc;

9.-- ���� ��¥�� ������� ��������̶�� �����ϰ� ������� Ǯ���Ӱ� �������, ���糪�̴�(2019�� ����)�� ���Ͻÿ�. 
  -- ���̴�� 20�� 30�� 40��� ������ ��, �׸��� ��Ī�� '���̴�'�� ����
  -- �׸��� � ������� �������� ���� ������ ��

select concat(first_name, concat(' ', last_name)), hire_date,
        case
            when (2019 - to_char(hire_date, 'yyyy')) < 30
            then '20��'
            when (2019 - to_char(hire_date, 'yyyy')) < 40
            then '30��'
            else '40��'
        end ���̴�
from employees
order by ���̴� asc, hire_date;


-- 3��

1.
-- �� ����� �̸�, �μ���ȣ, �޿�, �޿��� ������ ����ϱ�
-- ��, ������ ������ ������ Job_Grades ���̺��� �����Ѵ�.
-- ��, ������ �������� �������� �����Ѵ�.
-- ��, ������ ��Ī�� �ش�(�޿��� ����).

2.
-- ���� A�� 2019��02��20�Ϻ��� 2019��07��16�ϱ��� ����� ��, �� �Ⱓ�� ��ĥ���� ���Ͻÿ�
-- ��, ��¥�� 20190220, 20190716 ������ ���ڷκ��� �����Ѵ�.
-- ��, �ָ��� �����Ѵ�
-- ��, ��Ī�� �����Ⱓ

3.
-- �μ���(department_name)�� ������ ���ڸ� �����ϰ� ����϶�.
-- �μ���, ���������ڸ� ������ �μ��� ��� �� ����)

4
-- emp���̺��� sal�� 3000�̸� �̸� c���, 3000���� 3900���� B���
-- 4000 �̻��̸� A������� ����� ��Ÿ�����
-- ���, �̸�(Ǯ����), �޿�, ��޺��� ����)

5.
--������� '�̸� ��'(concat�Լ� ���), ����, ����*Ŀ�̼� ��
(��, Ŀ�̼��� ���� ��� �ϰ������� 5%����, ���� ��� 0���� �ϰ� ������ ��)


6.
--. ������� ��ȭ��ȣ�� '.'�� '.'���̿� �ִ� 4�ڸ� ���� ����϶�

7.
--���,�̸�, job_id, �ٹ���Ȳ(��Ī)
--�̱����� ���ϴ� �μ��� ��� "����ٹ�"
--ĳ���ٿ��� ���ϴ� �μ��� ��� "�İ߱ٹ�"
--�������� ���ϴ� �μ��� ��� "�ؿ�����"
--����, �İ�, �ؿ� ������ ����
--�μ��ڵ尡 �����ÿ��� '����ٹ�'�� ���

8.
--�Ʒ��� ���� ��µǰ� �ڵ带 �ۼ��Ͻÿ�.
--'Ǯ����'�� �μ���ȣ�� �μ��ڵ�� '90''AD'
--�μ��� ����Ҷ��� job_id�� �� �α���(ex)ST,IT,AD)�� ���. ��Ī �μ���ȣ�� �ڵ�

9.
--��å�̸�, �ִ�޿�, ������ �ҵ�з��� ����Ͻÿ�.
--�̶� �ִ�޿��� 10000������ ������ ���ҵ�, 10000�� �ʰ�������20000������ ������ �߰��ҵ�, 20000�� �ʰ��ϴ� ������ ��ҵ����� ���Ͽ� ��å�з��� �����, ��å�̸��� �������� �����Ͻÿ�. �̶�, ��å�̸��� ��� �빮�ڷ� ǥ���Ͻÿ�.

10.
--���ó�¥�� yymmdd�������� ���ڷ� �ٲ��� ���ڷ� �ٽùٲ� 123456�� ���Ѱ��� ����϶�.

11.
--�ý��۽ð����� 144���ĸ� yyyy mm dd day ���·� ��Ÿ���ּ���. ��Ī�� "������"

12.
--2019/07/21 �� 2019�⵵�κ��� �� ��° ���ϱ�?



-- 4��

1. '-' �ΰ��϶� ������ �ڸ� ���ϴ� ���� ex) 010-1234-5678

2. ����� 100~199���� ����� ���, �̸�, �޿�, Ŀ�̼����Ա޿� ( 100�ڸ���ǥ��)


3. �����ȣ, �̸�, �޿�, Ŀ�̼����Ա޿�, Ŀ�̼����Ա޿��� ���� �޿������ ǥ�� (Ŀ�̼����Ա޿��� ��������)
 -- �޿������ job_grades ���̺��� ����


4.
-- phone_number ���� '.' �����ڰ� 3���� �ڵ�����ȣ, 2���� �� ��ȭ��ȣ ��� �����ϰ� 
   ����ȭ��ȣ�� �տ� '02.' �� �߰��ϰ�(concat ���) �ڵ�����ȣ�� �״�� �ΰ� ����Ѵ�.
-- ������� : ���, ��������ȣ, ����ȹ�ȣ, ����ȣ ����


5.
-- job_id �� ���� � ����ο��� ���ϴ��� �з��Ͽ���.(job_id �� '_' ������ ������ڵ�� �����ϸ� _�������� ��� ���ĺ��� ���� �� �� ����.)
-- ad : Administration
-- ac : Accounting
-- sa : Sales
-- st : Stock
-- it : It
-- mk : Marketing
-- �������� : ���, last_name(�̸�), job_id(�����ڵ�), �����
-- ������ �����, ��� ������ ��������


6.
-- �ټ��Ͽ� ���� Ŀ�̼� ��°� �ټӿ��� ���� �ӱݻ���� �Ϸ��� �Ѵ�.
-- Ŀ�̼ǻ���� �ټ��� 8õ�̸��� +1, 1���̸��� +2, �� �̻��� +3 (������ commission_pct ���ٸ� 0���� ����)
-- �ӱݻ���� 250�� �̸��� +1000 , 300�� �̸��� +2000, 350�� �̸��� +3000, 350�� �̻��� + 5000 �� �� ���� ���϶�.
-- ���, �Ի���, ���� Ŀ�̼�, ��µ�Ŀ�̼�, �����ӱ�, ��µ��ӱ� (���, �Ի��ϼ����� ��������)


7.
-- 1. ������ ���ǵ��� �����ϴ� "���" ���� ����ϼ��� (������������ ����)
-- 1) �μ� ��ȣ�� ���� ��� : Ǯ ����
-- 2) ������ ��ȣ�� ���� ��� : ��� ���� XXXX-YY-ZZ ��������
-- 3) Ŀ�̼��� �� �� �ִ� ��� : ���޿� Ŀ�̼��� �����Ͽ� ���� �ڸ����� �ݿø��ϰ� 5�ڸ��� ǥ�� (��, 5�ڸ� ���� ���� ��� ���� ó��)
------ 1), 2), 3) ������ �������� �ʴ� ��� --
-- 4) �̸��� 3������ ��� : ���� ��¥ �������� �ټ� ���
-- 5) IT�� �����ϴ� ������ ��� : ��ȭ��ȣ
------ 4), 5) ������ �������� �ʴ� ��� --
-- 6) ������� 80����� ��� : ������ 5�ڸ��� ǥ�� (��, 5�ڸ� ���� ���� ��� ���� ó��)
-- 7) �� ���� ��� : �̸���

