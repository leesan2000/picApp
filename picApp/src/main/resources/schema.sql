CREATE TABLE IF NOT EXISTS photos (
    data BINARY,
    id BIGINT PRIMARY KEY,
    content_type VARCHAR(255),
    file_name VARCHAR(255)
);