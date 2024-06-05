CREATE DATABASE acadio;
USE acadio;
SELECT * FROM sys.databases;

USE acadio;
CREATE TABLE student_tb (
  student_id INT PRIMARY KEY IDENTITY(1,1),
  student_name NVARCHAR(100) NOT NULL,
  student_landline VARCHAR(20),
  student_cellphone VARCHAR(20),
  student_dob DATE,
  program_or_course NVARCHAR(50),
  date_of_enrolment DATE,
  student_address NVARCHAR(100),
  student_gender CHAR(1) CHECK (student_gender IN ('M', 'F', 'N')), -- Limit to M, F or N
  student_gender_identity NVARCHAR(50),
  student_obs NVARCHAR(MAX)
);

USE acadio;
-- Insert test data
INSERT INTO student_tb VALUES (1, 'John Doe', '12345678', '87654321', '1990-01-01', 'Computer Science', '2019-01-01', '123 Main St', 'M', null, null);

SELECT * FROM student_tb;

DROP DATABASE acadio;