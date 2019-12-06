## 9.6 使用 Spring 实现全局事务

**SQL如下**
```sql
CREATE SCHEMA  musicdb_a;

CREATE SCHEMA  musicdb_b;

CREATE user 'prospring5_a'@'localhost' IDENTIFIED BY 'prospring5_a';
GRANT ALL PRIVILEGES ON musicdb_a.* TO 'prospring5_a'@'localhost';

CREATE user 'prospring5_b'@'localhost' IDENTIFIED BY 'prospring5_b';
GRANT ALL PRIVILEGES ON musicdb_b.* TO 'prospring5_b'@'localhost';

CREATE TABLE SINGER (
       ID INT NOT NULL AUTO_INCREMENT
     , FIRST_NAME VARCHAR(60) NOT NULL
     , LAST_NAME VARCHAR(40) NOT NULL
     , BIRTH_DATE DATE
     , `VERSION` INT DEFAULT 0
     , UNIQUE UQ_SINGER_1 (FIRST_NAME, LAST_NAME)
     , PRIMARY KEY (ID)
);
```