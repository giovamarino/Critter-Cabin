BEGIN TRANSACTION;

DROP TABLE IF EXISTS volunteers, users, adopter, pets;

CREATE TABLE volunteers  (
application_id SERIAL,
first_name varchar(100) NOT NULL,
last_name varchar(100) NOT NULL,
email varchar(50) NOT NULL,
over_18 boolean NOT NULL,
veterinary boolean NOT NULL,
cleaning boolean NOT NULL,
data_entry boolean NOT NULL,
photography boolean NOT NULL,
status varchar(15) NOT NULL,
CONSTRAINT PK_volunteers PRIMARY KEY (application_id)
);

CREATE TABLE users (
   user_id SERIAL,
   username varchar(50) NOT NULL UNIQUE,
   password_hash varchar(200) NOT NULL,
   first_time boolean NOT NULL,
   role varchar(10) NOT NULL,
   application_id int,
   CONSTRAINT PK_user PRIMARY KEY (user_id),
   CONSTRAINT FK_user FOREIGN KEY (application_id) REFERENCES volunteers (application_id)
);

CREATE TABLE adopter (
adopter_id SERIAL,
adopter_name varchar(100) NOT NULL,
email varchar(100) NOT NULL,
phone_number varchar(10),
city varchar(50),
state varchar(2),
zipcode varchar(10),
any_pets boolean NOT NULL,
number_pets int,
status varchar(15) NOT NULL,
CONSTRAINT PK_adopter PRIMARY KEY (adopter_id)
);

CREATE TABLE pets (
pet_id SERIAL,
pet_image varchar(500),
name varchar(70) NOT NULL,
type varchar(70) NOT NULL,
age int NOT NULL,
gender varchar(70) NOT NULL,
weight int NOT NULL,
breed varchar(70) NOT NULL,
description varchar(1000) NOT NULL,
adopted boolean NOT NULL,
adopter_id int,
CONSTRAINT PK_pets PRIMARY KEY (pet_id),
CONSTRAINT FK_pets FOREIGN KEY (adopter_id) REFERENCES adopter (adopter_id)
);

CREATE TABLE pet_images (
	image_id SERIAL,
	pet_image varchar(500) NOT NULL,
	is_primary boolean NOT NULL,
	pet_id int,
	CONSTRAINT PK_image PRIMARY KEY (image_id),
	CONSTRAINT FK_pet_id FOREIGN KEY (pet_id) REFERENCES pets (pet_id)
);

COMMIT TRANSACTION;
