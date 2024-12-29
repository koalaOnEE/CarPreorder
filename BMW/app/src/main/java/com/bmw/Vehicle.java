package com.bmw;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleId;
  //  private double id;
  // private String make;
    private String model;
    private double year;
    private double price;
    private String color;
    private String engine;
    private String body_type;
    private String transmission;

    private boolean availability;
    private String features;

    // Getters and setters
    public Integer getvehicleId() {
        return vehicleId;
    }

    public void setvehicleID(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }
   // public double getId() {
  //      return id;
  //  }

  //  public void setId(double id) {
    //    this.id = id;
   // }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getyear(){
        return year;
    }
    public void setyear(double year)
    {
        this.year = year;
    }

    public double getprice(){
        return price;
    }
    public void setprice(double price)
    {
        this.price = price;
    }

    public String getcolor(){
        return color;
    }
    public void setcolor(String color)
    {
        this.color = color;
    }


    public String getbody_type(){
        return body_type;
    }
    public void setbody_type(String body_type)
    {
        this.body_type = body_type;
    }

    public String getengine(){
        return engine;
    }
    public void setengine(String engine)
    {
        this.engine = engine;
    }

    public String gettransmission(){
        return transmission;
    }
    public void settransmission(String transmission)
    {
        this.transmission = transmission;
    }

public boolean availability(){
    return availability;
}

public void setAvailability(boolean availability) {
    this.availability = availability;
}

    public String features() {
        return features;
    }

    public void setfeatures(String features) {
        this.features = features;
    }
}
