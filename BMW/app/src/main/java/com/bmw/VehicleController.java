package com.bmw;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173") // Allow frontend origin
@RestController
@RequestMapping("/api/vehicles") // Base path for all endpoints in this controller
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll(); // Fetches all vehicles from the database
    }
  
@GetMapping("/available")
public List<Vehicle> getAvaliabVehicles() {
    return vehicleRepository.findByAvailability(true);
}


@GetMapping("/{id}")
public ResponseEntity<Vehicle> getVehicleId (@PathVariable Integer Id) {
    Optional<Vehicle> vehicle = vehicleRepository.findById(Id);
    return vehicle.map(ResponseEntity::ok)
    .orElse(ResponseEntity.notFound().build());
}

 @GetMapping("/model/{model}")
    public List<Vehicle> getVehiclesByModel(@PathVariable String model) {
        return vehicleRepository.findByModel(model);
    }

    @GetMapping("/price/less-than/{price}")
    public List<Vehicle> getVehiclesByPrice(@PathVariable double price) {
        return vehicleRepository.findByPriceLessThan(price);
    }

   
    @GetMapping("/color/{color}")
    public List<Vehicle> getVehiclesByColor(@PathVariable String color) {
        return vehicleRepository.findByColor(color);
    }

    
    @GetMapping("/body-type/{bodyType}")
    public List<Vehicle> getVehiclesByBodyType(@PathVariable String bodyType) {
        return vehicleRepository.findByBodyType(bodyType);
    }

   
    @PutMapping("/{id}/availability")
    public ResponseEntity<Vehicle> updateVehicleAvailability(
            @PathVariable Integer id,
            @RequestParam boolean availability) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            vehicle.setAvailability(availability);
            Vehicle updatedVehicle = vehicleRepository.save(vehicle);
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
