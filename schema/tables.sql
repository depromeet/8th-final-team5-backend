CREATE DATABASE dodo;

-- TABLE
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

-- INDEX
CREATE INDEX IDX_USER_PET ON User (petId);
CREATE INDEX IDX_USER_LOCATION ON User (locationId);

CREATE INDEX IDX_PROFILE_PET ON PetProfile (petId);
CREATE INDEX IDX_PROFILE_USER ON UserProfile (userId);

CREATE INDEX IDX_BREED_PET ON PetBreed (petId);
CREATE INDEX IDX_CHARACTER_PET ON PetCharacter (petId);
CREATE INDEX IDX_INTEREST_PET ON PetInterest (petId);
