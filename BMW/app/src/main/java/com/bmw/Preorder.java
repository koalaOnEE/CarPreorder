package com.bmw;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity

@Table(name = "preorders")
public class Preorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

   private String customerName;
    private String customerEmail;
    private Integer preorderID;
    private LocalDateTime preorderDate;

  @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false) // Foreign key column in the 'preorders' table
    private Vehicle vehicle; 

    public Integer getPreorderID() {
        return preorderID;
    }

    public void setPreorderID(Integer preorderID) {
        this.preorderID = preorderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getPreorderDate() {
        return preorderDate;
    }

    public void setPreorderDate(LocalDateTime preorderDate) {
        this.preorderDate = preorderDate;
    }


}
