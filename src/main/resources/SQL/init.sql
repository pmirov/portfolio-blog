CREATE DATABASE my_web_site;

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       email VARCHAR(100) UNIQUE NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       role VARCHAR(10) DEFAULT 'USER',
                       created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                       telegram_id VARCHAR(50),
                       profile_image_url TEXT
);

CREATE TABLE projects (
                          id SERIAL PRIMARY KEY,
                          user_id INT NOT NULL REFERENCES users(id)ON DELETE CASCADE,
                          title VARCHAR(255) NOT NULL,
                          description TEXT,
                          created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMPTZ,
                          is_public BOOLEAN DEFAULT TRUE,
                          github_url TEXT
);


CREATE TABLE diary_entries (
                               id SERIAL PRIMARY KEY,
                               user_id INT NOT NULL REFERENCES users(id)ON DELETE CASCADE,
                               title VARCHAR(255) NOT NULL,
                               content TEXT,
                               created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMPTZ,
                               is_public BOOLEAN DEFAULT TRUE
);


CREATE TABLE entry_images (
                              id SERIAL PRIMARY KEY,
                              entry_id INT NOT NULL REFERENCES diary_entries(id)ON DELETE CASCADE,
                              image_url TEXT NOT NULL
);

CREATE TABLE comments (
                          id SERIAL PRIMARY KEY,
                          user_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                          entry_id INT NOT NULL REFERENCES diary_entries(id) ON DELETE CASCADE,
                          content VARCHAR(255) NOT NULL,
                          created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
