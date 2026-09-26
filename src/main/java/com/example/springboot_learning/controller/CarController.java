package com.example.springboot_learning.controller;

import org.springframework.web.bind.annotation.*;

import com.example.springboot_learning.dto.CarResponse;
import com.example.springboot_learning.dto.CarRequest;
import com.example.springboot_learning.entity.Car;
import com.example.springboot_learning.service.*;

import jakarta.validation.Valid;

import java.util.*;
import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }
    @GetMapping("/cars")
    public List<CarResponse> findAllCar(){
        return carService.getCar();
    }

    @GetMapping("/cars/{id}")
    public CarResponse getCarById(@PathVariable Long id){
        return carService.findCarById(id);
    }

    @GetMapping("/cars/search")
    public String getCarByBrand(@RequestParam String brand){ // can also define like (@RequestParam(brand) String newBrand)
        return "Car Brand = " + brand;
    }

    @PostMapping("/cars/insert")
    public CarResponse saveCar(@Valid @RequestBody CarRequest carRequest){
        return carService.saveCar(carRequest);
    }

    @PutMapping("/cars/update/{id}")
    public CarResponse updateCarById(@PathVariable Long id, @RequestBody CarRequest carRequest){
        return carService.updateCarById(id, carRequest);
    }

     @DeleteMapping("/cars/delete/{id}")
    public void DeleteCarById(@PathVariable Long id){
        carService.deleteCarById(id);
    }

    @GetMapping("/cars/transactionalTest")
    public String TransactionalTest() throws Exception{

        carService.TransactionalTestA();

        return "transaction completed";
    }

}
