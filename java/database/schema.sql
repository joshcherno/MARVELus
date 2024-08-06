BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE comic (
    comic_id varchar(50),
    comic_title varchar(100),
    comic_author varchar(50),
    description varchar(250),
    release_date date,
    cover_url varchar(100),
    CONSTRAINT PK_comic_id PRIMARY KEY (comic_id)
);
--CREATE TABLE collection (
--    collection_id SERIAL,
--    collection_name varchar(50),
--    collection_description varchar(250)
--    ) TODO collection and comicCollection table

CREATE TABLE collection_comics (
    collection_comic_id varchar(50) NOT NULL,
    collection_id int NOT NULL,
    comic_id int NOT NULL,
    added_date date NOT NULL,
    CONSTRAINT PK_comic PRIMARY KEY (comic_id)
);



COMMIT TRANSACTION;
