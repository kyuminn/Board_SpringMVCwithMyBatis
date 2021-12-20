System 계정에서
create user tester4 identified by 1234;
grant resource,connect to tester4;
commit;
============================

tester4 계정에서

create sequence board_seq start with 1 increment by 1 minvalue 1 maxvalue 99999;
create table board(
    seq int primary key,
    title varchar2(255) not null,
    content varchar2(1000) not null,
    writer varchar2(50) not null,
    password int not null,
    regdate timestamp not null,
    cnt int not null);

commit;

insert into board (seq,title,content,writer,password,regdate,cnt) values (board_seq.nextval,'t1','c1','w1',1234, '2021-10-10 14:21:12',1);
insert into board (seq,title,content,writer,password,regdate,cnt) values (board_seq.nextval,'t2','c2','w2',1234, '2021-10-10 14:21:12',2);
insert into board (seq,title,content,writer,password,regdate,cnt) values (board_seq.nextval,'t3','c3','w3',1234, '2021-10-10 14:21:12',3);
insert into board (seq,title,content,writer,password,regdate,cnt) values (board_seq.nextval,'t4','c4','w4',1234, '2021-10-10 14:21:12',4);
commit;