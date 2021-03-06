DROP TABLE repboard;
CREATE TABLE repboard (
 BOARD_SEQ              NUMBER(10)  primary key,
 PARENT_SEQ             NUMBER(10),  /** 원글인 경우:0, 답글인 경우:원글번호 **/
 BOARD_SUBJECT        VARCHAR2(255),
 BOARD_WRITER          VARCHAR2(100),
 BOARD_CONTENTS     VARCHAR2(4000),
 BOARD_DATE            TIMESTAMP(6),
 BOARD_PASSWORD    VARCHAR2(20),
 BOARD_VIEWCOUNT    NUMBER(6)
);

DELETE FROM repboard;
COMMIT;

insert into repboard values(1, 0, '1', '1', '1', systimestamp, '1', 0); 

insert into repboard values(2, 0, '2', '2', '2', systimestamp, '2', 0);

insert into repboard values(3, 1, '1-r1', '1-r1', '1-r1', systimestamp, '1-r1', 0);

insert into repboard values(4, 2, '2-r1', '2-r1', '2-r1', systimestamp, '2-r1', 0);

insert into repboard values(5, 0, '3', '3', '3', systimestamp, '3', 0);

insert into repboard values(6, 4, '2-r1-r1', '2-r1-r1', '2-r1-r1', systimestamp, '2-r1-r1', 0);

insert into repboard values(7, 2, '2-r2', '2-r2', '2-r2', systimestamp, '2-r2', 0);

insert into repboard values(8, 1, '1-r2', '1-r2', '1-r2', systimestamp, '1-r2', 0);
COMMIT;


-- 페이지별 글 가져오기
select *
from (select rownum r, board_seq, parent_seq, to_char(board_date, 'hh:mm:ss') d
        from repboard
        start with parent_seq = 0
        connect by prior board_seq = parent_seq
        order siblings by board_seq desc
)
where r between 5 and 8;

-- 시퀀스 추가
create sequence board_seq
start with 9;
