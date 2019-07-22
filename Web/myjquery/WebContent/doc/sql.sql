
-- 회원정보
drop TABLE customer;


create table customer (
    id varchar2(16),
    pass varchar2(16),
    name varchar2(30),
    address varchar2(100),
    constraint customet_pk PRIMARY KEY(id)
);



commit;

insert into customer(id, pass, name)
values ('test', 'testp', '테스트');

select * from customer;



-- 상품

--** 상품분류(PRODUCT_CATEGORY) TABLE (부모엔터티) **

-- 컬럼
-- (PK)분류번호[CATE_NO] : CHAR(1)
-- (NN)분류명[CATE_NAME] : VARCHAR2(30)

-- DATA
-- D, 음료
-- F, 음식
-- G, 상품


-- ** 상품목록(PRODUCT) TABLE (자식엔터티) **

-- 컬럼
-- (PK)상품번호[PROD_NO] : VARCHAR2(5)
-- (NN)상품명[PROD_NAME]: VARCHAR2(30)
-- (NN, CHK(>=0))가격[PROD_PRICE]: NUMBER(5)
-- 상세정보[PROD_DETAIL]: VARCHAR2(50)
-- (FK,NN)상품분류[PROD_CATE]

-- DATA
--001, 아메리카노, D, 2500, ...
--002, 아이스아메리카노, D, 2500, ...
--003, 라테, D, 3000, ...
--004, 치즈케이크, F, 4000, ...




create table PRODUCT_CATEGORY (
    CATE_NO CHAR(1),
    CATE_NAME VARCHAR2(30) NOT NULL
);


create table PRODUCT (
    PROD_NO VARCHAR2(5),
    PROD_NAME VARCHAR2(30) NOT NULL,
    PROD_PRICE NUMBER(5) NOT NULL CHECK (PROD_PRICE >= 0),
    PROD_DETAIL VARCHAR2(50),
    PROD_CATE NOT NULL
    constraint PRODUCT_PK PRIMARY KEY(PROD_NO)
);


ALTER TABLE PRODUCT
	ADD
		CONSTRAINT FK_PRODUCT_CATEGORY_TO_PRODUCT
		FOREIGN KEY (
			PROD_CATE
		)
		REFERENCES PRODUCT_CATEGORY (
			PROD_CATE
		);

ALTER TABLE PRODUCT
	ADD
		CONSTRAINT PRODUCT_PK
		PRIMARY KEY (
			PROD_NO
		);

ALTER TABLE PRODUCT_CATEGORY
	ADD
		CONSTRAINT PRODUCT_CATEGORY_PK
		PRIMARY KEY (
			CATE_NO
		);


		
INSERT INTO PRODUCT_CATEGORY (CATE_NO, CATE_NAME)
VALUES ('D', '음료');

INSERT INTO PRODUCT_CATEGORY (CATE_NO, CATE_NAME)
VALUES ('F', '음식');

INSERT INTO PRODUCT_CATEGORY (CATE_NO, CATE_NAME)
VALUES ('G', '상품');

INSERT INTO PRODUCT(PROD_NO, PROD_NAME, PROD_PRICE, PROD_DETAIL, PROD_CATE)
VALUES ('001', '아메리카노', 2500, '', 'D');

INSERT INTO PRODUCT(PROD_NO, PROD_NAME, PROD_PRICE, PROD_DETAIL, PROD_CATE)
VALUES ('002', '아이스아메리카노', 2500, '', 'D');

INSERT INTO PRODUCT(PROD_NO, PROD_NAME, PROD_PRICE, PROD_DETAIL, PROD_CATE)
VALUES ('003', '라테', 3000, '', 'D');

INSERT INTO PRODUCT(PROD_NO, PROD_NAME, PROD_PRICE, PROD_DETAIL, PROD_CATE)
VALUES ('004', '치즈케이크', 4000, '', 'F');



-- select *
select cate_no, cate_name, prod_no, prod_name, prod_price, prod_detail
from product p join product_category pc
on p.prod_cate = pc.cate_no
order by cate_no, prod_name;

-- D카테고리에 해당 상품목록
select cate_no, cate_name, pro_co, prod_name, prod_price, prod_detail
from product p join product_category pc
on p.prod_cate = pc.cate_no
where cate_no = 'D'
order by cate_no, prod_name;


-- D카테고리에 해당 총상품가격을 출력하시오
select sum(prod_price)
from product p join product_category pc
on p.prod_cate = pc.cate_no
where cate_no = 'D';


-- 카테고리별 총상품가격을 출력하시오
select cate_no, sum(prod_price)
from product p join product_category pc
on p.prod_cate = pc.cate_no
group by cate_no;





-- 주문 기본 테이블 (ORDER_INFO)
-- (PK) 주문번호[ORDER_NO] : NUMBER
-- 주문자ID[ORDER_ID] : 
-- 주문시간[ORDER_DT] : DATE  /  DEFAULT: SYSDATE
drop table order_info;
drop table order_LINE;

commit;


create table ORDER_INFO (
	ORDER_NO NUMBER,
	ORDER_ID VARCHAR2(16),
	ORDER_DT DATE DEFAULT sysdate,
	CONSTRAINT ORDER_INFO_PK PRIMARY KEY(ORDER_NO),
	CONSTRAINT ORDER_ID_FK FOREIGN KEY(ORDER_ID) REFERENCES CUSTOMER(ID)
);

        
select * from order_info;
select * from order_line;

CREATE SEQUENCE ORDER_SEQ
START WITH 0 
INCREMENT BY 1 NOMAXVALUE MINVALUE 0;

drop SEQUENCE order_seq;




-- 주문 기본 테이블 (ORDER_LINE)
-- 주문번호[ORDER_NO] : 
-- 주문상품번호[ORDER_PROD_NO] : 
-- 주문수량[ORDER_QUANTITY] : 

CREATE TABLE ORDER_LINE (
	ORDER_NO NUMBER,
	ORDER_PROD_NO VARCHAR(5),
	ORDER_QUANTITY NUMBER(2),
	CONSTRAINT ORDER_LINE_PK PRIMARY KEY(ORDER_NO, ORDER_PROD_NO),
	CONSTRAINT ORDER_NO_FK FOREIGN KEY(ORDER_NO) REFERENCES ORDER_INFO(ORDER_NO),
	CONSTRAINT ORDER_PROD_NO_FK FOREIGN KEY(ORDER_PROD_NO) REFERENCES PRODUCT(PROD_NO)
);




INSERT INTO ORDER_INFO(ORDER_NO, ORDER_ID)
VALUES (ORDER_SEQ.NEXTVAL, 'test');

-- 시퀀스의 CURRVAL를 사용하려면, 같은 커넥션 안에서 NEXTVAL 후 CURRVAL 사용해야 함
INSERT INTO ORDER_LINE(ORDER_NO, ORDER_PROD_NO, ORDER_QUANTITY)
VALUES (ORDER_SEQ.CURRVAL, '003', 1);	
INSERT INTO ORDER_LINE(ORDER_NO, ORDER_PROD_NO, ORDER_QUANTITY)
VALUES (ORDER_SEQ.CURRVAL, '002', 2);	



-- id 주문내역 보기
select info.order_no, order_dt, prod_no, prod_name, prod_price, order_quantity
from order_info info join order_line line
on info.order_no = line.order_no
join product p
on line.order_prod_no = p.prod_no
where order_id = 'test'
order by order_dt desc, prod_no;

