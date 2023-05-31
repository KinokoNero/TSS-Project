drop table if exists City;
create table Animal (
id bigint auto_increment primary key,
species varchar(50) not null,
name varchar(50) not null,
age int not null,
weight decimal not null,
diet varchar(9) not null
);