drop table Complaint cascade constraint;

create table Complaint(
Id number(8),
CustomerName varchar2(20),
AccountId number(8),
Cateogary varchar2(20),
ComplaintDate date,
Description varchar2(300),
Priority varchar2(10),
Status varchar2(10),
primary key (id)
);
create sequence complaintId_seq start with 1000;