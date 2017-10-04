drop table trainee cascade constraints;


create table trainee(
traineeid number primary key,
traineename varchar2(40) ,
traineelocation varchar2(20),
traineedomain varchar2(20)
);

insert into trainee values(1,'Ashutosh Gupta','Mumbai','JEE');
insert into trainee values(2,'Vivek Gupta','Chennai','DOT-NET');
insert into trainee values(3,'Mayur Mishra','Delhi','SAP');

select * from trainee;