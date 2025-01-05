package com.bmw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preorders") // Base path for Preorder-related endpoints
public class PreorderController {

    @Autowired
    private PreorderRepository preorderRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    // Get all preorders
    @GetMapping
    public ResponseEntity<List<Preorder>> getAllPreorders() {
        List<Preorder> preorders = preorderRepository.findAll();
        return ResponseEntity.ok(preorders);
    }

    // Get a preorder by ID
    @GetMapping("/{id}")
    public ResponseEntity<Preorder> getPreorderById(@PathVariable Integer id) {
        Optional<Preorder> preorder = preorderRepository.findById(id);
        if (preorder.isPresent()) {
            return ResponseEntity.ok(preorder.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new preorder
    @PostMapping
    public ResponseEntity<Preorder> createPreorder(@RequestBody Preorder preorder) {
        // Validate vehicle existence
        Vehicle vehicle = vehicleRepository.findById(preorder.getVehicle().getvehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        // Ensure vehicle availability
        if (!vehicle.availability()) {
            return ResponseEntity.badRequest().body(null); // Return 400 Bad Request if vehicle is unavailable
        }

        preorder.setVehicle(vehicle); // Associate vehicle with preorder
        Preorder savedPreorder = preorderRepository.save(preorder); // Save preorder to database

        // Mark vehicle as unavailable
        vehicle.setAvailability(false);
        vehicleRepository.save(vehicle);

        return ResponseEntity.ok(savedPreorder);
    }

    // Update an existing preorder
    @PutMapping("/{id}")
    public ResponseEntity<Preorder> updatePreorder(
        @PathVariable Integer id, @RequestBody Preorder preorderDetails) {
        Preorder preorder = preorderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preorder not found"));

        preorder.setCustomerName(preorderDetails.getCustomerName());
        preorder.setCustomerEmail(preorderDetails.getCustomerEmail());

        // Optional: Update associated vehicle if necessary
        if (preorderDetails.getVehicle() != null) {
            Vehicle vehicle = vehicleRepository.findById(preorderDetails.getVehicle().getvehicleId())
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));
            preorder.setVehicle(vehicle);
        }

        Preorder updatedPreorder = preorderRepository.save(preorder);
        return ResponseEntity.ok(updatedPreorder);
    }

    // Delete a preorder
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreorder(@PathVariable Integer id) {
        Preorder preorder = preorderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preorder not found"));

        // Re-mark the associated vehicle as available
        Vehicle vehicle = preorder.getVehicle();
        vehicle.setAvailability(true);
        vehicleRepository.save(vehicle);

        preorderRepository.delete(preorder);
        return ResponseEntity.noContent().build();
    }
}
