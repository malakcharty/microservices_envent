CREATE TABLE categories (
                            id BIGINT NOT NULL AUTO_INCREMENT,
                            name VARCHAR(150) NOT NULL,
                            description VARCHAR(1000),
                            PRIMARY KEY (id),
                            UNIQUE (name)
) ENGINE=InnoDB;

CREATE TABLE venues (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        name VARCHAR(200) NOT NULL,
                        address VARCHAR(255),
                        city VARCHAR(100) NOT NULL,
                        capacity INT,
                        indoor BIT NOT NULL,
                        description VARCHAR(1000),
                        PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE events (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        title VARCHAR(255),
                        description VARCHAR(2000),
                        event_date DATE,
                        status ENUM('PLANNED','OPEN_FOR_REGISTRATION','IN_PROGRESS','COMPLETED','CANCELLED'),
                        capacity INT,
                        organizer_id BIGINT,
                        category_id BIGINT,
                        venue_id BIGINT,
                        PRIMARY KEY (id),
                        CONSTRAINT fk_event_category FOREIGN KEY (category_id) REFERENCES categories(id),
                        CONSTRAINT fk_event_venue FOREIGN KEY (venue_id) REFERENCES venues(id)
) ENGINE=InnoDB;
