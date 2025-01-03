package com.bmw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
   
    List<Vehicle> findByAvailability(boolean availability);

   
    List<Vehicle> findByModel(String model);


   
    List<Vehicle> findByPriceLessThan(double price);

   
    List<Vehicle> findByColor(String color);

    
    List<Vehicle> findByBodyType(String bodyType);

    List<Vehicle> findByTransmission(String transmission);
    List<Vehicle> findByEngine (String engine);

}
