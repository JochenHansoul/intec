USE jochen;

CREATE TABLE person (
    PRIMARY KEY (person_id),
    person_id   int             NOT NULL,
    first_name  VARCHAR(30)     NOT NULL,
    last_name   VARCHAR(30)     NOT NULL,
    birth_date  DATE            NOT NULL
);
