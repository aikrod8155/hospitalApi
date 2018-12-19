DROP TABLE IF EXITS t_hospital;
CREATE TABLE t_hospital
(
	city varchar(100) DEFAULT NULL,
  	name varchar(100) DEFAULT NULL,
  	seq varchar(100) DEFAULT NULL,
  	grade1 varchar(180) DEFAULT NULL,
  	grade2 varchar(180) DEFAULT NULL,
 	time1 varchar(180) DEFAULT NULL,
  	time2 varchar(180) DEFAULT NULL,
  	tel varchar(180) DEFAULT NULL,
  	address varchar(300) DEFAULT NULL


)
COMMENT 't_hospital';

