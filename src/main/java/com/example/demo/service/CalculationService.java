package com.example.demo.service;

import com.example.demo.exception.WrongParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    private final Logger log = LoggerFactory.getLogger(CalculationService.class);

    public Integer sum(Integer a, Integer b) {
        if (a == null) {
            throw new WrongParameterException("First argument is null. Please put correct data.");
        }
        if (b == null) {
            throw new WrongParameterException("Second argument is null. Please put correct data.");
        }
        return a + b;
    }

}
