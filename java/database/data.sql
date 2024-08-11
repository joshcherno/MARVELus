BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO comic (comic_id, comic_title, cover_url) VALUES ('109647', 'AMAZING SPIDER-MAN BY ZEB WELLS VOL. 10: BREATHE TPB (Trade Paperback)', 'http://i.annihil.us/u/prod/marvel/i/mg/1/60/664f656557b29.jpg');
INSERT INTO collection (collection_name,collection_description,user_id) VALUES ('Spiderman Comics','A collection full of Spiderman comics','1');

--INSERT INTO comic (comic_id, comic_title, comic_author, description, release_date, cover_url) VALUES
--INSERT INTO comic (comic_id, comic_title, comic_author, description, release_date, cover_url) VALUES
--INSERT INTO comic (comic_id, comic_title, comic_author, description, release_date, cover_url) VALUES
--INSERT INTO comic (comic_id, comic_title, comic_author, description, release_date, cover_url) VALUES

COMMIT TRANSACTION;
