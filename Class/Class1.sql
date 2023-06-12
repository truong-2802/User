

create table Class(
Code_class varchar(255) primary key ,
Name varchar(255),
Room varchar(20),
Start_day datetime,
End_date datetime
)

create table Course(
Key_code varchar(255),
Name varchar(255),
Describe text,
Course_class varchar(255) not null REFERENCES Class(Code_class)
)

create table Students(
Code_student varchar(255),
Name varchar(255),
Address varchar(255),
Email varchar(255),
Phone varchar(20),
Register varchar(255) not null references Class(Code_class)
)

create table Teacher(
Code_teacher varchar(255),
Name varchar(255),
Address varchar(255),
Email varchar(255),
Teaching_class varchar(255) not null REFERENCES Class(Code_class)
)


insert into Class(Code_class,Name,Room,Start_day,End_date)
values ('CST021','EL1','C03',2023-01-23,2023-07-23),
('CST022','EL2','C05',2022-10-10,2023-02-22),
('CST029','EL3','C08',2023-03-25,2023-10-20)
select *FROM Class;


insert into Course(Key_code,Name,Describe,Course_class)
values ('communicate','CLK','very good','CST021'),
('ielts','SDH','very good','CST022'),
('toeic','KLI','very good','CST029')
select * From Course;


insert into Students(Code_student,Name,Address,Email,Phone,Register)
values ('ST1','Vinh',' Vinh Phuc','Vinh@gmail.com','0321659874','CST021'),
('ST2','Ha','Vinh','Ha@gmail.com','0965321487','CST021'),
('ST3','Vu','Hue','Vu@gmail.com','0936251874','CST029')
select *FROM Students;


insert into Teacher(Code_teacher,Name,Address,Email,Teaching_class)
values ( 'TC1','Ly','Ha Noi','Ly@gmail.com','CST021'),
( 'TC2','Hien','HCM','Hien@gmail.com','CST022'),
( 'TC3','Anh','Ha Noi','Anh@gmail.com','CST029')
select * FROM Teacher;



