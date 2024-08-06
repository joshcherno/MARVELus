BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS comic;
DROP TABLE IF EXISTS collection;
DROP TABLE IF EXISTS collection_comics;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE comic (
    comic_id int,
    comic_title varchar(100) NOT NULL,
    comic_author varchar(50),
    description varchar(250),
    release_date date,
    cover_url varchar(100),
    CONSTRAINT PK_comic_id PRIMARY KEY (comic_id)
);
CREATE TABLE collection (
   collection_id SERIAL,
   collection_name varchar(50),
   collection_description varchar(250),
   user_id int,
   comic_id int,
   CONSTRAINT PK_collection_id PRIMARY KEY (collection_id)

);
CREATE TABLE collection_comics (
    collection_id int NOT NULL,
    comic_id int NOT NULL,
    CONSTRAINT FK_collection_comics_comic FOREIGN KEY (comic_id) REFERENCES comic (comic_id),
    CONSTRAINT FK_collection_comics_collection FOREIGN KEY (collection_id) REFERENCES collection (collection_id)
);
COMMIT TRANSACTION;
