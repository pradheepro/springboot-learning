package com.example.springboot_learning;

import org.springframework.stereotype.*;

@Component
public class Engine {
    public void start(){
        System.out.println("engine started....");
    }
}
