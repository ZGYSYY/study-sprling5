## 7.1 示例代码的示例数据模型

以下是创建本章示例所需表的脚本：
```sql
CREATE TABLE singer(
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(60) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	birth_date DATE,
    version INT NOT NULL DEFAULT 0,
	UNIQUE UQ_SINGER_1 (first_name, last_name),
	PRIMARY KEY (id)
);

CREATE TABLE album(
	id INT NOT NULL AUTO_INCREMENT,
	singer_id INT NOT NULL,
	title VARCHAR(100) NOT NULL,
	release_date DATE,
    version INT NOT NULL DEFAULT 0,
	UNIQUE UQ_SINGER_ALBUM_1 (singer_id, title),
	PRIMARY KEY (id),
	CONSTRAINT FK_ALBUM_SINGER FOREIGN KEY (singer_id) REFERENCES singer (id)
);

CREATE TABLE instrument(
	instrument_id VARCHAR(20) NOT NULL,
	PRIMARY KEY(instrument_id)
);

CREATE TABLE singer_instrument(
	singer_id INT NOT NULL,
	instrument_id VARCHAR(20) NOT NULL,
	PRIMARY KEY(singer_id, instrument_id),
	CONSTRAINT fk_singer_instrument_1 FOREIGN KEY(singer_id) REFERENCES singer(id) ON DELETE CASCADE,
	CONSTRAINT fk_singer_instrument_2 FOREIGN KEY(instrument_id) REFERENCES instrument(instrument_id)
);
```

以下SQL是用于数据填充的脚本：
```sql
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
```