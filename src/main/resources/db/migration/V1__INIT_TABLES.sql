create table hibernate_sequence (
    next_val bigint
);

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE user_ (
    user_id SERIAL PRIMARY KEY,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    email VARCHAR(64) NOT NULL UNIQUE,
    password TEXT NOT NULL,
    phone_number VARCHAR(32) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE user_role (
    user_id BIGINT NOT NULL UNIQUE,
    roles VARCHAR(32) NOT NULL
);

CREATE TABLE user_avatar (
    avatar_id SERIAL PRIMARY KEY,
    byte_array OID NOT NULL,
    user_id BIGINT
);

CREATE TABLE address (
    address_id SERIAL PRIMARY KEY,
    country VARCHAR(32) NOT NULL,
    city VARCHAR(32) NOT NULL,
    postal_code VARCHAR(32) NOT NULL,
    street VARCHAR(64) NOT NULL,
    user_id BIGINT NOT NULL
);

CREATE TABLE book (
    book_id SERIAL PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    author VARCHAR(64) NOT NULL,
    publisher VARCHAR(64) NOT NULL,
    page INT NOT NULL,
    language VARCHAR(32) NOT NULL,
    binding VARCHAR(32) NOT NULL,
    description TEXT NOT NULL,
    isbn VARCHAR(32) NOT NULL
);

CREATE TABLE book_avatar (
    avatar_id SERIAL PRIMARY KEY,
    byte_array OID NOT NULL,
    book_id BIGINT
);

CREATE TABLE book_warehouse (
    book_id BIGINT NOT NULL UNIQUE,
    count INT NOT NULL
);

CREATE TABLE user_order (
    order_id SERIAL PRIMARY KEY,
    address_id BIGINT NOT NULL
);