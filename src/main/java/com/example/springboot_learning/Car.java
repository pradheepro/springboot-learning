package com.example.springboot_learning;

import org.springframework.stereotype.Component;

@Component 
public class Car {
    public Engine engine;

    public Car(Engine engine){
        this.engine = engine;
    }

    public void drive(){
        engine.start();
        System.out.println("car started to run....");
    }
}
