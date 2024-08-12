BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO comic (comic_id, comic_title, cover_url) VALUES ('109647', 'AMAZING SPIDER-MAN BY ZEB WELLS VOL. 10: BREATHE TPB (Trade Paperback)', 'http://i.annihil.us/u/prod/marvel/i/mg/1/60/664f656557b29.jpg');
INSERT INTO collection (collection_name,collection_description,user_id) VALUES ('Spiderman Comics','A collection full of Spiderman comics','1');

INSERT INTO comic (comic_id, comic_title, description, cover_url) VALUES ('115082','Spider-Gwen: The Ghost-Spider (2024) #4','A FRESH START? Artist Paolo Villanelli (BLack Widow & Hawkeye) reunites with writer Stephanie Phillips as Gwen faces off with a classic 616 villain! Faces will come off.','http://i.annihil.us/u/prod/marvel/i/mg/4/10/66b67c626d853.jpg');
INSERT INTO comic (comic_id, comic_title, description, cover_url) VALUES ('99326','Symbiote Spider-Man 2099 (2024) #5','BROTHER AGAINST BROTHER!','http://i.annihil.us/u/prod/marvel/i/mg/6/b0/66a7f5e52491a.jpg');
INSERT INTO comic (comic_id, comic_title, description, cover_url) VALUES ('112237','Spider-Boy (2023) #8','INTRODUCING PUZZLE MAN!','http://i.annihil.us/u/prod/marvel/i/mg/e/a0/66634e7855648.jpg');
INSERT INTO comic (comic_id, comic_title, description, cover_url) VALUES ('101184','Spider-Man: Reign 2 (2024) #3','Old Man Peter Parker is lashing out and making wildly bad decisions, but what else is new?','http://i.annihil.us/u/prod/marvel/i/mg/4/70/6669b88583b5b.jpg');

COMMIT TRANSACTION;
