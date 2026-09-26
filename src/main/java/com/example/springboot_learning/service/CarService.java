package com.example.springboot_learning.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot_learning.dto.CarRequest;
import com.example.springboot_learning.dto.CarResponse;
import com.example.springboot_learning.entity.Car;
import com.example.springboot_learning.exception.CarNotFoundException;
import com.example.springboot_learning.repository.CarRepository;

import java.util.*;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarResponse saveCar(CarRequest CarRequest) {
        Car car = new Car();

        car.setBrand(CarRequest.getBrand());
        car.setModel(CarRequest.getModel());

        Car savedCar = carRepository.save(car);

        CarResponse response = new CarResponse();

        response.setId(savedCar.getId());
        response.setBrand(savedCar.getBrand());
        response.setModel(savedCar.getModel());

        return response;
    }

    public List<CarResponse> getCar(){

        List<Car> cars = carRepository.findAll();


        return cars.stream()
                .map(car -> {
                    CarResponse response = new CarResponse();

                    response.setId(car.getId());
                    response.setBrand(car.getBrand());
                    response.setModel(car.getModel());

                    return response;
                })
                .toList();
    }

    public CarResponse findCarById(Long id){

        Car car = carRepository.findById(id).orElseThrow(() ->
                    new CarNotFoundException("Car not found with id: " + id));
        CarResponse response = new CarResponse();

        response.setId(car.getId());
        response.setBrand(car.getBrand());
        response.setModel(car.getModel());

        return response;
    }

    public CarResponse updateCarById(Long id, CarRequest updatedCar){

        Car existingCar = carRepository.findById(id).orElseThrow(() ->
                    new CarNotFoundException("Car not found with id: " + id));

        existingCar.setBrand(updatedCar.getBrand());
        existingCar.setModel(updatedCar.getModel());


        Car updateResult = carRepository.save(existingCar);

        CarResponse response = new CarResponse();

        response.setId(updateResult.getId());
        response.setBrand(updateResult.getBrand());
        response.setModel(updateResult.getModel());

        return response;
    }

    public void deleteCarById(Long id){
         
        Car car = carRepository.findById(id).orElseThrow(() ->
                    new CarNotFoundException("Car not found with id: " + id));

        carRepository.delete(car);
    }

    @Transactional
    public void TransactionalTestA() throws Exception{
        Car car = new Car();

        car.setBrand("TestA");
        car.setModel("TA");

        carRepository.save(car);

        TransactionalTestB();

        throw new Exception("Something went wrong");
    }

    @Transactional
    public void TransactionalTestB(){
        Car car = new Car();

        car.setBrand("TestB");
        car.setModel("TB");

        carRepository.save(car);
    }
}
