CREATE TABLE role (
                      id   BIGINT AUTO_INCREMENT NOT NULL,
                      name VARCHAR(50) NOT NULL,
                      CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE users (
                       id         BIGINT AUTO_INCREMENT NOT NULL,
                       user_type  VARCHAR(20)  NULL,
                       email      VARCHAR(255) NOT NULL,
                       password   VARCHAR(255) NOT NULL,
                       last_name  VARCHAR(50)  NOT NULL,
                       first_name VARCHAR(50)  NOT NULL,
                       phone      VARCHAR(255) NULL,
                       CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE user_role (
                           role_id BIGINT NOT NULL,
                           user_id BIGINT NOT NULL,
                           CONSTRAINT pk_user_role PRIMARY KEY (role_id, user_id)
);

-- Contraintes uniques
ALTER TABLE role
    ADD CONSTRAINT uc_role_name UNIQUE (name);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

-- Clés étrangères
ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_role FOREIGN KEY (role_id) REFERENCES role (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_user FOREIGN KEY (user_id) REFERENCES users (id);
