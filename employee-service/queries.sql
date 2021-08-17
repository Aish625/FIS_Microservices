use test;

create table skill(
sk_id int,
sk_name varchar(45)
);

create table employee_skill(
es_em_id int,
es_sk_id int);

create table employee(
em_id int,
em_name varchar(25),
em_salary double,
em_permanent boolean,
em_date_of_birth date,
em_dp_id int);

create table department(
dp_id int,
dp_name varchar(25)
);
