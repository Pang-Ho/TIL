select * from member;

desc member;

desc emp

drop table member cascade constraint;

select * from user_constraints where table_name = 'MEMBER';

create table member(
memberid varchar2(30) constraint member_id_pk primary key,
password number(5),
membername varchar2(30),
email varchar2(20) constraint member_email_ck check(email like '%@%')
);

insert into member values('member1', 1111, '박회원', 'park@mul.com');
insert into member values('member2', 2222, '김회원', 'kim@campus.com');
insert into member values('member3', 3333, '이회원', 'lee@campus.com');
insert into member values('member4', 4444, '장회원', 'jang@campus.com');
insert into member values('member5', 5555, '최회원', 'choi@campus.com');
commit;