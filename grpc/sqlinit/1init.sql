CREATE TABLE artist
(
	id int PRIMARY KEY generated always as identity,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(30) NOT NULL
);

CREATE TABLE pictures
(
	id int PRIMARY KEY generated always as identity,
	name VARCHAR(100) NOT NULL UNIQUE,
	artist_id int NOT NULL REFERENCES artist
);
