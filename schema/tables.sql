
CREATE DATABASE dodo;

CREATE TABLE User
(
	id int auto_increment,
	username varchar(100) not null,
	gender varchar(10) null,
	age int null,
	address varchar(200) null,
	introduce varchar(200) null,
	constraint User_pk
		primary key (id)
);

CREATE TABLE pet
(
	id int auto_increment,
	name varchar(50) not null,
	gender varchar(10) not null,
	age int not null,
	breed varchar(50) not null,
	fixing boolean not null,
	vaccination boolean not null,
	constraint pet_pk
		primary key (id)
);
