CREATE TABLE categories
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(120) NOT NULL,
    `description` VARCHAR(400) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE events
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    title           VARCHAR(180) NOT NULL,
    `description`   VARCHAR(2000) NULL,
    start_date_time datetime     NOT NULL,
    end_date_time   datetime     NOT NULL,
    status          VARCHAR(20)  NOT NULL,
    capacity        INT NULL,
    price           DECIMAL(12, 2) NULL,
    category_id     BIGINT       NOT NULL,
    venue_id        BIGINT       NOT NULL,
    organizer_id    BIGINT NULL,
    CONSTRAINT pk_events PRIMARY KEY (id)
);

CREATE TABLE `role`
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE user_role
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT pk_user_role PRIMARY KEY (role_id, user_id)
);

CREATE TABLE users
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    user_type  VARCHAR(20) NULL,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    last_name  VARCHAR(50)  NOT NULL,
    first_name VARCHAR(50)  NOT NULL,
    phone      VARCHAR(255) NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE venues
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(160) NOT NULL,
    address  VARCHAR(200) NOT NULL,
    capacity INT NULL,
    CONSTRAINT pk_venues PRIMARY KEY (id)
);

ALTER TABLE `role`
    ADD CONSTRAINT uc_role_name UNIQUE (name);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE events
    ADD CONSTRAINT FK_EVENTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);

ALTER TABLE events
    ADD CONSTRAINT FK_EVENTS_ON_ORGANIZER FOREIGN KEY (organizer_id) REFERENCES users (id);

ALTER TABLE events
    ADD CONSTRAINT FK_EVENTS_ON_VENUE FOREIGN KEY (venue_id) REFERENCES venues (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_role FOREIGN KEY (role_id) REFERENCES `role` (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_user FOREIGN KEY (user_id) REFERENCES users (id);