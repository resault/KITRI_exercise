-- �����Լ�









select 1234.5438, round(1234.5438) round1, round(1234.5438, 0) round2,
        round(1234.5438, 1) round3 , round(1234.5438, -1) round4,
        round(1234.5438, 3) round5, round(1234.5438, -3) round6
from dual;

select 1234.5438, trunc(1234.5438) round1, trunc(1234.5438, 0) round2,
        trunc(1234.5438, 1) round3, trunc(1234.5438, -1) round4,
        trunc(1234.5438, 3) round5, trunc(1234.5438, -3) round6
from dual;

select 1234.5438, floor(1234.5438)
from dual;

select 5 + 3, 5 - 3, 5 * 3, 5 / 3, mod(5, 3)
from dual;

select abs(5), abs(-5), abs(+5)
from dual;

-- ����� ���, �̸�, �޿�, Ŀ�̼����Ա޿�
-- Ŀ�̼� ���� �޿��� 100�� �ڸ����� ǥ��(�ݿø�)
select employee_id ���, first_name �̸�, salary �޿�,
        round(salary*(1+nvl(commission_pct, 0)), -2) Ŀ�̼����Ա޿�
from employees;


-- �����Լ�

select 'kiTRi', lower('kiTRi'), upper('kiTRi'), initcap('kiTRi KKK'), length('kiTRi')
from dual;

-- full name
select employee_id, first_name, last_name,
        first_name || ' ' || last_name "full name",
        concat(first_name,concat(' ' , last_name)) concat
from employees;

select 'hello oracle !!!', 
        instr('hello oracle !!!', 'o') instr, instr('hello oracle !!!', 'o', 6) instr1
from dual;

-- 123-456, 123 zip1, 456 zip2 >>> 1234-56���� �ٲپ ����� ������
select '123-456' "zipcode",
        substr('123-456', 1,instr('123-456', '-')-1)zip1,
        substr('123-456', instr('123-456', '-')+1)zip2,
        '1234-56' "zipcode",
        substr('1234-56', 1,
        instr('1234-56', '-')-1)zip3,
        substr('1234-56', instr('1234-56', '-')+1)zip4
from dual;


-- ��¥�Լ�

select sysdate, sysdate + 3, sysdate -3,
        to_char(sysdate + 3 /24, 'yyyy-mm-dd hh24:mi:ss')
from dual;

select sysdate, months_between(sysdate, sysdate + 70)������,
        next_day(sysdate, 1)"���� �Ͽ���", next_day(sysdate, 3)"���� ȭ����",
        add_months(sysdate, 2)"2�� ��",
        last_day(sysdate)"������ ��"
from dual;

select sysdate, to_char(sysdate, 'yyyy') "4�ڸ�", to_char(sysdate, 'yy') "2�ڸ�",
        to_char(sysdate, 'mm') "��(����)",
        to_char(sysdate, 'mon') "��(����_���)", to_char(sysdate, 'month') "��(����)",
        to_char(sysdate, 'w') ����, to_char(sysdate, 'ww') ����_��,
        to_char(sysdate, 'd')"����_����",
        to_char(sysdate, 'dy')"����_�๮��", to_char(sysdate, 'day')"����_����", 
        to_char(sysdate, 'dd')����, to_char(sysdate, 'ddd')����_��
from dual;

select to_char(sysdate, 'hh')"12�ð���", to_char(sysdate, 'hh12')"12�ð���",
        to_char(sysdate, 'am hh')"����/���� �ð�", to_char(sysdate, 'pm hh')"����/���� �ð�",
        to_char(sysdate, 'hh24')"24�ð���",
        to_char(sysdate, 'mi')��, to_char(sysdate, 'ss')��
from dual;



select to_char(sysdate, 'yyyy.mm.dd hh24:mi:ss')a,
        to_char(round(sysdate), 'yyyy.mm.dd hh24:mi:ss')b, -- ���� �������� �ؼ� �ð����� �ݿø�
        to_char(round(sysdate, 'dd'), 'yyyy.mm.dd hh24:mi:ss')c, -- ���� ����
        to_char(round(sysdate, 'mm'), 'yyyy.mm.dd hh24:mi:ss')d, -- ���� �������� �ؼ� �Ͽ��� �ݿø�
        to_char(round(sysdate, 'yy'), 'yyyy.mm.dd hh24:mi:ss')e, -- ���� �������� �ؼ� ������ �ݿø�
        to_char(round(sysdate, 'hh'), 'yyyy.mm.dd hh24:mi:ss')f, -- �ø� �������� �ؼ� �п��� �ݿø�
        to_char(round(sysdate, 'mi'), 'yyyy.mm.dd hh24:mi:ss')g -- ���� �������� �ؼ� �ʿ��� �ݿø�
from dual
union
select to_char(sysdate, 'yyyy.mm.dd hh24:mi:ss')a,
        to_char(trunc(sysdate), 'yyyy.mm.dd hh24:mi:ss')b, -- ���� �������� �ؼ� �ð����� ����
        to_char(trunc(sysdate, 'dd'), 'yyyy.mm.dd hh24:mi:ss')c, -- ���� ����
        to_char(trunc(sysdate, 'mm'), 'yyyy.mm.dd hh24:mi:ss')d, -- ���� �������� �ؼ� �Ͽ��� ����
        to_char(trunc(sysdate, 'yy'), 'yyyy.mm.dd hh24:mi:ss')e, -- ���� �������� �ؼ� ������ ����
        to_char(trunc(sysdate, 'hh'), 'yyyy.mm.dd hh24:mi:ss')f, -- �ø� �������� �ؼ� �п��� ����
        to_char(trunc(sysdate, 'mi'), 'yyyy.mm.dd hh24:mi:ss')g -- ���� �������� �ؼ� �ʿ��� ����
from dual;



-- ��ȯ�Լ�

select 'a', 3, '3', 3 + 5, '3' + 5
from dual;

select 1123456.789,
        to_char(1123456.789, '000,000,000.00')a,
        to_char(1123456.789, '999,999,999.99')b, -- �鸸���� �տ� ���� �ΰ��� �ִ� ����!
        length(to_char(1123456.789, '000,000,000.00'))c,
        length(to_char(1123456.789, '999,999,999.99'))d,
        to_char(1123456.789, '$999,999,999.99')e
from dual;

select to_char(-12, '99pr'), to_char(-12, '99mi')
from dual;

select '123,456.98', to_number('123,456.98', '000,000.00') + 3 a -- �μ�2�� ���´� �μ�1�� �����ؾ� ��.
from dual;

select sysdate, to_char(sysdate, 'yy.mm.dd')a,
        to_char(sysdate, 'am hh:mi:ss')b,
        to_char(sysdate, 'hh24:mi:ss')c
from dual;


-- 20190225142154 >> ��¥ >> 3�� �� (����: 2/28)
select to_char( (to_date(to_char(20190225142154, '00000000000000') ,'yyyy.mm.dd hh24:mi:ss'))+3, 'yyyy.mm.dd hh:mi:ss')
from dual;

select to_char( (to_date(to_char(20190225142154, '00000000000000') ,'yyyymmddhh24miss'))+3, 'yyyy.mm.dd hh:mi:ss')
from dual;

    -- ���� ���������� ���ص� �ڵ���ȯ��. ����
select to_char(20190225142154)
from dual;

    -- �ڵ�����ȯ�� ����� ������. ����
select to_date(20190225142154,'yyyy.mm.dd hh24:mi:ss')
from dual;




-- �Ϲ��Լ�

select commission_pct, nvl(commission_pct, 0), nvl2(commission_pct, 1, 0)
from employees;

-- �������
-- �޿��� 4000 �̸��� ����� ������
-- �޿��� 10000 �̸��� ����� ��տ���
-- �޿��� 10000 �̻��� ����� ����
-- ���, �̸�, �޿�, �������

select employee_id, first_name, salary,
        case
            when salary < 4000
            then '������'
            when salary < 10000
            then '��տ���'
            else '����'
        end �������
from employees
order by salary desc;


-- �������
-- 1980�⵵ �Ի� �ӿ�
-- 1990�⵵ �Ի� ����
-- 2000�⵵ �Ի� ���Ի��
-- ���, �̸�, �Ի���, �������

select employee_id ���, first_name �̸�, hire_date �Ի���,
        case
            when to_char(hire_date, 'yyyy') < '1990'
            then '�ӿ�'
            when to_char(hire_date, 'yyyy') < '2000'
            then '����'
            else '���Ի��'
        end �������
from employees;

select employee_id ���, first_name �̸�, hire_date �Ի���,
        case
            when to_char(hire_date, 'yyyy') < 1990  -- �ƽ�Ű �ڵ尪�� ���� �񱳿����� ������
            then '�ӿ�'
            when to_char(hire_date, 'yyyy') < 2000
            then '����'
            else '���Ի��'
        end �������
from employees;

select employee_id ���, first_name �̸�, hire_date �Ի���,
        case
            when to_number(to_char(hire_date, 'yyyy'), '0000') < 1990
            then '�ӿ�'
            when to_number(to_char(hire_date, 'yyyy'), '0000') < 2000
            then '����'
            else '���Ի��'
        end �������
from employees;


select employee_id ���, first_name �̸�, hire_date �Ի���,
        case
            when substr(to_char(trunc(hire_date, 'yyyy'), 'yyyy'), 1, 3) = '198'
            then '�ӿ�'
            when substr(to_char(trunc(hire_date, 'yyyy'), 'yyyy'), 1, 3) = '199'
            then '����'
            else '���Ի��'
        end �������
from employees;



-- ������ ��

select case when 'a' < 'b' then '�۴�'
            else 'ũ��'
        end
from dual;

select case when 'abc' < 'abe' then '�۴�'
            else 'ũ��'
        end
from dual;

-- �ϱ��� ��
select ascii('0'), ascii('A'), ascii('a'), chr('48')
from dual;