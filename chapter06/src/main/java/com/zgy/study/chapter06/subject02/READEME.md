## 6.2 示例代码的示例数据模型

创建数据库和表语句
```sql
CREATE user 'zgytest'@'localhost' IDENTIFIED BY '123456';

CREATE SCHEMA MUSICDB;

GRANT ALL PRIVILEGES ON MUSICDB.* TO 'zgytest'@'localhost';

FLUSH PRIVILEGES;

USE musicdb;

CREATE TABLE singer(
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(60) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	birth_date DATE,
	UNIQUE UQ_SINGER_1 (first_name, last_name),
	PRIMARY KEY (id)
);

CREATE TABLE album(
	id INT NOT NULL AUTO_INCREMENT,
	singer_id INT NOT NULL,
	title VARCHAR(100) NOT NULL,
	release_date DATE,
	UNIQUE UQ_SINGER_ALBUM_1 (singer_id, title),
	PRIMARY KEY (id),
	CONSTRAINT FK_ALBUM FOREIGN KEY (singer_id) REFERENCES singer (id)
);
```

向数据表中插入数据 SQL 语句
```sql
INSERT INTO singer (first_name, last_name, birth_date) VALUES('John', 'Mayer', '1977-10-16');
INSERT INTO singer (first_name, last_name, birth_date) VALUES('Eric', 'Clapton', '1945-03-30');
INSERT INTO singer (first_name, last_name, birth_date) VALUES('John', 'Butler', '1975-04-01');
```

```sql
INSERT INTO album (singer_id, title, release_date) VALUES(1, 'The Search For Everything', '2017-01-20');
INSERT INTO album (singer_id, title, release_date) VALUES(1, 'Battle Studies', '2009-11-17');
INSERT INTO album (singer_id, title, release_date) VALUES(2, 'From The Cradle', '1994-09-13');
```