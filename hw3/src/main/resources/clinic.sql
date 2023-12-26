DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS clinic;

CREATE TABLE clinic (
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    address VARCHAR
);

CREATE TABLE doctors (
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    profession VARCHAR,
    clinic_id INTEGER NOT NULL REFERENCES clinic(id)
);

INSERT INTO clinic (name, address)
VALUES ('Клиника 1','где-то'),
       ('Клиника 2','там-то');

INSERT INTO doctors (name, profession, clinic_id)
VALUES ('ФИО 1','Терапевт',1),
       ('ФИО 2','Терапевт',1),
       ('ФИО 3','Хирург',1),
       ('ФИО 4','Хирург',2),
       ('ФИО 5','Терапевт',2),
       ('ФИО 6','Травмотолог',2);

SELECT d.name AS ФИО, d.profession AS Профессия, c.name AS Клиника, c.address AS Адрес
FROM clinic c
INNER JOIN doctors d on d.clinic_id = c.id;
