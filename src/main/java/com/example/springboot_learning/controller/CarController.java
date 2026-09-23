package com.example.springboot_learning.controller;

import org.springframework.web.bind.annotation.*;

import com.example.springboot_learning.dto.carRequest;
import com.example.springboot_learning.dto.carResponse;
import com.example.springboot_learning.entity.Car;
import com.example.springboot_learning.service.*;

import java.util.*;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }
    @GetMapping("/cars")
    public List<carResponse> findAllCar(){
        return carService.getCar();
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable Long id){
        return carService.findCarById(id);
    }

    @GetMapping("/cars/search")
    public String getCarByBrand(@RequestParam String brand){ // can also define like (@RequestParam(brand) String newBrand)
        return "Car Brand = " + brand;
    }

    @PostMapping("/car/insert")
    public carResponse saveCar(@RequestBody carRequest carRequest){
        return carService.saveCar(carRequest);
    }

    @PutMapping("/car/update/{id}")
    public Car updateCarById(@PathVariable Long id, @RequestBody Car car){
        return carService.updateCarById(id, car);
    }

     @DeleteMapping("/car/delete/{id}")
    public void updateCarById(@PathVariable Long id){
        carService.deleteCarById(id);
    }

}
