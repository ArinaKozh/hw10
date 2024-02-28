create table tasks (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
status VARCHAR(50) NOT NULL,
description varchar(50) NOT NULL,
creation_date date
);