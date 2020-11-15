
CREATE DATABASE dodo;

create table User
(
	id bigint auto_increment primary key,
	uid varchar(100) null,
	username varchar(100) not null,
	gender varchar(10) not null,
	age int not null,
	address varchar(200) null,
	introduce varchar(200) null,
	profileImageUrl varchar(500) null,
	petId bigint not null,
	constraint uid
		unique (uid)
);

CREATE TABLE Pet
(
	id bigint auto_increment,
	name varchar(50) not null,
	gender varchar(10) not null,
	age int not null,
	breed varchar(50) not null,
	fixing boolean not null,
	vaccination boolean not null,
	constraint pet_pk
		primary key (id)
);
