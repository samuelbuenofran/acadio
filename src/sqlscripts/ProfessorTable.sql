USE acadio;

CREATE TABLE professor_tb (
  professor_id INT PRIMARY KEY IDENTITY(1,1),
  professor_name NVARCHAR(100) NOT NULL
);

INSERT INTO professor_tb VALUES ('Anthony');

SELECT * FROM professor_tb;