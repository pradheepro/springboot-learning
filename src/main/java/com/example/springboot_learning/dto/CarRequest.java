package com.example.springboot_learning.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CarRequest {

    @NotBlank(message = "model should not be empty")
    @Size( min = 0, max = 2, message = "model must be less than 3")
    private String model;

    @NotBlank(message = "brand should not be empty")
    private String brand;
    
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    
}
