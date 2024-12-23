package com.bmw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    // JpaRepository provides built-in methods like findAll(), findById(), save(), etc.
}
