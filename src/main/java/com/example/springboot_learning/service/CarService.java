package com.example.springboot_learning.service;

import org.springframework.stereotype.Service;

import com.example.springboot_learning.dto.carRequest;
import com.example.springboot_learning.dto.carResponse;
import com.example.springboot_learning.entity.Car;
import com.example.springboot_learning.repository.CarRepository;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final AuditService auditService;

    public CarService(CarRepository carRepository, AuditService auditService) {
        this.carRepository = carRepository;
        this.auditService = auditService;
    }

    public carResponse saveCar(carRequest carRequest) {
        Car car = new Car();

        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());

        Car savedCar = carRepository.save(car);

        carResponse response = new carResponse();

        response.setId(savedCar.getId());
        response.setBrand(savedCar.getBrand());
        response.setModel(savedCar.getModel());

        return response;
    }

    public List<carResponse> getCar(){

        List<Car> cars = carRepository.findAll();


        return cars.stream()
                .map(car -> {
                    carResponse response = new carResponse();

                    response.setId(car.getId());
                    response.setBrand(car.getBrand());
                    response.setModel(car.getModel());

                    return response;
                })
                .toList();
    }

    public Car findCarById(Long id){
        return carRepository.findById(id).orElseThrow();
    }

    public Car updateCarById(Long id, Car updatedCar){

        Car existingCar = carRepository.findById(id).orElseThrow();

        existingCar.setBrand(updatedCar.getBrand());
        existingCar.setModel(updatedCar.getModel());

        return carRepository.save(existingCar);
    }

    public void deleteCarById(Long id){
         carRepository.deleteById(id);
    }

    @Transactional
    public void runtimeExceptionTest() {
        Car car = new Car();
        car.setBrand("RollbackTest");
        car.setModel("RuntimeException");

        carRepository.save(car);

        throw new RuntimeException("Testing transaction rollback");
    }

    @Transactional(rollbackFor = Exception.class)
    public void checkedExceptionTest() throws Exception {

        Car car = new Car();
        car.setBrand("CheckedTest");
        car.setModel("NoRollback");

        carRepository.save(car);

        throw new Exception("Testing checked exception");
    }

    @Transactional  //test transaction propagation with REQUIRES_NEW
    public void saveAudit(String message) {
        auditService.saveAudit(message);

        throw new RuntimeException("Testing transaction propagation with REQUIRES_NEW");
    }
}
