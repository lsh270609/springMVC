select * from user_table;

select * from board_info_table;
select board_info_idx from board_info_table;
desc board_info_table;

select a.content_idx, a.content_subject, b.user_name as content_writer_name, TO_CHAR(a.content_date, 'YYYY/MM/DD HH24:MI:SS') as content_date from content_table a, user_table b WHERE CONTENT_BOARD_IDX=2 and a.content_writer_idx = b.user_idx order by content_idx desc;

select a.content_idx, a.content_subject, b.user_name as content_writer_name, TO_CHAR(a.content_date, 'YYYY/MM/DD HH24:MI:SS') as content_date from content_table a, user_table b WHERE a.content_writer_idx = b.user_idx order by content_idx desc;

select a.*, b.user_name as content_writer_name from content_table a, user_table b WHERE CONTENT_BOARD_IDX=2 and a.content_writer_idx = b.user_idx;

select b.user_name as content_writer_name, TO_CHAR(a.content_date, 'YYYY/MM/DD HH24:MI:SS') as content_date, a.content_subject, a.content_text, a.content_file
  from content_table a, user_table b 
 WHERE a.content_idx = 1
   and a.content_writer_idx = b.user_idx
;

select * from content_table order by content_idx asc;
truncate table content_table;
drop sequence content_seq;
create sequence content_seq start with 0 increment by 1 minvalue 0;
create sequence content_seq start with 1 increment by 1 minvalue 1;
select content_seq.currval from dual;

SELECT TO_CHAR(CONTENT_DATE, 'YYYY/MM/DD HH:MI:SS') FROM CONTENT_TABLE;
DESC content_table;

select * from tabs;

SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MI:SS') DATE1 FROM DUAL;


update content_table set content_subject='22', content_text='22', content_file='1687845054871_m.jpg' where content_idx=0;
delete from content_table where content_idx = 1;

select * from content_table order by content_idx desc;

-- 전체 글 개수
select count(*) as contentCnt from content_table where content_board_idx = 1;