DROP TABLE IF EXISTS preorders;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS vehicles;

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE vehicles (
    vehicle_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    model VARCHAR(100) NOT NULL,
    year INT NOT NULL,
    price DECIMAL(10, 2),
    color VARCHAR(50),
    body_type VARCHAR(50) NOT NULL,
    engine VARCHAR(100) NOT NULL,
    transmission VARCHAR(50) NOT NULL,
    availability BOOLEAN DEFAULT TRUE,
    features TEXT
);

CREATE TABLE preorders (
    preorder_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    customer_email VARCHAR(200) NOT NULL,
    vehicle_id INT NOT NULL,
    preorder_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id) ON DELETE CASCADE
);

INSERT INTO vehicles (model, year, price, color, body_type, engine, transmission, availability, features)
VALUES
( 'X1', 2024, 41000, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
( 'X2', 2024, 43000, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
( 'X3', 2024, 49500, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
( 'X4', 2024, 55300, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
( 'X5', 2024, 65700, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
( 'X6', 2024, 74500, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
( 'X7', 2024, 83000, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
( 'iX', 2024, 87000, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
( '2 Series', 2024, 41600, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
( '3 Series', 2024, 45000, 'White', 'Sedan', 'Diesel', 'Manual', true, 'Heated' );

