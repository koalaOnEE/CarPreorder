package com.bmw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/vehicles{model}/{year}")

public void insert(@PathVariable("model")String model, @PathVariable("year")int year){
    System.out.println(model);
    System.out.println(year);
}
@GetMapping
public List<Vehicle> getAllVehicles() {
    return vehicleRepository.findAll();
}
  
}
