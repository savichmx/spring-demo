package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    private final Logger log = LoggerFactory.getLogger(CalculationService.class);

    private int counter = 0;

    public int sum(int a, int b) {
        counter++;
        log.info("Class instance is: {}", this);
        return a + b;
    }

}
