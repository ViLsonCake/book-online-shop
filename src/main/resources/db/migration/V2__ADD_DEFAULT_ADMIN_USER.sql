INSERT INTO user_ (email, password, first_name, last_name, phone_number)
VALUES ('admin@gmail.com', '$2a$10$.DxdDNgzLHHJvaZUMIMm0ufo5Qlob.xeg/Sg8UUfEX9xAuCKxUgUu', 'admin', 'admin', 'admin')
ON CONFLICT (email) DO NOTHING;

INSERT INTO user_role (user_id, roles)
VALUES (1, 'ROLE_ADMIN')
ON CONFLICT (user_id) DO NOTHING;