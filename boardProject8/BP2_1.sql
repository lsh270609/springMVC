select * from user_table;

select * from board_info_table;

select a.*, b.user_name as content_writer_name from content_table a, user_table b WHERE CONTENT_BOARD_IDX=3 and a.content_writer_idx = b.user_idx;

SELECT TO_CHAR(CONTENT_DATE, 'YYYY/MM/DD HH:MI:SS') FROM CONTENT_TABLE;
DESC content_table;

select * from tabs;

SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MI:SS') DATE1 FROM DUAL;