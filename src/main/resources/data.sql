CREATE TABLE Person (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        first_name VARCHAR(8) NOT NULL,
                        last_name VARCHAR(255) NOT NULL,
                        last_update_dt VARCHAR(8) NOT NULL,
                        PRIMARY KEY (id)
);

INSERT INTO Person (first_name, last_name, last_update_dt) VALUES ('Chanmi', 'Jeong', '20240505');
INSERT INTO Person (first_name, last_name, last_update_dt) VALUES ('Tina', 'Kim', '20240505');