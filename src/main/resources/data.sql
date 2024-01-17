CREATE TABLE IF NOT EXISTS users (
                                     id BIGSERIAL PRIMARY KEY,
                                     username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
    );


INSERT INTO users (username, password)
SELECT 'admin', '$2a$12$vNN.gHzJul9MZQGvlzuTOuqpC6Mfx3bXbN9eQ25k/.RrsDDvX9G3C'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'admin');