DROP TABLE IF EXISTS person_bank;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS bank;

CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR
);

CREATE TABLE bank (
    id SERIAL PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE person_bank (
    id BIGSERIAL PRIMARY KEY,
    person_id INTEGER NOT NULL REFERENCES person,
    bank_id INTEGER NOT NULL REFERENCES bank,
    UNIQUE (person_id,bank_id)
);

INSERT INTO bank (id, name)
VALUES (1, 'Сбер'),
       (2, 'Тинькофф'),
       (3, 'Райффайзен'),
       (4, 'ВТБ');

INSERT INTO person (id, full_name)
VALUES (1, 'Иванов Сидор Петрович'),
       (2, 'Сидоров Петр Иванович'),
       (3, 'Петров Иван Сидорович'),
       (4, 'Наличный Артем Андреевич');

INSERT INTO person_bank (person_id, bank_id)
VALUES (1, 1),
       (1, 3),
       (2, 2),
       (2, 3),
       (2, 4),
       (3, 1),
       (3, 4);

SELECT p.full_name AS ФИО, b.name AS БАНК
FROM person p
         LEFT JOIN person_bank pb ON pb.person_id = p.id
         LEFT JOIN bank b ON b.id = pb.bank_id;