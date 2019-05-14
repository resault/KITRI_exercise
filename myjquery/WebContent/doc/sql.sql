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