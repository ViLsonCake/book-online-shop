DROP TABLE book_warehouse;

CREATE TABLE book_warehouse (
    warehouse_id SERIAL PRIMARY KEY,
    book_id BIGINT NOT NULL UNIQUE,
    count INT NOT NULL
);