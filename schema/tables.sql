
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
	locationId bigint,
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

CREATE TABLE Breed
(
    id bigint auto_increment primary key,
    breed varchar(50)
);

CREATE TABLE Character
(
    id bigint auto_increment primary key,
    character varchar(50)
);


CREATE TABLE Interest
(
    id bigint auto_increment primary key,
    interest varchar(50)
);

CREATE TABLE PetBreed
(
    id bigint auto_increment primary key,
    petId bigint not null,
    breedId bigint not null
);

CREATE TABLE PetCharacter
(
    id bigint auto_increment primary key,
    petId bigint not null,
    characterId bigint not null
);


CREATE TABLE PetInterest
(
    id bigint auto_increment primary key,
    petId bigint not null,
    interestId bigint not null
);

CREATE TABLE Image
(
    id bigint auto_increment primary key,
    filePath varchar(100) not null,
    fileName varchar(100) not null
);

CREATE TABLE PetProfile
(
    id bigint auto_increment primary key,
    imageId bigint not null,
    petId bigint not null,
    priority int not null
);

CREATE TABLE UserProfile
(
    id bigint auto_increment primary key,
    imageId bigint not null,
    userId bigint not null
);

CREATE TABLE Location
(
    id bigint auto_increment primary key,
    point point not null,
    addressName varchar(100) not null,
    region3DepthName varchar(100) not null
);


-- Breed insert
INSERT INTO Breed(breed) VALUES('말티즈');
INSERT INTO Breed(breed) VALUES('포메라니안');
INSERT INTO Breed(breed) VALUES('진돗개');
INSERT INTO Breed(breed) VALUES('골든리트리버');
INSERT INTO Breed(breed) VALUES('치와와');
INSERT INTO Breed(breed) VALUES('비글');
INSERT INTO Breed(breed) VALUES('말티즈');
INSERT INTO Breed(breed) VALUES('비숑 프리제');

-- Character insert
INSERT INTO Charact(charact) VALUES('적극적');
INSERT INTO Charact(charact) VALUES('소극적');
INSERT INTO Charact(charact) VALUES('활발함');
INSERT INTO Charact(charact) VALUES('예민함');
INSERT INTO Charact(charact) VALUES('겁쟁이');
INSERT INTO Charact(charact) VALUES('사교적인');
INSERT INTO Charact(charact) VALUES('사나움');
INSERT INTO Charact(charact) VALUES('에너자이저');
INSERT INTO Charact(charact) VALUES('시크함');
INSERT INTO Charact(charact) VALUES('고집쟁이');
INSERT INTO Charact(charact) VALUES('젠틀함');
INSERT INTO Charact(charact) VALUES('영리함');

-- Interest insert
INSERT INTO Interest(interest) VALUES('산첵');
INSERT INTO Interest(interest) VALUES('공놀이');
INSERT INTO Interest(interest) VALUES('다이어트');
INSERT INTO Interest(interest) VALUES('건강');
INSERT INTO Interest(interest) VALUES('간식');
INSERT INTO Interest(interest) VALUES('수영');
INSERT INTO Interest(interest) VALUES('패션');
INSERT INTO Interest(interest) VALUES('애견카페');
INSERT INTO Interest(interest) VALUES('낮잠');
INSERT INTO Interest(interest) VALUES('미용');
INSERT INTO Interest(interest) VALUES('훈련');
INSERT INTO Interest(interest) VALUES('드라이브');
INSERT INTO Interest(interest) VALUES('이성친구');
