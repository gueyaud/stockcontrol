INSERT INTO users(username,password,enabled)
VALUES ('ngoc','123', true);
INSERT INTO user_roles (username, role)
VALUES ('ngoc', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('ngoc', 'ROLE_USER');