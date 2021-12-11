CREATE TABLE patient 
(
    id         SERIAL PRIMARY KEY,
    fio        VARCHAR(256) NOT NULL,
    birth_date DATE,
    sex        NUMERIC(1) NOT NULL,
    num        NUMERIC(6),
    smo        VARCHAR(256),
    snils      VARCHAR(11),
    policy     VARCHAR(20),
    fin_source NUMERIC(3)
);
