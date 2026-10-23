CREATE TABLE patient (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    address VARCHAR(255),
    date_of_birth DATE,
    registered_date DATE
);

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date) VALUES
    ('8e3f5a1c-2b74-4d91-a6c8-0f2e5b7a9d31', 'Alice Johnson', 'alice.johnson@example.com', '14 Oak Street, Portland, OR', '1988-04-12', '2024-01-15'),
    ('1c9d7e4b-6a32-4f85-b0d1-3e8a2c5f7b46', 'Mateo Garcia', 'mateo.garcia@example.com', '82 Cedar Avenue, Austin, TX', '1992-09-27', '2024-02-03'),
    ('6b2a8f0d-3c51-4e97-9a64-1d5f8b2c7e30', 'Priya Patel', 'priya.patel@example.com', '305 Maple Road, Raleigh, NC', '1985-12-05', '2024-02-21'),
    ('3f7c1a9e-5d42-4b86-a0f3-2c6e9d1b5a74', 'Noah Williams', 'noah.williams@example.com', '9 Birch Lane, Denver, CO', '2001-06-18', '2024-03-08'),
    ('a4d8c2f6-1b53-49e7-8c0a-5f3d2b6e1a90', 'Zara Ahmed', 'zara.ahmed@example.com', '227 Pine Street, Seattle, WA', '1996-11-30', '2024-03-19');
