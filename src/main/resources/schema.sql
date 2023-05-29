drop table if exists City;
create table City (
id bigint auto_increment primary key,
name varchar(50) not null,
pincode int not null,
population bigint
);

--TODO: make a different table