create table spring_test(
    data1 varchar2(100) not null,
    data2 varchar2(100) not null,
    data3 varchar2(100) not null
);

desc spring_test;

insert into spring_test values('더조은', '아카데미', '학원');

select * from spring_test;
commit;