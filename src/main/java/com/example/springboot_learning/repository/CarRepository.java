package com.example.springboot_learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_learning.entity.Car;

public interface CarRepository extends JpaRepository <Car,Long>{

}
