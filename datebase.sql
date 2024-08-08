CREATE DATABASE medicaltest1;

-- Підключення до бази даних
\c medicaltest1

-- Створення таблиці patients
CREATE TABLE patients (
                          id BIGINT SERIAL PRIMARY KEY,
                          patient_name VARCHAR(20),
                          height INT CHECK (height >= 0 AND height <= 999),
                          weight INT CHECK (weight >= 0 AND weight <= 999),
                          special_patient_id INT CHECK (special_patient_id >= 0 AND special_patient_id <= 999999),
                          patient_info VARCHAR(1000)
);