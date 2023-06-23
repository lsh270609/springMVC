create table board_info_table(
    board_info_idx number constraint BOARD_INFO_PK primary key,
    board_info_name varchar2(100) not null
);

-- create sequence table_seq start with 1 increment by 1 minvalue 0;

insert into board_info_table values(1, '자유게시판');
insert into board_info_table values(2, '유머게시판');
insert into board_info_table values(3, '정치게시판');
insert into board_info_table values(4, '스포츠게시판');

select * from board_info_table order by board_info_idx;


create table user_table(
    user_idx number constraint USER_PK primary key,
    user_name varchar2(50) not null,
    user_id varchar2(100) not null unique,
    user_pw varchar2(100) not null
);

create sequence user_seq start with 0 increment by 1 MINVALUE 0;


create table content_table(
    content_idx number constraint CONTENT_PK primary key,
    content_subject varchar2(500) not null,
    content_text long not null,
    content_file varchar2(500),
    content_writer_idx number not null, 
    content_board_idx number not null,
    content_date date not null,
    constraint content_fk1 foreign key(content_writer_idx) references user_table(user_idx),
    constraint content_fk2 foreign key(content_board_idx) references board_info_table(board_info_idx)
);

create sequence content_seq start with 0 increment by 1 minvalue 0;

commit;