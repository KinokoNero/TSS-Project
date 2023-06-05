create table if not exists Animal (
id bigint auto_increment primary key,
species varchar(50) not null,
name varchar(50) not null,
sex varchar(6) not null,
age int not null,
weight float not null,
diet varchar(9) not null
);