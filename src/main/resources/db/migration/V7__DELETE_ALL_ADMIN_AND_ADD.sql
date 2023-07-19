DELETE FROM user_role WHERE user_id = '1';

INSERT INTO user_role (user_id, roles)
VALUES (1, 'ADMIN');