package com.bmw;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmw.exception.ResourceNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/preorders")
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

    // Get a specific preorder by ID
    @GetMapping("/{id}")
    public ResponseEntity<Preorder> getPreorderById(@PathVariable Integer id) {
        Preorder preorder = preorderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Preorder not found with ID: " + id));
        return ResponseEntity.ok(preorder);
    }

    // Create a new preorder
    @PostMapping
    public ResponseEntity<Preorder> createPreorder(@Valid @RequestBody Preorder preorder) {
        // Check if the vehicle exists
        Vehicle vehicle = vehicleRepository.findById(preorder.getVehicle().getvehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with ID: " + preorder.getVehicle().getvehicleId()));

        // Ensure the vehicle is available
        if (!vehicle.availability()) {
            throw new RuntimeException("Vehicle is not available for preorder.");
        }

        // Set the preorder date to the current time
        preorder.setPreorderDate(LocalDateTime.now());

        // Save the preorder
        Preorder savedPreorder = preorderRepository.save(preorder);

        // Mark the vehicle as unavailable
        vehicle.setAvailability(false);
        vehicleRepository.save(vehicle);

        return ResponseEntity.status(201).body(savedPreorder); // Return 201 Created
    }

    // Update an existing preorder
    @PutMapping("/{id}")
    public ResponseEntity<Preorder> updatePreorder(
            @PathVariable Integer id,
            @Valid @RequestBody Preorder preorderDetails) {

        Preorder preorder = preorderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Preorder not found with ID: " + id));

        // Update preorder details
        preorder.setCustomerName(preorderDetails.getCustomerName());
        preorder.setCustomerEmail(preorderDetails.getCustomerEmail());

        // Update associated vehicle if necessary
        if (preorderDetails.getVehicle() != null) {
            Vehicle vehicle = vehicleRepository.findById(preorderDetails.getVehicle().getvehicleId())
                    .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with ID: " + preorderDetails.getVehicle().getvehicleId()));
            preorder.setVehicle(vehicle);
        }

        Preorder updatedPreorder = preorderRepository.save(preorder);
        return ResponseEntity.ok(updatedPreorder);
    }

    // Delete a preorder
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreorder(@PathVariable Integer id) {
        Preorder preorder = preorderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Preorder not found with ID: " + id));

        // Mark the associated vehicle as available
        Vehicle vehicle = preorder.getVehicle();
        vehicle.setAvailability(true);
        vehicleRepository.save(vehicle);

        preorderRepository.delete(preorder);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
