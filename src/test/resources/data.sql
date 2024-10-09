CREATE TABLE IF NOT EXISTS users (
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(250) NOT NULL,
email VARCHAR(250) NOT NULL,
password VARCHAR(250) NOT NULL
);
INSERT INTO users (username, email, password) VALUES
('Guillaume', 'guillaume.nagiel@gmail.com', 'guillaume'),
('test', 'test.test@test.com', 'test');