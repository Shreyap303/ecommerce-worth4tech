CREATE TABLE user (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(100) NOT NULL,
  user_name varchar(50) NOT NULL,
  password varchar(250) NOT NULL,
  role varchar(20) NOT NULL,
  PRIMARY KEY (id)
);