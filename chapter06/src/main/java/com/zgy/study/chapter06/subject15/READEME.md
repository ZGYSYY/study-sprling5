## 6.15 使用 SqlFunction 调用存储函数
**存储函数 sql** 
```sql
DELIMITER $$
CREATE FUNCTION get_first_name_by_id(in_id INT) RETURNS VARCHAR(60)
DETERMINISTIC
BEGIN
	RETURN (SELECT first_name FROM singer WHERE id = in_id);
END $$
DELIMITER ;
```