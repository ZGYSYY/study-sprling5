CREATE TABLE singer(
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(60) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	birth_date DATE,
    version INT NOT NULL DEFAULT 0,
	UNIQUE UQ_SINGER_1(first_name, last_name),
	PRIMARY KEY (id)
);

CREATE TABLE album(
	id INT NOT NULL AUTO_INCREMENT,
	singer_id INT NOT NULL,
	title VARCHAR(100) NOT NULL,
	release_date DATE,
    version INT NOT NULL DEFAULT 0,
	UNIQUE UQ_SINGER_ALBUM_1(singer_id, title),
	PRIMARY KEY (id),
	CONSTRAINT FK_ALBUM_SINGER FOREIGN KEY(singer_id) REFERENCES singer(id)
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