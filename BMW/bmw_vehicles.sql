DROP TABLE IF EXISTS vehicles;

CREATE TABLE vehicles (
    vehicle_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    make VARCHAR(50) NOT NULL,
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


INSERT INTO vehicles (make, model, year, price, color, body_type, engine, transmission, availability, features)
VALUES
('BMW', 'X1', 2024, 41000, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
('BMW', 'X2', 2024, 43000, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
('BMW', 'X3', 2024, 49500, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
('BMW', 'X4', 2024, 55300, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
('BMW', 'X5', 2024, 65700, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
('BMW', 'X6', 2024, 74500, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
('BMW', 'X7', 2024, 83000, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
('BMW', 'iX', 2024, 87000, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
('BMW', '2 Series', 2024, 41600, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
('BMW', '3 Series', 2024, 45000, 'White', 'Sedan', 'Diesel', 'Manual', true, 'Heated seats, Bluetooth'),
('BMW', '4 Series', 2024, 65000, 'Black', 'SUV', 'Petrol', 'Automatic', true, 'Sunroof, Navigation'),
('BMW', 'i8', 2023, 140000, 'Blue', 'Coupe', 'Hybrid', 'Automatic', false, 'Hybrid engine, Navigation');

