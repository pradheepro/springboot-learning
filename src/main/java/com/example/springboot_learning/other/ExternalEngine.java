package com.example.springboot_learning.other;

import org.springframework.stereotype.Component;

@Component
public class ExternalEngine {

    public void start() {
        System.out.println("External engine started");
    }
}