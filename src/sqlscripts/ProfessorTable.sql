USE acadio;

CREATE TABLE professor_tb (
  professor_id INT PRIMARY KEY IDENTITY(1,1),
  professor_name NVARCHAR(100) NOT NULL,
  professor_password VARCHAR(20)
);

-- Inserts a professor named 'Anthony' with a password '1234567890' into the professor table
INSERT INTO professor_tb VALUES ('Anthony', '1234567890');

SELECT * FROM professor_tb;

USE acadio;
DROP TABLE professor_tb;