INSERT INTO singer (first_name, last_name, birth_date) VALUES('John', 'Mayer', '1977-10-16');
INSERT INTO singer (first_name, last_name, birth_date) VALUES('Eric', 'Clapton', '1945-03-30');
INSERT INTO singer (first_name, last_name, birth_date) VALUES('John', 'Butler', '1975-04-01');

INSERT INTO album (singer_id, title, release_date) VALUES(1, 'The Search For Everything', '2017-01-20');
INSERT INTO album (singer_id, title, release_date) VALUES(1, 'Battle Studies', '2009-11-17');
INSERT INTO album (singer_id, title, release_date) VALUES(2, 'From The Cradle', '1994-09-13');

insert into instrument (instrument_id) VALUES('Guitar');
insert into instrument (instrument_id) VALUES('Piano');
insert into instrument (instrument_id) VALUES('Voice');
insert into instrument (instrument_id) VALUES('Drums');
insert into instrument (instrument_id) VALUES('Synthesizer');

INSERT INTO singer_instrument(singer_id, instrument_id) VALUES (1, 'Guitar');
INSERT INTO singer_instrument(singer_id, instrument_id) VALUES (1, 'Piano');
INSERT INTO singer_instrument(singer_id, instrument_id) VALUES (2, 'Guitar');
